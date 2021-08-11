package com.ikramdg.service;

import com.ikramdg.configuration.JPAUtils;
import com.ikramdg.exception.StaffNotFoundException;
import com.ikramdg.model.*;
import com.ikramdg.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class StudentService implements StudentRepository {

    private EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();


    @Override
    public Address findAddressById(Long id) {
        Address address = null;
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();

            transaction.begin();
            Student foundStudent = entityManager.find(Student.class, id);
            if (foundStudent == null) {
                throw new StaffNotFoundException(id);
            }
            address = foundStudent.getAddress();
        }catch (StaffNotFoundException e){
                transaction.rollback();
                throw e;
        }
        transaction.commit();
        return address;

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public void saveToDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(Long id) {

    }

    @Override
    public void updateOnDatabase(Student object, Long id) {

    }

    @Override
    public LocalDate findBirthDateById(Long id) {
        return null;
    }

    @Override
    public Gender findGenderById(Long id) {
        return null;
    }

    @Override
    public Set<Course> findCourses(Long id) {
        return null;
    }
}
