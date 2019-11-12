package controller;

import com.google.gson.Gson;
import repository.StudentRepositoryImpl;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import static java.lang.Long.parseLong;
import static java.lang.String.*;
import static repository.StudentRepositoryImpl.ID;

public class StudentController extends HttpServlet {

	private static final Logger log = Logger.getLogger(StudentController.class.getName());

	private final StudentService studentService = new StudentServiceImpl(new StudentRepositoryImpl(), new Gson());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter(ID);
			if (id != null) {
				log.info(format("Retrieving user with id %sfrom database", id));
				out.print(studentService.getById(parseLong(id)));
			} else {
				log.info("Retrieving users from database ...");
				studentService.getAll().forEach(out::print);
			}
			out.flush();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder jb = new StringBuilder();
		String line;
		log.info("Creating user ...");
		try (BufferedReader reader = new BufferedReader(request.getReader())) {
			while ((line = reader.readLine()) != null)
				jb.append(line);
		}
		studentService.save(jb.toString());
	}
}
