package org.jsp.student_reporting_system.repository;

import org.jsp.student_reporting_system.dto.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {
	@Query("SELECT AVG((e.maths_marks+e.english_marks+e.science_marks)/3) FROM Semester e WHERE e.semester = ?1")
	public double findAvg(int sem);

	@Query("SELECT AVG(s.maths_marks) FROM Semester s")
	public Double findAvgMath();

	@Query("SELECT AVG(s.english_marks) FROM Semester s")
	public Double findAvgEng();

	@Query("SELECT AVG(s.science_marks) FROM Semester s")
	public Double findAvgScience();

}
