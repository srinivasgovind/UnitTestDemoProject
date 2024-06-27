package com.scaler.UnitTestDemoProject.controller;

import com.scaler.UnitTestDemoProject.entity.Student;
import com.scaler.UnitTestDemoProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * REST controller for managing student entities.
 */
@RestController
@RequestMapping("/students") // Any API under this controller will have /students as prefix
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Creates a new student.
     * @param student the student entity to be created
     * @return a ResponseEntity containing the created student
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    /**
     * Retrieves all students.
     * @return a list of all students
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Retrieves a student by their ID.
     * @param studentId the ID of the student to retrieve
     * @return a ResponseEntity containing the student
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
        Student student = studentService.getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found for this id: " + studentId));
        return ResponseEntity.ok().body(student);
    }

    /**
     * Updates an existing student.
     * @param studentId the ID of the student to update
     * @param studentDetails the updated student details
     * @return a ResponseEntity containing the updated student
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(studentId, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * Deletes a student by their ID.
     * @param studentId the ID of the student to delete
     * @return a map containing the deletion status
     */
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) {
        studentService.deleteStudent(studentId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}