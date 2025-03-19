package org.edu.miu.cs.cs425.studentscourseregistration.repository;

import org.edu.miu.cs.cs425.studentscourseregistration.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}