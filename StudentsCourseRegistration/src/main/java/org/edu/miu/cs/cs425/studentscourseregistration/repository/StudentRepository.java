package org.edu.miu.cs.cs425.studentscourseregistration.repository;

import org.edu.miu.cs.cs425.studentscourseregistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("""
        SELECT s.id, s.firstName, s.lastName, COUNT(r.id) AS totalRegistrations, 
               c.courseTitle, c.courseCode, r.grade
        FROM Student s
        JOIN Registration r ON s.id = r.student.id
        JOIN Course c ON r.course.id = c.id
        WHERE r.grade IN ('A+', 'A', 'A-')
        GROUP BY s.id, s.firstName, s.lastName, c.courseTitle, c.courseCode, r.grade
        HAVING COUNT(r.id) > 0
    """)
    List<Object[]> findHonorRollStudentsWithCourses();
}
