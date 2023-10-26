package com.drifting2.projectbackend.util;

import java.util.List;

import com.drifting2.projectbackend.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDTO(List<Student> students);
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
    CommentMessageDTO getCommentMessageDTO(CommentMessage commentMessage);
    List<CommentMessageDTO> getCommentMessageDTO(List<CommentMessage> commentMessage);
    CommentHistoryDTO getCommentHistoryDTO(CommentHistory commentHistory);
    List<CommentHistoryDTO> getCommentHistoryDTO(List<CommentHistory> commentHistory);

    AnnouncementDTO getAnnouncementDTO(Announcement announcement);

    List<AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcements);

    RolesDTO getRoleDTO(Roles roles);

    List<RolesDTO> getRoleDTO(List<Roles> roles);
}
