package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.Summary;

public interface SummaryRepository extends JpaRepository<Summary, Long> {

}
