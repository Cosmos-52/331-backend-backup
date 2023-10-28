package com.drifting2.projectbackend.security.auth;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// RegisterRequest.java
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String studentId;
  private String studentPw;
  private String firstname;
  private String lastname;
  private String department;
  private List<String> images;
}



