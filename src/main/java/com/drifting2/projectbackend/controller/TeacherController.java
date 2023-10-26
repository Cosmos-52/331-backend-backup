package com.drifting2.projectbackend.controller;

import com.drifting2.projectbackend.entity.Teacher;
import com.drifting2.projectbackend.util.LabMapper;
import lombok.RequiredArgsConstructor;
import com.drifting2.projectbackend.service.TeacherService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeacherController {
    List<Teacher> teacherList;
    final TeacherService teacherService;
    @GetMapping("advisors")
    public ResponseEntity<?> getTeacherLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "title", required = false) String title) {
                                                
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Teacher> pageOutput;
        if (title == null) {
            pageOutput = teacherService.getTeachers(perPage,page);
        }else{
            pageOutput = teacherService.getTeachers(title,PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getTeacherDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("advisors/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable("id") Long id) {
        Teacher output = teacherService.getTeacher(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/advisors")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher Teacher){
        Teacher output = teacherService.save(Teacher);
        return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(output));
    }

    @GetMapping("advisors/searchByTeacherFirstname")
    public ResponseEntity<?> getTeacher(@RequestParam String firstname) {
        Teacher output = teacherService.getTeachers(firstname);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given firstname is not found");
        }
    }

}
