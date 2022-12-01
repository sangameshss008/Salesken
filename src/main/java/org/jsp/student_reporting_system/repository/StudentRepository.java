package org.jsp.student_reporting_system.repository;

import org.jsp.student_reporting_system.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
