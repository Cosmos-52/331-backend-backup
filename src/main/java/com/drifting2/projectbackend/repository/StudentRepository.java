package com.drifting2.projectbackend.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.drifting2.projectbackend.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();
    Page<Student> findByStudentIdContainingOrFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String studentId, String firstname, String surname, Pageable pageRequest);
    Page<Student> findByFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String firstname, String surname, Pageable pageRequest);
    Student findByStudentId(String studentId);
}