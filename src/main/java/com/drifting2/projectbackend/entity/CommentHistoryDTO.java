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
public class CommentHistoryDTO {
    Long id;
    @Builder.Default
    List<CommentHistoryMessageDTO> history = new ArrayList<>();
    Long adviseeId;
    Long advisorId;
}
