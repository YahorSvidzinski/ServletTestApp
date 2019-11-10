package service;

import com.google.gson.Gson;
import dao.StudentDao;
import lombok.AllArgsConstructor;
import model.Student;
import repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	private Gson gson;

	@Override
	public List<String> getAll() {
		List<Student> students = studentRepository.findAll();
		return students.stream()
				.map(gson::toJson)
				.collect(Collectors.toList());
	}

	@Override
	public String getById(Long id) {
		Student student = studentRepository.findById(id);
		return gson.toJson(student);
	}

	@Override
	public void save(String studentJson) {
		StudentDao student = gson.fromJson(studentJson, StudentDao.class);
		studentRepository.save(student);
	}
}
