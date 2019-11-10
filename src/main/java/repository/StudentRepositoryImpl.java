package repository;

import dao.StudentDao;
import model.Student;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

	private static final String SELECT_STUDENT_BY_ID = "select * from students where id = ?";
	private static final String INSERT_STUDENT = "insert into students(firstName, lastName) values (?, ?)";
	private static final String SELECT_ALL_STUDENTS = "select * from students";
	private static final String ID = "id";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";

	private Connection connection = DbUtil.getConnection();

	@Override
	public List<Student> findAll() {
		List<Student> students = new ArrayList<>();
		try (
				PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					students.add(new Student(resultSet.getLong(ID),
							resultSet.getString(FIRST_NAME),
							resultSet.getString(LAST_NAME)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student findById(Long id) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Student(resultSet.getLong(ID),
							resultSet.getString(FIRST_NAME),
							resultSet.getString(LAST_NAME));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(StudentDao student) {
		try (PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT)) {
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
