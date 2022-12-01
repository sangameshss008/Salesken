package org.jsp.student_reporting_system.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Component
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private int year;

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

@Autowired
@OneToMany(cascade = CascadeType.ALL)
private List<Semester> semesters;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Semester> getSemesters() {
	return semesters;
}

public void setSemesters(List<Semester> semesters) {
	this.semesters = semesters;
}


}
