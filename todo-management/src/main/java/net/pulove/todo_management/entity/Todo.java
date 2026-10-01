package net.pulove.todo_management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "dfu_case_info")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String caseTitle;

    @Column(name = "description", nullable = false)
    private String description;

//    @JsonFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(name = "extraction_start_date")
    private LocalDateTime extractionStartTime;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(name = "extraction_end_date")
    private LocalDateTime extractionEndTime;

    @Column(name = "extract_duration")
    private Long extractionDuration;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(name = "import_start_date")
    private LocalDateTime importStartTime;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(name = "import_end_date")
    private LocalDateTime importEndTime;

    @Column(name="import_duration")
    private Long importDuration;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(name = "report_start_date")
    private LocalDateTime reportStartDate;

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(name = "report_end_date")
    private LocalDateTime reportEndDate;

    @Column(name="report_duration")
    private Long reportDuration;

    @Column(name="total_time_duration")
    private Long totalTimeDuration;

    @Column(name = "completed", nullable = false)
    private boolean completed;


}
