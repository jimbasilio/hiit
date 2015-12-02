package com.basilio.hiit.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.dto.display.ProgramGridDTO;
import com.basilio.hiit.entity.ProgramEntity;
import com.basilio.hiit.mapper.ProgramEntityMapper;
import com.basilio.hiit.repository.ProgramRepository;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepo;

    @Autowired
    private ProgramEntityMapper programMapper;

    @Transactional(readOnly = true)
    public ProgramDTO getById(Long id) {
        ProgramDTO dummyResult = new ProgramDTO();
        dummyResult.setCreationDate(LocalDate.now());
        dummyResult.setId(99l);
        dummyResult.setIterations(5);
        dummyResult.setName("burpees");
        dummyResult.setVersion(1l);

        return dummyResult;
        // return programMapper.toDTO(programRepo.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<ProgramGridDTO> getAllByUserId(String user) {
        ProgramGridDTO dummyResult1 = new ProgramGridDTO();
        dummyResult1.setCreationDate(LocalDate.now());
        dummyResult1.setName("mountain climbers");

        ProgramGridDTO dummyResult2 = new ProgramGridDTO();
        dummyResult2.setCreationDate(LocalDate.now());
        dummyResult2.setName("burpees");

        return Arrays.asList(dummyResult1, dummyResult2);
        // return programRepo.findByUserName(user).stream()
        // .map(ProgramGridDTO::new).collect(Collectors.toList());
        // .collect(Collectors.toList());
        // return new ProgramDTO(programRepo.findByUserName(user));
    }

    @Transactional(readOnly = false)
    public Long store(ProgramDTO dto) {
        ProgramEntity entity = null;
        if (dto.isValidId()) {
            entity = programRepo.findOne(dto.getId());
        } else {
            entity = new ProgramEntity();
        }

        entity = programMapper.toEntity(entity, dto);

        ProgramEntity stored = programRepo.save(entity);

        // TODO does this make a db call or is it returned from spring data?
        return stored.getId();
    }
}
