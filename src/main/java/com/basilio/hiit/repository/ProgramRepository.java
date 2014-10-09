package com.basilio.hiit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.basilio.hiit.entity.ProgramEntity;

public interface ProgramRepository extends JpaRepository<ProgramEntity, Long> {
    // @Query("select p from #{#entityName} p where p.createdBy = ?1")
    // List<ProgramEntity> findByUserName(String user);
    @Query("select p from #{#entityName} p")
    List<ProgramEntity> findByUserName(String user);
}
