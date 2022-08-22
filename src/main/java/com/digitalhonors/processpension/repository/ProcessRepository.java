package com.digitalhonors.processpension.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalhonors.processpension.model.PensionDetail;

public interface ProcessRepository extends JpaRepository<PensionDetail, Long> {
  
}
