package com.ikramdg.model;

import javax.persistence.*;

@Entity
@Table(name = "t_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(name = "name")
    private String name;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "credit_score")
    private double creditScore;

    @ManyToOne
    @JoinColumn(name = "course_instructor_id")
    private Instructor instructor;


    public Course(String name, String courseCode, double creditScore) {
        this.name = name;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }

    public Course() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
