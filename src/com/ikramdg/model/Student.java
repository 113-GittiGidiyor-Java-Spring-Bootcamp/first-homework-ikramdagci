package com.ikramdg.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "studentId"))
@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private Address address;
    @Enumerated
    private Gender gender;

    @ManyToMany
    @JoinTable(name = "t_student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    public Student(String fullName, LocalDate birthDate, Address address, Gender gender) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }

    public Student() {}

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", gender=" + gender +
                ", courses=" + courses +
                '}';
    }
}
