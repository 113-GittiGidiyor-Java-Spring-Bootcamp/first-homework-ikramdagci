package com.ikramdg.clients;

import com.ikramdg.configuration.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class SchoolManagementSystemDriver {

    public static void testDB(){
        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        // TODO Operations
        entityTransaction.commit();
    }


    public static void main(String[] args) {
        System.out.println("Run");
        testDB();
    }

}
