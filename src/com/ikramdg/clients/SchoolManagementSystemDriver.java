package com.ikramdg.clients;

import com.ikramdg.configuration.JPAUtils;
import com.ikramdg.controller.StudentController;
import com.ikramdg.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.*;

public class SchoolManagementSystemDriver {

    private static final StudentController studentController        = new StudentController();

    public static final String DISPLAY_ALL_STUDENTS_FORMAT          = "%10d  | %-15s | %-30s | %-10s | %-6s | %-45s\n";
    public static final String DISPLAY_ALL_STUDENTS_HEADER_FORMAT   = "\n%-10s  | %-15s | %-30s | %-10s | %-6s | %-45s\n-------------------------------------------------------------------------------------------------\n";

    public static void main(String[] args) {

        persistSomeData();

        testSaveNewStudent();
        testFindAllCoursesOfStudent(1L);
        testPrintAllStudents();
        testDeleteStudent(7L);
        testPrintAllStudents();
    }

    private static void testPrintAllStudents() {
        List<Student> students = studentController.findAllStudents();

        System.out.printf(DISPLAY_ALL_STUDENTS_HEADER_FORMAT,"Student ID","Full Name","Address","Birth Date", "Gender", "Courses");
        for (Student student: students) {
            System.out.printf(DISPLAY_ALL_STUDENTS_FORMAT,
                    student.getStuffId(),student.getFullName(),
                    student.getAddress().toPlainText(),
                    student.getBirthDate(),student.getGender(),
                    student.getCourses().stream().map(Course::getName).reduce((course, course2) -> course +", " + course2).orElse(""));
        }
    }

    private static void testFindAllCoursesOfStudent(Long studentId) {
        Set<Course> courses = studentController.findCourses(studentId);
        courses.stream().forEach(s -> System.out.print(s.getName() + ", "));
    }

    private static void testDeleteStudent(Long studentID) {
        studentController.deleteStudent(studentID);
    }

    private static void testSaveNewStudent() {
        Address address = new Address("34000","Istanbul","Kerti",1);
        Student ikramDagci = new Student("Ikram Dagci",address,LocalDate.of(1996,3,8),Gender.MALE);

        studentController.saveStudent(ikramDagci);
    }

   private static void persistSomeData() {

        Address address = new Address("41700","Kocaeli","Bayramoglu",41);
        Address address2 = new Address("34550","Istanbul","Hurriyet",34);
        Address address3 = new Address("54103","Sakarya","Emek",54);
        Address address4 = new Address("06523","Ankara","Ataturk",06);
        Address address5 = new Address("16250","Bursa","Ova",16);

        Instructor instructor = new VisitingResearcher("Richard Helm",address3,"0123456789", 42);
        Instructor instructor2 = new PermanentInstructor("Erich Gamma",address4,"0123456789", 10000);
        Instructor instructor3 = new PermanentInstructor("Ralph Johnson",address5,"0123456789", 10000);


        Course course = new Course("Network Programming","CS001",4.5,instructor);
        Course course2 = new Course("Artificial Intelligence","CS002",5.0,instructor2);
        Course course3 = new Course("Math","MTH001",4.0,instructor3);

        instructor.addInstructedCourse(course);
        instructor.addInstructedCourse(course2);
        instructor2.addInstructedCourse(course3);

        Student student = new Student("Oguzhan Turk",address, LocalDate.of(1996,8,28), Gender.MALE);
        Student student2 = new Student("Busra Ciftlik",address2,  LocalDate.of(1995,12,21),Gender.FEMALE);
        Student student3 = new Student("Omer Altun", address, LocalDate.of(1996,4,18), Gender.MALE);

        student.addCourse(course);
        student.addCourse(course2);
        student.addCourse(course3);

        student2.addCourse(course2);

        student3.addCourse(course);
        student3.addCourse(course3);

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.persist(student);
            entityManager.persist(student2);
            entityManager.persist(student3);

            entityManager.persist(instructor);
            entityManager.persist(instructor2);
            entityManager.persist(instructor3);

            entityManager.persist(course);
            entityManager.persist(course2);
            entityManager.persist(course3);

            entityTransaction.commit();
        }catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
//          JPAUtils.getEntityManagerFactory().close();
        }
    }

}
