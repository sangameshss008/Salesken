package org.jsp.student_reporting_system.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.student_reporting_system.dto.Student;
import org.jsp.student_reporting_system.repository.SemesterRepository;
import org.jsp.student_reporting_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

	@Autowired
	StudentRepository repository;

	@Autowired
	SemesterRepository semester;

	public Student addStudent(Student student) {
		repository.save(student);
		return student;
	}

	public List<Student> fetchAllStudents() {
		return repository.findAll();
	}

	public Student fetchStudent(int id) {
		Optional<Student> op = repository.findById(id);
		if (op.isEmpty()) {
			return null;
		} else {
			return op.get();
		}
	}

	public double findAvg(int sem) {
		return semester.findAvg(sem);
	}

	public Double findAvg(String sub) {
		if (sub.equals("maths")) {
			return semester.findAvgMath();
		} else if (sub.equals("english")) {
			return semester.findAvgEng();
		} else {
			return semester.findAvgScience();
		}
	}

	public List<Student> topTwo() {
		return null;
	}

}
