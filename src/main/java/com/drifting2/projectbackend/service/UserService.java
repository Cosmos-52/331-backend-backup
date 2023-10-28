package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.entity.Student;
import com.drifting2.projectbackend.repository.StudentRepository;
import com.drifting2.projectbackend.security.auth.AuthenticationResponse;
import com.drifting2.projectbackend.security.auth.RegisterRequest;
import com.drifting2.projectbackend.security.config.JwtService;
import com.drifting2.projectbackend.security.user.Role;
import com.drifting2.projectbackend.security.user.User;
import com.drifting2.projectbackend.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService; // 假设你有这样一个服务来处理JWT

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getStudentId())  // Set username as studentId
                .password(passwordEncoder.encode(request.getStudentPw()))
                .roles(List.of(Role.ROLE_DISTRIBUTOR))
                .build();
        var savedUser = userRepository.save(user);

        Student student = Student.builder()
                .studentId(request.getStudentId())
                .studentPw(request.getStudentPw())
                .firstname(request.getFirstname())
                .surname(request.getLastname())
                .department(request.getDepartment())
                .images(request.getImages())
                .build();
        studentRepository.save(student);

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .username(request.getStudentId())  // Set username in the response
                .roles(savedUser.getRoles().stream().map(Role::name).collect(Collectors.toList()))  // Set roles in the response
                .build();
    }
}

