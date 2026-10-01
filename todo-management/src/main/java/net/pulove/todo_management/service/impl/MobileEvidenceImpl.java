package net.pulove.todo_management.service.impl;

import lombok.AllArgsConstructor;
import net.pulove.todo_management.dto.MobileEvidenceDto;
import net.pulove.todo_management.entity.MobileEvidence;
import net.pulove.todo_management.exception.ResourceNotFoundException;
import net.pulove.todo_management.repository.MobileEvidenceRepository;
import net.pulove.todo_management.service.MobileEvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MobileEvidenceImpl implements MobileEvidenceService {
    private ModelMapper modelMapper;
    private MobileEvidenceRepository mobileEvidenceRepository;

    @Override
    public MobileEvidenceDto addMobileEvidence(MobileEvidenceDto mobileEvidenceDto) {
        MobileEvidence mobileEvidence=modelMapper.map(mobileEvidenceDto, MobileEvidence.class);
        MobileEvidence savedMobileEvidence= mobileEvidenceRepository.save(mobileEvidence);
        MobileEvidenceDto savedMobileEvidenceReturn =modelMapper.map(savedMobileEvidence, MobileEvidenceDto.class);
        return  savedMobileEvidenceReturn;




    }

    @Override
    public MobileEvidenceDto getMobileEvidenceById(Long id) {
        MobileEvidence mobileEvidence=mobileEvidenceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Mobile not found for id:"+id));
        return modelMapper.map(mobileEvidence, MobileEvidenceDto.class);

    }

    @Override
    public List<MobileEvidenceDto> getAllMobileEvidence() {
        List<MobileEvidence> listOfMobileEvidence=mobileEvidenceRepository.findAll();
        return  listOfMobileEvidence.stream().map((mobileEvidence) -> modelMapper.map(mobileEvidence, MobileEvidenceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MobileEvidenceDto updateMobileEvidence(Long id, MobileEvidenceDto mobileEvidenceDto) {

        MobileEvidence mobileEvidence = mobileEvidenceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Mobile not found for id:"+id));
        mobileEvidence.setInvestigationOfficer(mobileEvidenceDto.getInvestigationOfficer());
        mobileEvidence.setOfficeOrSection(mobileEvidenceDto.getOfficeOrSection());
        mobileEvidence.setRefNo(mobileEvidenceDto.getRefNo());
        mobileEvidence.setDate(mobileEvidenceDto.getDate());
        mobileEvidence.setExhibitMarking(mobileEvidenceDto.getExhibitMarking());
        mobileEvidence.setMobileOwner(mobileEvidenceDto.getMobileOwner());
        mobileEvidence.setPhysicalAppearance(mobileEvidenceDto.getPhysicalAppearance());
        mobileEvidence.setStatus(mobileEvidenceDto.getStatus());
        mobileEvidence.setBrand(mobileEvidenceDto.getBrand());
        mobileEvidence.setColor(mobileEvidenceDto.getColor());
        mobileEvidence.setFaradayBag(mobileEvidenceDto.getFaradayBag());
        mobileEvidence.setSim1(mobileEvidenceDto.getSim1());
        mobileEvidence.setSim2(mobileEvidenceDto.getSim2());
        mobileEvidence.setESim(mobileEvidenceDto.getESim());

        MobileEvidence updateMobileEvidence=mobileEvidenceRepository.save(mobileEvidence);
        return modelMapper.map(updateMobileEvidence, MobileEvidenceDto.class);


    }

    @Override
    public void deleteMobileEvidence(Long id) {
        mobileEvidenceRepository.deleteById(id);

    }
}
