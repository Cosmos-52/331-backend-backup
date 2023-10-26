package com.drifting2.projectbackend.util;

import com.drifting2.projectbackend.entity.Announcement;
import com.drifting2.projectbackend.entity.AnnouncementDTO;
import com.drifting2.projectbackend.entity.CommentHistory;
import com.drifting2.projectbackend.entity.CommentHistoryDTO;
import com.drifting2.projectbackend.entity.CommentHistoryMessageDTO;
import com.drifting2.projectbackend.entity.CommentMessage;
import com.drifting2.projectbackend.entity.CommentMessageDTO;
import com.drifting2.projectbackend.entity.CommentMessageHistoryDTO;
import com.drifting2.projectbackend.entity.Roles;
import com.drifting2.projectbackend.entity.RolesDTO;
import com.drifting2.projectbackend.entity.Student;
import com.drifting2.projectbackend.entity.StudentDTO;
import com.drifting2.projectbackend.entity.StudentTeacherDTO;
import com.drifting2.projectbackend.entity.Teacher;
import com.drifting2.projectbackend.entity.TeacherDTO;
import com.drifting2.projectbackend.entity.TeacherStudentDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-25T22:32:46+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3 (Oracle Corporation)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public StudentDTO getStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.id( student.getId() );
        studentDTO.studentId( student.getStudentId() );
        studentDTO.studentPw( student.getStudentPw() );
        studentDTO.firstname( student.getFirstname() );
        studentDTO.surname( student.getSurname() );
        studentDTO.department( student.getDepartment() );
        studentDTO.profileImage( student.getProfileImage() );
        studentDTO.advisor( teacherToStudentTeacherDTO( student.getAdvisor() ) );
        List<String> list = student.getImages();
        if ( list != null ) {
            studentDTO.images( new ArrayList<String>( list ) );
        }

        return studentDTO.build();
    }

    @Override
    public List<StudentDTO> getStudentDTO(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( students.size() );
        for ( Student student : students ) {
            list.add( getStudentDTO( student ) );
        }

        return list;
    }

    @Override
    public TeacherDTO getTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO.TeacherDTOBuilder teacherDTO = TeacherDTO.builder();

        teacherDTO.id( teacher.getId() );
        teacherDTO.teacherId( teacher.getTeacherId() );
        teacherDTO.academicPosition( teacher.getAcademicPosition() );
        teacherDTO.firstname( teacher.getFirstname() );
        teacherDTO.surname( teacher.getSurname() );
        teacherDTO.department( teacher.getDepartment() );
        teacherDTO.advisee( studentListToTeacherStudentDTOList( teacher.getAdvisee() ) );
        List<String> list1 = teacher.getImages();
        if ( list1 != null ) {
            teacherDTO.images( new ArrayList<String>( list1 ) );
        }

        return teacherDTO.build();
    }

    @Override
    public List<TeacherDTO> getTeacherDTO(List<Teacher> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherDTO> list = new ArrayList<TeacherDTO>( teachers.size() );
        for ( Teacher teacher : teachers ) {
            list.add( getTeacherDTO( teacher ) );
        }

        return list;
    }

    @Override
    public CommentMessageDTO getCommentMessageDTO(CommentMessage commentMessage) {
        if ( commentMessage == null ) {
            return null;
        }

        CommentMessageDTO.CommentMessageDTOBuilder commentMessageDTO = CommentMessageDTO.builder();

        commentMessageDTO.id( commentMessage.getId() );
        commentMessageDTO.from( commentHistoryToCommentMessageHistoryDTO( commentMessage.getFrom() ) );
        commentMessageDTO.message( commentMessage.getMessage() );
        commentMessageDTO.timeSent( commentMessage.getTimeSent() );
        commentMessageDTO.sentFromAdvisor( commentMessage.getSentFromAdvisor() );

        return commentMessageDTO.build();
    }

    @Override
    public List<CommentMessageDTO> getCommentMessageDTO(List<CommentMessage> commentMessage) {
        if ( commentMessage == null ) {
            return null;
        }

        List<CommentMessageDTO> list = new ArrayList<CommentMessageDTO>( commentMessage.size() );
        for ( CommentMessage commentMessage1 : commentMessage ) {
            list.add( getCommentMessageDTO( commentMessage1 ) );
        }

        return list;
    }

    @Override
    public CommentHistoryDTO getCommentHistoryDTO(CommentHistory commentHistory) {
        if ( commentHistory == null ) {
            return null;
        }

        CommentHistoryDTO.CommentHistoryDTOBuilder commentHistoryDTO = CommentHistoryDTO.builder();

        commentHistoryDTO.id( commentHistory.getId() );
        commentHistoryDTO.history( commentMessageListToCommentHistoryMessageDTOList( commentHistory.getHistory() ) );
        commentHistoryDTO.adviseeId( commentHistory.getAdviseeId() );
        commentHistoryDTO.advisorId( commentHistory.getAdvisorId() );

        return commentHistoryDTO.build();
    }

    @Override
    public List<CommentHistoryDTO> getCommentHistoryDTO(List<CommentHistory> commentHistory) {
        if ( commentHistory == null ) {
            return null;
        }

        List<CommentHistoryDTO> list = new ArrayList<CommentHistoryDTO>( commentHistory.size() );
        for ( CommentHistory commentHistory1 : commentHistory ) {
            list.add( getCommentHistoryDTO( commentHistory1 ) );
        }

        return list;
    }

    @Override
    public AnnouncementDTO getAnnouncementDTO(Announcement announcement) {
        if ( announcement == null ) {
            return null;
        }

        AnnouncementDTO.AnnouncementDTOBuilder announcementDTO = AnnouncementDTO.builder();

        announcementDTO.id( announcement.getId() );
        announcementDTO.title( announcement.getTitle() );
        announcementDTO.content( announcement.getContent() );
        announcementDTO.date( announcement.getDate() );
        List<String> list = announcement.getFiles();
        if ( list != null ) {
            announcementDTO.files( new ArrayList<String>( list ) );
        }

        return announcementDTO.build();
    }

    @Override
    public List<AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcements) {
        if ( announcements == null ) {
            return null;
        }

        List<AnnouncementDTO> list = new ArrayList<AnnouncementDTO>( announcements.size() );
        for ( Announcement announcement : announcements ) {
            list.add( getAnnouncementDTO( announcement ) );
        }

        return list;
    }

    @Override
    public RolesDTO getRoleDTO(Roles roles) {
        if ( roles == null ) {
            return null;
        }

        RolesDTO.RolesDTOBuilder rolesDTO = RolesDTO.builder();

        rolesDTO.id( roles.getId() );
        rolesDTO.type( roles.getType() );

        return rolesDTO.build();
    }

    @Override
    public List<RolesDTO> getRoleDTO(List<Roles> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RolesDTO> list = new ArrayList<RolesDTO>( roles.size() );
        for ( Roles roles1 : roles ) {
            list.add( getRoleDTO( roles1 ) );
        }

        return list;
    }

    protected StudentTeacherDTO teacherToStudentTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        StudentTeacherDTO.StudentTeacherDTOBuilder studentTeacherDTO = StudentTeacherDTO.builder();

        studentTeacherDTO.id( teacher.getId() );
        studentTeacherDTO.teacherId( teacher.getTeacherId() );
        studentTeacherDTO.academicPosition( teacher.getAcademicPosition() );
        studentTeacherDTO.firstname( teacher.getFirstname() );
        studentTeacherDTO.surname( teacher.getSurname() );
        studentTeacherDTO.department( teacher.getDepartment() );
        studentTeacherDTO.profileImage( teacher.getProfileImage() );

        return studentTeacherDTO.build();
    }

    protected TeacherStudentDTO studentToTeacherStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        TeacherStudentDTO.TeacherStudentDTOBuilder teacherStudentDTO = TeacherStudentDTO.builder();

        teacherStudentDTO.id( student.getId() );
        teacherStudentDTO.studentId( student.getStudentId() );
        teacherStudentDTO.firstname( student.getFirstname() );
        teacherStudentDTO.surname( student.getSurname() );
        teacherStudentDTO.department( student.getDepartment() );
        List<String> list = student.getImages();
        if ( list != null ) {
            teacherStudentDTO.images( new ArrayList<String>( list ) );
        }

        return teacherStudentDTO.build();
    }

    protected List<TeacherStudentDTO> studentListToTeacherStudentDTOList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<TeacherStudentDTO> list1 = new ArrayList<TeacherStudentDTO>( list.size() );
        for ( Student student : list ) {
            list1.add( studentToTeacherStudentDTO( student ) );
        }

        return list1;
    }

    protected CommentMessageHistoryDTO commentHistoryToCommentMessageHistoryDTO(CommentHistory commentHistory) {
        if ( commentHistory == null ) {
            return null;
        }

        CommentMessageHistoryDTO.CommentMessageHistoryDTOBuilder commentMessageHistoryDTO = CommentMessageHistoryDTO.builder();

        commentMessageHistoryDTO.id( commentHistory.getId() );
        commentMessageHistoryDTO.adviseeId( commentHistory.getAdviseeId() );
        commentMessageHistoryDTO.advisorId( commentHistory.getAdvisorId() );

        return commentMessageHistoryDTO.build();
    }

    protected CommentHistoryMessageDTO commentMessageToCommentHistoryMessageDTO(CommentMessage commentMessage) {
        if ( commentMessage == null ) {
            return null;
        }

        CommentHistoryMessageDTO.CommentHistoryMessageDTOBuilder commentHistoryMessageDTO = CommentHistoryMessageDTO.builder();

        commentHistoryMessageDTO.id( commentMessage.getId() );
        commentHistoryMessageDTO.message( commentMessage.getMessage() );
        commentHistoryMessageDTO.timeSent( commentMessage.getTimeSent() );
        commentHistoryMessageDTO.sentFromAdvisor( commentMessage.getSentFromAdvisor() );

        return commentHistoryMessageDTO.build();
    }

    protected List<CommentHistoryMessageDTO> commentMessageListToCommentHistoryMessageDTOList(List<CommentMessage> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentHistoryMessageDTO> list1 = new ArrayList<CommentHistoryMessageDTO>( list.size() );
        for ( CommentMessage commentMessage : list ) {
            list1.add( commentMessageToCommentHistoryMessageDTO( commentMessage ) );
        }

        return list1;
    }
}
