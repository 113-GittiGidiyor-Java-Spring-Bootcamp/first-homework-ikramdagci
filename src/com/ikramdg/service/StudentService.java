package com.ikramdg.service;

import com.ikramdg.configuration.JPAUtils;
import com.ikramdg.exception.StaffNotFoundException;
import com.ikramdg.model.*;
import com.ikramdg.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class StudentService implements StudentRepository {

    private final EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();


    @Override
    public Address findAddressById(Long id) {
        return findById(id).getAddress();
    }

    @Override
    public List<Student> findAll() {
       return  entityManager.createQuery("select s from Student s",Student.class).getResultList();
    }

    @Override
    public Student findById(Long id) {
        EntityTransaction transaction = null;
        Student foundStudent = null;
        try {
            transaction = entityManager.getTransaction();

            transaction.begin();
            foundStudent = entityManager.find(Student.class, id);
            if (foundStudent == null) {
                throw new StaffNotFoundException(id);
            }
        }catch (RuntimeException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
        transaction.commit();
        return foundStudent;
    }

    @Override
    public void saveToDatabase(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFromDatabase(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(student);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFromDatabase(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("DELETE FROM t_student WHERE staff_id = ?", Student.class).setParameter(1, id);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void updateOnDatabase(Student student, Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Student foundStudent = entityManager.find(Student.class, id);
            foundStudent = student;
            transaction.commit();

        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public LocalDate findBirthDateById(Long id) {
        return  findById(id).getBirthDate();
    }

    @Override
    public Gender findGenderById(Long id) {
        return findById(id).getGender();
    }

    @Override
    public Set<Course> findCourses(Long id) {
        return findById(id).getCourses();
    }
}
