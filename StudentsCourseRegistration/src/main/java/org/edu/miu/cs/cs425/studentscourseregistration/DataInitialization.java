package org.edu.miu.cs.cs425.studentscourseregistration;

import org.edu.miu.cs.cs425.studentscourseregistration.model.Course;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Registration;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Student;
import org.edu.miu.cs.cs425.studentscourseregistration.repository.CourseRepository;
import org.edu.miu.cs.cs425.studentscourseregistration.repository.RegistrationRepository;
import org.edu.miu.cs.cs425.studentscourseregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitialization implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RegistrationRepository registrationRepository;

    private Student student1;
    private Student student2;
    private Student student3;

    private Course course1;
    private Course course2;
    private Course course3;
    private Course course4;

    private Registration registration1;
    private Registration registration2;
    private Registration registration3;
    private Registration registration4;

    @Override
    public void run(String... args) throws Exception {

        student1 = new Student("974-10-1231", "Daniel", "Fonseca",
                LocalDate.of(2014, 8, 31));
        student2 = new Student("972-11-9876", "Bernard", "Shaw",
                null);
        student3 = new Student("018-11-1165", "Carly", "DeFiori",
                null);

        course1 = new Course("CS401", 3, "Modern Programming");
        course2 = new Course("MTH302", 2, "Linear Algebra");
        course3 = new Course("PHY1210 ", 4, "Advanced Physiology");
        course4 = new Course("CS425", 4, "Software Engineering");

        registration1 = new Registration(
                LocalDate.of(2025, 1, 15),
                LocalDate.of(2025, 2, 14),
                95.50, "A",
                student2,
                course4);
        registration2 = new Registration(
                LocalDate.of(2025, 1, 15),
                LocalDate.of(2025, 2, 14),
                87.75, "B+",
                student2,
                course1);
        registration3 = new Registration(
                LocalDate.of(2025, 3, 31),
                LocalDate.of(2025, 4, 25),
                0, null,
                student1,
                course4);
        registration4 = new Registration(
                LocalDate.of(2025, 1, 15),
                LocalDate.of(2025, 2, 14),
                90, "A-",
                student3,
                course2);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);

        registrationRepository.save(registration1);
        registrationRepository.save(registration2);
        registrationRepository.save(registration3);
        registrationRepository.save(registration4);
    }
}
