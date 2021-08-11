package com.ikramdg.controller;

import com.ikramdg.model.Address;
import com.ikramdg.model.Course;
import com.ikramdg.model.Gender;
import com.ikramdg.model.Student;
import com.ikramdg.service.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class StudentController {

    private final StudentService studentService = new StudentService();

    public Address findAddressById(Long id) {
        return studentService.findAddressById(id);
    }

    public List<Student> findAllStudents() {
        return  studentService.findAll();
    }

    public Student findStudentById(Long id) {
        return  studentService.findById(id);
    }

    public void saveStudent(Student student) {
        studentService.saveToDatabase(student);
    }

    public void deleteStudent(Student student) {
        studentService.deleteFromDatabase(student);
    }

    public void deleteStudent(Long id) {
        studentService.deleteFromDatabase(id);
    }

    public void updateStudent(Student student, Long id) {
        studentService.updateOnDatabase(student,id);
    }

    public LocalDate findBirthDateById(Long id) {
        return studentService.findBirthDateById(id);
    }

    public Gender findGenderById(Long id) {
        return studentService.findGenderById(id);
    }

    public Set<Course> findCourses(Long id) {
        return studentService.findCourses(id);
    }
}
