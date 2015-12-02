package com.basilio.hiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basilio.hiit.dto.ProgramDTO;
import com.basilio.hiit.dto.display.ProgramGridDTO;
import com.basilio.hiit.service.ProgramService;

@RestController
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @RequestMapping(value = "/getAllForUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProgramGridDTO> getById() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        return programService.getAllByUserId(auth.getName());
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProgramDTO getById(@PathVariable(value = "id") Long id) {
        return programService.getById(id);
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long store(ProgramDTO dtoToStore) {
        return programService.store(dtoToStore);
    }

}
