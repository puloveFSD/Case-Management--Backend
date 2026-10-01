package net.pulove.todo_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="dfu_mobile_evidence")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MobileEvidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mobileEvidenceId;

    @Column(name = "investigation_officer")
    private String investigationOfficer;

    @Column(name="office_section")
    private String officeOrSection;

    @Column(name = "ref_no")
    private String refNo;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "exhibit_marking")
    private String exhibitMarking;

    @Column(name = "mobile_owner")
    private String mobileOwner;

    @Column(name = "physical_appearance")
    private String physicalAppearance;

    @Column(name = "status")
    private String status;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "imei1")
    private String imei1;

    @Column(name = "imei2")
    private String imei2;

    @Column(name = "password_present")
    private String passwordPresent;

    @Column(name = "faraday_bag")
    private String faradayBag;

    @Column(name = "sim1")
    private String sim1;

    @Column(name = "sim2")
    private String sim2;

    @Column(name = "esim")
    private String eSim;




}
