package net.pulove.todo_management.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private Long id;
    private String caseTitle;

    private LocalDateTime extractionStartTime;
    private String description;
    private LocalDateTime extractionEndTime;
    private Long extractionDuration;

    private LocalDateTime importStartTime;
    private LocalDateTime importEndTime;
    private Long importDuration;

    private LocalDateTime reportEndTime;
    private LocalDateTime reportStartTime;
    private Long reportDuration;

    private Long totalTimeDuration;

    private boolean completed;

}
