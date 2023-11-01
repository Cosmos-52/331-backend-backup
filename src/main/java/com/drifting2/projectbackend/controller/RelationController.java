package com.drifting2.projectbackend.controller;

import com.drifting2.projectbackend.entity.*;
import com.drifting2.projectbackend.repository.*;
import com.drifting2.projectbackend.util.LabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class RelationController {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/setRelation")
    public ResponseEntity<?> setRelation(@RequestParam String studentId, @RequestParam String teacherFirstname){
        Student student = studentRepository.findByStudentId(studentId);
        Teacher teacher = teacherRepository.findByFirstname(teacherFirstname);
        student.setAdvisor(teacher);
        studentRepository.save(student);
        teacher.getAdvisee().add(student);
        teacherRepository.save(teacher);

        if (teacher != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(student));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cannot set relation");
        }
    }

}
