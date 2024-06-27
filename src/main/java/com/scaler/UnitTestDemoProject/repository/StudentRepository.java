package com.scaler.UnitTestDemoProject.repository;

import com.scaler.UnitTestDemoProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Student entities.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
