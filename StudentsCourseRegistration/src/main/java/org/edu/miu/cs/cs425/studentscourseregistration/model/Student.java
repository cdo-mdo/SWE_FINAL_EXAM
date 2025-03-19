package org.edu.miu.cs.cs425.studentscourseregistration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, unique = true)
    @NotBlank (message = "This field is required and cannot be blank.")
    private String admissionNumber;

    @Column (nullable = false)
    @NotBlank (message = "This field is required and cannot be blank.")
    private String firstName;

    @Column (nullable = false)
    @NotBlank (message = "This field is required and cannot be blank.")
    private String lastName;

    private LocalDate dateOfAdmission;

    @OneToMany (mappedBy = "student")
    private List<Registration> registrations = new ArrayList<>();

    public Student() {

    }

    public Student(String admissionNumber, String firstName, String lastName, LocalDate dateOfAdmission) {
        this.admissionNumber = admissionNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfAdmission = dateOfAdmission;
    }
}
