package com.drifting2.projectbackend.security.auth;

import com.drifting2.projectbackend.entity.TeacherStudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTeacherRequest {
   private String teacherId;
   private String teacherPw;
   private String academicPosition;
   private String firstname;
   private String surname;
   private String department;
   private List<TeacherStudentDTO> advisee = new ArrayList<>();
   private List<String> images;

}
