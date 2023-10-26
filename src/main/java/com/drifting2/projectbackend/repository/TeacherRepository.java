package com.drifting2.projectbackend.repository;


import com.drifting2.projectbackend.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    List<Teacher> findAll();
    Page<Teacher> findByAcademicPositionIgnoreCaseContainingOrFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String academicPosition, String firstname, String surname, Pageable pageRequest);
    Teacher findByFirstname(String firstname);
}