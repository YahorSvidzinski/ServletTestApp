package service;

import java.util.List;

public interface StudentService {

	List<String> getAll();

	String getById(Long id);

	void save(String studentJson);

}
