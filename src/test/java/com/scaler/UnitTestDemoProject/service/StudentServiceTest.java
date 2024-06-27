package com.scaler.UnitTestDemoProject.service;

import com.scaler.UnitTestDemoProject.entity.Student;
import com.scaler.UnitTestDemoProject.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

/**
 * Test class for StudentService.
 */
@SpringBootTest
public class StudentServiceTest {

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * Tests the saveStudent method of StudentService.
     */
    @Test
    public void testSaveStudent() {
        // Arrange
        Student student = new Student(10L, "sai", "srinvias@xyz.com");
        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(student);

        // Act
        Student savedStudent = studentService.saveStudent(student);

        // Assert
        Assertions.assertEquals(student.getId(), savedStudent.getId());
    }
}