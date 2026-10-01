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
public class MobileEvidenceDto {
    private Long mobileEvidenceId;
    private String caseId;
    private String investigationOfficer;
    private String officeOrSection;
    private String refNo;
    private LocalDateTime date;
    private String exhibitMarking;
    private String mobileOwner;
    private String physicalAppearance;
    private String status;
    private String brand;
    private String color;
    private String faradayBag;
    private String sim1;
    private String sim2;
    private String eSim;


}
