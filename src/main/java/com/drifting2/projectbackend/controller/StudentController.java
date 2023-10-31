package com.drifting2.projectbackend.controller;

import com.drifting2.projectbackend.entity.Student;
import com.drifting2.projectbackend.service.StudentService;
import com.drifting2.projectbackend.util.LabMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {
    List<Student> studentList;

    final StudentService studentService;
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "title", required = false) String title) {
                                                
        perPage = perPage == null ? studentService.getStudentSize() : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;
        if (title == null) {
            pageOutput = studentService.getStudents(perPage,page);
        }else{
            pageOutput = studentService.getStudents(title,PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        Student output = studentService.getStudent(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student Student){
        Student output = studentService.save(Student);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
    }

    @GetMapping("students/searchByStudentId")
    public ResponseEntity<?> getStudent(@RequestParam(name = "id") String studentId) {

        if (studentId == null || studentId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid studentId");
        }

        Student student = studentService.getStudent(studentId);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(student));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.update(id, student);
        if (updatedStudent == null) {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(updatedStudent));
    }

}
