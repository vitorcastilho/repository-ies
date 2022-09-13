package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.FilePath;
import com.ies.repository.entity.KindOfWork;
import com.ies.repository.entity.Subject;
import com.ies.repository.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {

	boolean existsBySubject(Subject subject);

	boolean existsByKindOfWork(KindOfWork kindOfWork);

	boolean existsByFilePath(FilePath filePath);

}
