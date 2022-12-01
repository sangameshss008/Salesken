package org.jsp.student_reporting_system.service;

import java.util.List;

import org.jsp.student_reporting_system.dao.StudentDao;
import org.jsp.student_reporting_system.dto.ResponseStructure;
import org.jsp.student_reporting_system.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	
	public ResponseStructure<Student> addStudent(Student student) {
		ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setDataT(dao.addStudent(student));
		structure.setMessage("Data Added Succesfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure<List<Student>> fetchAllStudents() {
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		
		List<Student> list=dao.fetchAllStudents();
		if(list.isEmpty())
		{
			structure.setDataT(null);
			structure.setMessage("No Data Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return structure;
		}
		else
		{
			structure.setDataT(list);
			structure.setMessage("Data Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure<Student> fetchStudentbyId(int id) {
		Student student=dao.fetchStudent(id);
		ResponseStructure<Student> structure=new ResponseStructure<>();
		if(student==null)
		{
			structure.setDataT(null);
			structure.setMessage("No Data Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return structure;
		}
		else
		{
			structure.setDataT(student);
			structure.setMessage("Data Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return structure;
		}
	}
	
	public ResponseStructure<Double> findAverage(int sem)
	{
		ResponseStructure<Double> structure=new ResponseStructure<>();		
		structure.setDataT(dao.findAvg(sem));
		structure.setMessage("Average Percentage Of the Subject Marks is: ");
		structure.setStatusCode(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<Double> findAverage(String sub) {
		ResponseStructure<Double> structure=new ResponseStructure<>();		
		structure.setDataT(dao.findAvg(sub));
		structure.setMessage("Average Marks Of the Students in "+sub+": ");
		structure.setStatusCode(HttpStatus.FOUND.value());
		return structure;
	}

	public ResponseStructure<List<Student>> topTwo() {
ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setDataT(dao.topTwo());
			structure.setMessage("Data Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return structure;
	}

}
