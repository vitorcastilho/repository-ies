package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	boolean existsBySubjectCode(String subjectCode);

}
