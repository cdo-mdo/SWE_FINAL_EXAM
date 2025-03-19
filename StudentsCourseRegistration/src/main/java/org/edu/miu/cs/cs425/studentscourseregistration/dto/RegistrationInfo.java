package org.edu.miu.cs.cs425.studentscourseregistration.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationInfo {
    private String studentId;
    private String courseId;
    private String startDate;
    private String endDate;

    public String getCourseId() {
        return courseId;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
}
