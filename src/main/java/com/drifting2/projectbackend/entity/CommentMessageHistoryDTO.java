package com.drifting2.projectbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentMessageHistoryDTO {
    Long id;
    Long adviseeId;
    Long advisorId;
}
