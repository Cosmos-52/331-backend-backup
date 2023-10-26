package com.drifting2.projectbackend.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.drifting2.projectbackend.entity.Student;

public interface StudentService {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
    Student save(Student student);
    Page<Student> getStudents(String title, Pageable pageable);
    Student getStudent(String studentId);
    Student update(Long id, Student student);


}
