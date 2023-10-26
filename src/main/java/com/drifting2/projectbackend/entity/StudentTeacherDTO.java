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
public class StudentTeacherDTO {
    Long id;
    String teacherId;
    String academicPosition;
    String firstname;
    String surname;
    String department;
    String profileImage;
}
