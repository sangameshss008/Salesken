package org.jsp.student_reporting_system.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Semester {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int semester;
private int english_marks;
private int maths_marks;
private int science_marks;
public int getSemester() {
	return semester;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setSemester(int semester) {
	this.semester = semester;
}
public int getEnglish_marks() {
	return english_marks;
}
public void setEnglish_marks(int english_marks) {
	this.english_marks = english_marks;
}
public int getMaths_marks() {
	return maths_marks;
}
public void setMaths_marks(int maths_marks) {
	this.maths_marks = maths_marks;
}
public int getScience_marks() {
	return science_marks;
}
public void setScience_marks(int science_marks) {
	this.science_marks = science_marks;
}

}
