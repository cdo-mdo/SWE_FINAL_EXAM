package org.edu.miu.cs.cs425.studentscourseregistration.service;

import org.edu.miu.cs.cs425.studentscourseregistration.dto.RegistrationInfo;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Course;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Registration;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Student;
import org.edu.miu.cs.cs425.studentscourseregistration.repository.CourseRepository;
import org.edu.miu.cs.cs425.studentscourseregistration.repository.RegistrationRepository;
import org.edu.miu.cs.cs425.studentscourseregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Registration registerStudentForACourse(RegistrationInfo registrationInfo) {
        String studentId = registrationInfo.getStudentId();
        String courseId = registrationInfo.getCourseId();
        LocalDate startDate = LocalDate.parse(
                registrationInfo.getStartDate(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(
                registrationInfo.getEndDate(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Optional<Student> student = studentRepository.findById(Integer.parseInt(studentId));
        Optional<Course> course = courseRepository.findById(Integer.parseInt(courseId));
        Registration registration = new Registration(
                startDate, endDate, 0, null, student.orElse(null), course.orElse(null));

        return registrationRepository.save(registration);

    }

    public List<Object[]> getHonorRollStudents() {
        return studentRepository.findHonorRollStudentsWithCourses();

    }

}
