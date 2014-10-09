package com.basilio.hiit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.dto.display.ProgramGridDTO;
import com.basilio.hiit.entity.ProgramEntity;
import com.basilio.hiit.repository.ProgramRepository;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepo;

    @Transactional(readOnly = true)
    public ProgramDTO getById(Long id) {
        return new ProgramDTO(programRepo.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<ProgramGridDTO> getAllByUserId(String user) {
        return programRepo.findByUserName(user).stream()
                .map(ProgramGridDTO::new).collect(Collectors.toList());
        // .collect(Collectors.toList());
        // return new ProgramDTO(programRepo.findByUserName(user));
    }

    @Transactional(readOnly = false)
    public Long store(ProgramDTO toStore) {
        ProgramEntity entity = null;
        if (toStore.isValidId()) {
            entity = programRepo.findOne(toStore.getId());
        } else {
            entity = new ProgramEntity();
        }

        entity.setIterations(toStore.getIterations());
        entity.setVersion(toStore.getVersion());
        entity.setCreationDate(toStore.getCreationDate());
        entity.setName(toStore.getName());

        ProgramEntity stored = programRepo.save(entity);

        // TODO does this make a db call or is it returned from spring data?
        return stored.getId();
    }
}
