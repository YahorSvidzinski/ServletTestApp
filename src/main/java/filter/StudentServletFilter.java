package filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

import static java.lang.String.format;

public class StudentServletFilter implements Filter {

	private static final Logger log = Logger.getLogger(StudentServletFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) {
		log.info("Filter initialized");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info(format("Remote address: %s", servletRequest.getRemoteAddr()));
		servletResponse.setContentType("application/json");
		servletResponse.setCharacterEncoding("UTF-8");
		servletRequest.setCharacterEncoding("UTF-8");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		log.info("Filter destroyed");
	}
}
