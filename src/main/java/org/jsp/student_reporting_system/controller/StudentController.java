package org.jsp.student_reporting_system.controller;

import java.util.List;

import org.jsp.student_reporting_system.dto.ResponseStructure;
import org.jsp.student_reporting_system.dto.Student;
import org.jsp.student_reporting_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	//Add student
	@PostMapping("students")
	public ResponseStructure<Student> addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	//Fetch All Students
	@GetMapping("students")
	public ResponseStructure<List<Student>> fetchAllStudents() {
		return service.fetchAllStudents();
	}
	
	//Fetch Student by Id
	@GetMapping("students/{id}")
	public ResponseStructure<Student> fetchStudent(@PathVariable int id) {
		return service.fetchStudentbyId(id);
	}
	
	//Class Average Percentage based on semester
	@GetMapping("students/avg/{sem}")
	public ResponseStructure<Double> findAvg(@PathVariable int sem)
	{
		return service.findAverage(sem);
	}
	
	//Average Marks of Student in Subject
	@GetMapping("students/average/{sub}")
	public ResponseStructure<Double> findAvg(@PathVariable String sub)
	{
		return service.findAverage(sub);
	}
	
	//Top 2 Consistent Students
	@GetMapping("students/toptwo")
	public ResponseStructure<List<Student>> topTwo()
	{
		return service.topTwo();
	}
}
