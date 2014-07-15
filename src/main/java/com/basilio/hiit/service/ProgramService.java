package com.basilio.hiit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basilio.hiit.dto.ProgramDTO;
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

    @Transactional(readOnly = false)
    public Long store(ProgramDTO toStore) {
        ProgramEntity entity = null;
        if (toStore.isValidId()) {
            entity = programRepo.findOne(toStore.getId());
        } else {
            entity = new ProgramEntity();
        }

        entity.setDurationInSeconds(toStore.getDurationInSeconds());
        entity.setIterations(toStore.getIterations());
        entity.setVersion(toStore.getVersion());

        ProgramEntity stored = programRepo.save(entity);

        // TODO does this make a db call or is it returned from spring data?
        return stored.getId();
    }
}
