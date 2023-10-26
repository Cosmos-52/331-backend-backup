package com.drifting2.projectbackend.config;

import com.drifting2.projectbackend.entity.*;
import com.drifting2.projectbackend.repository.*;
import com.drifting2.projectbackend.security.user.Role;
import com.drifting2.projectbackend.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import com.drifting2.projectbackend.security.user.User;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired

    final StudentRepository studentRepository;
    final AnnouncementRepository announcementRepository;
    final TeacherRepository teacherRepository;
    final CommentMessageRepository commentMessageRepository;
    final CommentHistoryRepository commentHistoryRepository;
    final RolesRepository rolesRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        User admin = new User();
        admin.setUsername("admin");
        admin.setFirstname("admin");
        admin.setLastname("admin");
        admin.setPassword(encoder.encode("admin"));
        admin.setRoles(List.of(Role.ROLE_ADMIN));
        admin.setEmail("admin@admin.com");
        userRepository.save(admin);

        User teacher = new User();
        teacher.setUsername("teacher");
        teacher.setFirstname("teacher");
        teacher.setLastname("teacher");
        teacher.setPassword(encoder.encode("teacher"));
        teacher.setRoles(List.of(Role.ROLE_FASTFIT));
        teacher.setEmail("teacher@teacher.com");
        userRepository.save(teacher);

        User student = new User();
        student.setUsername("student");
        student.setFirstname("student");
        student.setLastname("student");
        student.setPassword(encoder.encode("student"));
        student.setRoles(List.of(Role.ROLE_DISTRIBUTOR));
        student.setEmail("steant@student.com");
        userRepository.save(student);

        Roles r1,r2,r3;
        r1 = rolesRepository.save(Roles.builder()
            .type("Admin")
            .build()
        );
        r2 = rolesRepository.save(Roles.builder()
            .type("Teacher")
            .build()
        );
        r3 = rolesRepository.save(Roles.builder()
            .type("Student")
            .build()
        );


        Announcement A1, A2, A3;

        A1 = announcementRepository.save(Announcement.builder()
            .title("Announcement of Testing Multiple Documents")
            .content("This is of Testing Multiple Documents.Once upon a time, in a bustling city, there lived a young software engineering student named nights coding, testing, and debugging. It was her world.")
            .date("2023-04-01")
            .files(List.of("https://storage.googleapis.com/download/storage/v1/b/uploader-cf487.appspot.com/o/2023-10-25%20122350302-1.txt?generation=1698211431019579&alt=media","https://storage.googleapis.com/download/storage/v1/b/uploader-cf487.appspot.com/o/2023-10-25%20162316319-Assignment11.pdf?generation=1698225797137001&alt=media"))
            .build()
        );
        A2 = announcementRepository.save(Announcement.builder()
            .title("Announcement of image")
            .content("Finally, after weeks of relentless effort, she solved the puzzle. It was an innovative algorithm that could change the face of technology. past, present, and the future.")
            .date("2021-04-02")
            .files(List.of("https://storage.googleapis.com/download/storage/v1/b/uploader-cf487.appspot.com/o/2023-10-25%20164336332-1.png?generation=1698227017326014&alt=media"))
            .build()
        );
        A3 = announcementRepository.save(Announcement.builder()
            .title("Announcement of pdf")
            .content("And thus, the code that bound Ada and Turing became a legend in the software world, inspiring many more to delve into the mysteries that lay within the realm of programming, fueling the endless cycle of discovery and innovation.")
            .date("2021-04-03")
            .files(List.of("https://storage.googleapis.com/download/storage/v1/b/uploader-cf487.appspot.com/o/2023-10-25%20162316319-Assignment11.pdf?generation=1698225797137001&alt=media"))
            .build()
        );



        Teacher t1, t2, t3;
        t1 = teacherRepository.save(Teacher.builder()
            .teacherId("001")
            .firstname("Kana")
            .surname("Momonogi")
            .academicPosition("Lecture")
            .department("CAMT")
            .images(List.of("https://images.unsplash.com/photo-1687360441387-0179af118555?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=654&q=80"))
            .build()
        );

        t2 = teacherRepository.save(Teacher.builder()
            .teacherId("002")
            .firstname("白桃")
            .surname("はな")
            .academicPosition("Lecture")
            .department("CAMT")
            .images(List.of("https://images.unsplash.com/photo-1521119989659-a83eee488004?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=846&q=80"))
            .build()
        );

        t3 = teacherRepository.save(Teacher.builder()
                .teacherId("003")
                .firstname("undefined teacher")
                .surname("")
                .academicPosition("undefined")
                .department("undefined")
                .images(List.of("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"))
                .build()
        );

        Student tempSt;
        tempSt = studentRepository.save(Student.builder()
            .studentId("622115501")
            .firstname("Alice")
            .surname("Li")
            .department("CAMT")
          .images(List.of("https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"))
            .build()
        );
        tempSt.setAdvisor(t1);
        t1.getAdvisee().add(tempSt);
        CommentHistory his1 = commentHistoryRepository.save(CommentHistory.builder()
            .adviseeId(tempSt.getId())
            .advisorId(t1.getId())

            .build()
        );
        CommentHistory his2 = commentHistoryRepository.save(CommentHistory.builder()
            .adviseeId(tempSt.getId())
            .advisorId(t2.getId())
            .build()
        );
        CommentMessage msg1 = commentMessageRepository.save(CommentMessage.builder()
            .message("Knock knock")
            .sentFromAdvisor(false)
            .timeSent("X")
            .build()
        );
        msg1.setFrom(his1);
        his1.getHistory().add(msg1);
        CommentMessage msg2 = commentMessageRepository.save(CommentMessage.builder()
            .message("Who's there?")
            .sentFromAdvisor(true)
            .timeSent("X")
            .build()
        );
        msg2.setFrom(his1);
        his1.getHistory().add(msg2);
        CommentMessage msg3 = commentMessageRepository.save(CommentMessage.builder()
            .message("It's me, Daddy~~~~~~")
            .sentFromAdvisor(false)
            .timeSent("X")
            .build()
        );
        msg3.setFrom(his1);
        his1.getHistory().add(msg3);

        tempSt = studentRepository.save(Student.builder()
            .studentId("622115502")
            .firstname("Tom")
            .surname("X")
            .department("CAMT")
                .images(List.of("https://images.pexels.com/photos/1148998/pexels-photo-1148998.jpeg"))
            .build()
        );
        tempSt.setAdvisor(t1);
        t1.getAdvisee().add(tempSt);
        tempSt = studentRepository.save(Student.builder()
            .studentId("622115503")
            .firstname("Jerry")
            .surname("Shu")
            .department("CAMT")
                .images(List.of("https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"))
            .build()
        );
        tempSt.setAdvisor(t2);
        t2.getAdvisee().add(tempSt);
        tempSt = studentRepository.save(Student.builder()
            .studentId("622115504")
            .firstname("Xukun")
            .surname("Cai")
            .department("CAMT")
                .images(List.of("https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"))
            .build()
        );
        tempSt.setAdvisor(t2);
        t2.getAdvisee().add(tempSt);




//        System.out.println("Init Finished.");


    }
    
}
