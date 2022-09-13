package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.KindOfWork;

public interface KindOfWorkRepository extends JpaRepository<KindOfWork, Long> {

	Boolean existsByKindOfWork(String kindOfWork);

}
