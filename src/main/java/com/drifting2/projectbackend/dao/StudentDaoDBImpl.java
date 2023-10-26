package com.drifting2.projectbackend.dao;


import com.drifting2.projectbackend.entity.Student;
import com.drifting2.projectbackend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDBImpl implements StudentDao{
    final StudentRepository studentRepository;
    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(String title, Pageable page) {
        return studentRepository.findByStudentIdContainingOrFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(title, title, title, page);
    }

    @Override
    public Student getStudent(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }
}