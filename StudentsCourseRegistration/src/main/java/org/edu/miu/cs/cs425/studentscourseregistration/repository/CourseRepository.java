package org.edu.miu.cs.cs425.studentscourseregistration.repository;

import jakarta.validation.constraints.NotBlank;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}