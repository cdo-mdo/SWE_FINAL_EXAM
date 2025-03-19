package org.edu.miu.cs.cs425.studentscourseregistration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private Double percentageCourse;
    private String grade;

    @ManyToOne
    @JoinColumn (name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;

    public Registration(LocalDate startDate, LocalDate endDate,
                        double percentageCourse, String grade,
                        Student student, Course course) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.percentageCourse = percentageCourse;
        this.grade = grade;
        this.student = student;
        this.course = course;
    }
}
