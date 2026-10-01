package net.pulove.todo_management.service;

import net.pulove.todo_management.dto.MobileEvidenceDto;

import java.util.List;

public interface MobileEvidenceService {
    MobileEvidenceDto addMobileEvidence(MobileEvidenceDto mobileEvidenceDto);
    MobileEvidenceDto getMobileEvidenceById(Long id);
    List<MobileEvidenceDto> getAllMobileEvidence();
    MobileEvidenceDto updateMobileEvidence(Long id, MobileEvidenceDto mobileEvidenceDto);
    void deleteMobileEvidence(Long id);
}
