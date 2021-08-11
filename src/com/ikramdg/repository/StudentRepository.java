package com.ikramdg.repository;

import com.ikramdg.model.Course;
import com.ikramdg.model.Gender;
import com.ikramdg.model.Student;

import java.time.LocalDate;
import java.util.Set;

public interface StudentRepository extends BaseSchoolStaffRepository<Student> {

    LocalDate findBirthDateById(Long id);
    Gender findGenderById(Long id);
    Set<Course> findCourses(Long id);

}
