package com.ikramdg.model;

import javax.persistence.*;
import java.util.Objects;

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


    public Course(String name, String courseCode, double creditScore, Instructor instructor) {
        this.name = name;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
        this.instructor = instructor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseCode);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                ", instructor=" + instructor.getFullName() +
                '}';
    }
}
