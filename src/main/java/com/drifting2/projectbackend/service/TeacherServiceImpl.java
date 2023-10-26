package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.entity.Teacher;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    final com.drifting2.projectbackend.dao.TeacherDao TeacherDao;

    @Override
    public Integer getTeacherSize() {
        return TeacherDao.getTeacherSize();
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return TeacherDao.getTeachers(pageSize, page);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return TeacherDao.getTeacher(id);
    }

    @Override
    @Transactional
    public Teacher save(Teacher Teacher) {
        return TeacherDao.save(Teacher);
    }

    @Override
    public Page<Teacher> getTeachers(String title, Pageable pageable) {
        return TeacherDao.getTeachers(title,pageable);
    }
    @Override
    public Teacher getTeachers(String firstname) {
        return TeacherDao.getTeachers(firstname);
    }

}