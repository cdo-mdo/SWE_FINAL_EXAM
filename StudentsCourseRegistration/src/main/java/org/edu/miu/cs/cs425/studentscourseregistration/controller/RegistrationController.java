package org.edu.miu.cs.cs425.studentscourseregistration.controller;

import org.edu.miu.cs.cs425.studentscourseregistration.dto.RegistrationInfo;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Registration;
import org.edu.miu.cs.cs425.studentscourseregistration.model.Student;
import org.edu.miu.cs.cs425.studentscourseregistration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("regsys/api/v1")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registrations")
    public Registration registerStudentForACourse(@RequestBody RegistrationInfo registrationInfo) {
        return registrationService.registerStudentForACourse(registrationInfo);
    }

    @GetMapping("/students/honorRoll")
    public List<Object[]> getHonorRollStudents() {
        return registrationService.getHonorRollStudents();
    }
}
