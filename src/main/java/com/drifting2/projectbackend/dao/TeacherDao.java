package com.drifting2.projectbackend.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.drifting2.projectbackend.entity.Teacher;

public interface TeacherDao {
    Integer getTeacherSize();
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Teacher getTeacher(Long id);
    Teacher save(Teacher teacher);
    Optional<Teacher> findById(Long id);
    Page<Teacher> getTeachers(String name, Pageable page);
    Teacher getTeachers(String firstname);
}
