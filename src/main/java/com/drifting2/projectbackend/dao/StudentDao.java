package com.drifting2.projectbackend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.drifting2.projectbackend.entity.Student;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
    Student save(Student student);
    Student getStudent(String studentId);
    Page<Student> getStudents(String name, Pageable page);
}
