package com.drifting2.projectbackend.service;


import com.drifting2.projectbackend.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Integer getTeacherSize();
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Teacher getTeacher(Long id);
    Teacher save(Teacher teacher);
    Page<Teacher> getTeachers(String title, Pageable pageable);

    Teacher getTeachers(String firstname);
}
