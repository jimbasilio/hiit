package com.basilio.hiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.service.ProgramService;

@RestController
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @RequestMapping(value = "/getById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProgramDTO getById(
            @RequestParam(value = "id", required = true) Long id) {
        return programService.getById(id);
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long store(ProgramDTO dtoToStore) {
        return programService.store(dtoToStore);
    }

}
