package com.scaler.UnitTestDemoProject.service;

import com.scaler.UnitTestDemoProject.entity.Student;
import com.scaler.UnitTestDemoProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling student-related operations.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Saves a student entity.
     * @param student the student entity to save
     * @return the saved student entity
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Retrieves all students.
     * @return a list of all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Retrieves a student by their ID.
     * @param id the ID of the student to retrieve
     * @return an Optional containing the student if found, or empty if not found
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Updates an existing student.
     * @param id the ID of the student to update
     * @param studentDetails the updated student details
     * @return the updated student entity
     */
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id :: " + id));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        return studentRepository.save(student);
    }

    /**
     * Deletes a student by their ID.
     * @param id the ID of the student to delete
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}