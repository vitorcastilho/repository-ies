package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.FilePath;

public interface FilePathRepository extends JpaRepository<FilePath, Long> {

	Boolean existsByFilePath(String filePath);

}
