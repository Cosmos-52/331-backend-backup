package com.drifting2.projectbackend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String teacherId;
    String teacherPw;
    String academicPosition;
    String firstname;
    String surname;
    String department;
    String profileImage;
    @Builder.Default
    @OneToMany(mappedBy = "advisor")
    List<Student> advisee = new ArrayList<>();
    @ElementCollection
    List<String> images;
}
