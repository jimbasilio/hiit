package com.basilio.hiit.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.service.ProgramService;

public class ProgramServiceTest extends BaseIntegrationTest {

    @Autowired
    ProgramService sut;

    @Test
    public void testStore() {
        ProgramDTO toSave = new ProgramDTO();
        toSave.setName("test program");
        toSave.setIterations(10);

        Long newId = sut.store(toSave);

        ProgramDTO savedDTO = sut.getById(newId);
        Assert.assertEquals(toSave.getIterations(), savedDTO.getIterations());
    }
}
