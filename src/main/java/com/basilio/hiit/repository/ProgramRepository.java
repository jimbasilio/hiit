package com.basilio.hiit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basilio.hiit.entity.ProgramEntity;

public interface ProgramRepository extends JpaRepository<ProgramEntity, Long> {

}
