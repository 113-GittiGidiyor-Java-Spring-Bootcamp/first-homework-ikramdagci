package com.ikramdg.clients;

import com.ikramdg.configuration.JPAUtils;
import com.ikramdg.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SchoolManagementSystemDriver {

    public static void testDB(){

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        // TODO Operations
        entityTransaction.commit();
    }


    public static void main(String[] args) {
//        persistSomeData();
        testDB();
    }

   /* private static void persistSomeData() {
        Address address = new Address("41700","Kocaeli","Bayramoglu",25);
        Address address2 = new Address("34550","Istanbul","Hurriyet",569);
        Address address3 = new Address("54103","Sakarya","Emek",2);

        Instructor instructor = new VisitingResearcher("Richard Helm","0123456789",address, 205);
        Instructor instructor2 = new PermanentInstructor("Erich Gamma","0123456789",address2, 10000);
        Instructor instructor3 = new PermanentInstructor("Ralph Johnson","0123456789",address3, 10000);


        Course course = new Course("Network Programming","CS001",4.5,instructor);
        Course course2 = new Course("Artificial Intelligence","CS002",5.0,instructor2);
        Course course3 = new Course("Math","MTH001",4.0,instructor3);

        instructor.addInstructedCourse(course);
        instructor.addInstructedCourse(course2);
        instructor2.addInstructedCourse(course3);


        Student student = new Student("Ikram Dagci", LocalDate.of(1996,3,8),address, Gender.MALE);
        Student student2 = new Student("Busra Ciftlik", LocalDate.of(1995,12,21),address2, Gender.FEMALE);
        Student student3 = new Student("Omer Altun", LocalDate.of(1996,4,18),address3, Gender.MALE);

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

//            entityManager.persist(address);
//            entityManager.persist(address2);
//            entityManager.persist(address3);

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
            JPAUtils.getEntityManagerFactory().close();
        }


    }*/

}
