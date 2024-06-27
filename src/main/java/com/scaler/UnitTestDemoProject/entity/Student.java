package com.scaler.UnitTestDemoProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


/**
 * Entity representing a student.
 */
@Getter
@Setter
@Entity
public class Student {

    /**
     * The unique identifier for the student.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the student.
     */
    private String name;

    /**
     * The email of the student.
     */
    private String email;

    /**
     * Constructs a new Student with the specified name and email.
     * @param name the name of the student
     * @param email the email of the student
     */
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Constructs a new Student with the specified id, name, and email.
     * @param id the id of the student
     * @param name the name of the student
     * @param email the email of the student
     */
    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Default constructor for JPA.
     */
    public Student() {
        // Default constructor
    }
}
