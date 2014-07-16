package com.basilio.hiit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.entity.ProgramEntity;
import com.basilio.hiit.repository.ProgramRepository;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepo;

    public ProgramDTO getById(Long id) {
        return new ProgramDTO(programRepo.findOne(id));
    }

    public Long store(ProgramDTO toStore) {
        ProgramEntity entityToStore = programRepo.findOne(toStore.getId());
        entityToStore.setDurationInSeconds(toStore.getDurationInSeconds());
        entityToStore.setIterations(toStore.getIterations());
        entityToStore.setVersion(toStore.getVersion());

        ProgramEntity stored = programRepo.save(entityToStore);

        // TODO does this make a db call or is it returned from spring data?
        return stored.getId();
    }
}
