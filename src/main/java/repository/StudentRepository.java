package repository;

import dao.StudentDao;
import model.Student;

import java.util.List;

public interface StudentRepository {

	List<Student> findAll();

	Student findById(Long id);

	void save(StudentDao student);

}
