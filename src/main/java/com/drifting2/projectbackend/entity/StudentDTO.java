package com.drifting2.projectbackend.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String studentId;
    String studentPw;
    String firstname;
    String surname;
    String department;
    String profileImage;
    StudentTeacherDTO advisor;
    List<String> images;
}
