package net.pulove.todo_management.controller;

import lombok.AllArgsConstructor;
import net.pulove.todo_management.dto.MobileEvidenceDto;
import net.pulove.todo_management.entity.MobileEvidence;
import net.pulove.todo_management.service.MobileEvidenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/mobileEvidence")
@AllArgsConstructor
public class MobileEvidenceController {


    private MobileEvidenceService mobileEvidenceService;

    //Build Mobile Evidence Form REST API

    @PostMapping
    public ResponseEntity<MobileEvidenceDto> addMobileEvidence(@RequestBody MobileEvidenceDto mobileEvidenceDto) {
        MobileEvidenceDto saveMobileEvidence = mobileEvidenceService.addMobileEvidence(mobileEvidenceDto);
        return new ResponseEntity<>(saveMobileEvidence, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MobileEvidenceDto>> getAllMobileEvidence() {
        List<MobileEvidenceDto> mobileEvidenceDtos = mobileEvidenceService.getAllMobileEvidence();
        return ResponseEntity.ok(mobileEvidenceDtos);

    }

    @GetMapping("{id}")
    public ResponseEntity<MobileEvidenceDto> getMobileEvidenceById(@PathVariable("id") Long id){
        mobileEvidenceService.getMobileEvidenceById(id);
        return new ResponseEntity<>(mobileEvidenceService.getMobileEvidenceById(id), HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<MobileEvidenceDto> updateMobileEvidence(@RequestBody MobileEvidenceDto mobileEvidenceDto,
                                                                  @PathVariable("id") Long id) {
        mobileEvidenceService.updateMobileEvidence(id, mobileEvidenceDto);
        return new ResponseEntity<>(mobileEvidenceService.getMobileEvidenceById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMobileEvidence(@PathVariable("id") Long id) {
        mobileEvidenceService.deleteMobileEvidence(id);
        return ResponseEntity.ok("Mobile Evidence Details Deleted");
    }

}
