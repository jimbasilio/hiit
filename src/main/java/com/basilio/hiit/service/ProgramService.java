package com.basilio.hiit.service;

import java.util.List;
import java.util.stream.Collectors;

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
        return programMapper.toDTO(programRepo.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<ProgramGridDTO> getAllByUserId(String user) {
        return programRepo.findByUserName(user).stream()
                .map(ProgramGridDTO::new).collect(Collectors.toList());
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
