package com.basilio.hiit.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.service.ProgramService;

@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(true)
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
