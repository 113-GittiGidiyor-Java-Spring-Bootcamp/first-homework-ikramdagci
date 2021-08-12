package com.ikramdg.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "t_student")
public class Student extends BaseSchoolStaff {

    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(fetch = FetchType.EAGER) // show_sql property is true so printable format is corrupted with default fetchType(FetchType.LAZY for @ManyToMany)
    @JoinTable(name = "t_student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    public Student(String fullName, Address address, LocalDate birthDate, Gender gender) {
        super(fullName, address);
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Student() {}

    public void addCourse(Course course) {
        courses.add(course);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "birthDate=" + birthDate +
                ", gender=" + gender +
                ", courses=" + courses +
                '}';
    }
}
