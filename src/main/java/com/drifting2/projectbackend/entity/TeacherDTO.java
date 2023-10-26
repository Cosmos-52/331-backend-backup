package com.drifting2.projectbackend.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    Long id;
    String teacherId;
    String academicPosition;
    String firstname;
    String surname;
    String department;
    @Builder.Default
    List<TeacherStudentDTO> advisee = new ArrayList<>();;;
    List<String> images;
}
