package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.dao.StudentDao;
import com.drifting2.projectbackend.dao.TeacherDao;
import com.drifting2.projectbackend.entity.Teacher;
import lombok.RequiredArgsConstructor;
import com.drifting2.projectbackend.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final StudentDao studentDao;
    final TeacherDao teacherDao;
    @Override
    public Integer getStudentSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        if(student.getAdvisor() != null){
            if(student.getAdvisor().getId() != 0){
                Teacher teacher = teacherDao.findById(student.getAdvisor().getId()).orElse(null);
                teacher.getAdvisee().add(student);
            } else {
                student.setAdvisor(null);
            }
        }
        return studentDao.save(student);
    }

    @Override
    public Page<Student> getStudents(String title, Pageable pageable) {
        return studentDao.getStudents(title,pageable);
    }

    @Override
    public Student getStudent(String studentId) {
        return studentDao.getStudent(studentId);
    }

    @Override
    @Transactional
    public Student update(Long id, Student updatedStudent) {
        Student existingStudent = studentDao.getStudent(id);
        if (existingStudent == null) {
            // Handle not found case
            return null;
        }

        // Update the fields. Here, I assume that `studentId`, `firstname`, and `surname` are the fields you want to update
        existingStudent.setStudentId(updatedStudent.getStudentId());
        existingStudent.setFirstname(updatedStudent.getFirstname());
        existingStudent.setSurname(updatedStudent.getSurname());

        return studentDao.save(existingStudent);
    }

}