package org.edu.miu.cs.cs425.studentscourseregistration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "This field is required and cannot be blank.")
    private String courseCode;

    @Column(nullable = false)
    private Integer creditUnit;

    @Column(nullable = false)
    @NotBlank(message = "This field is required and cannot be blank.")
    private String courseTitle;

    @OneToMany (mappedBy = "course")
    private List<Registration> registrations = new ArrayList<>();

    public Course() {

    }

    public Course(String courseCode, int creditUnit, String courseTitle) {
        this.courseCode = courseCode;
        this.creditUnit = creditUnit;
        this.courseTitle = courseTitle;
    }
}
