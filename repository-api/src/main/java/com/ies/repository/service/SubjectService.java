package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.Subject;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Transactional
	public Subject saveNewSubject(Subject subject) {
		
		if (existsBySubjectCode(subject.getSubjectCode())) {
			throw new BusinessException("Código de matéria já cadastrado!");
		}
		return subjectRepository.save(subject);
	}
	
	public List<Subject> listAllSubject() {
		List<Subject> subjectList = subjectRepository.findAll();
		if (subjectList.isEmpty()) {
			throw new EntityNotFoundException("Ainda não existe matéria cadastrada.");
		}
		return subjectList;
	}
	
	public Subject findByIdSubject(Long id) {
		return subjectRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Matéria não cadastrada"));
	}
	
	@Transactional
	public Boolean deleteByIdSubject(Long id) {
		Subject subject = findByIdSubject(id);
		boolean valid = subject != null;
		
		if (!valid) {
			throw new EntityNotFoundException("Matéria não cadastrada");
		}
		
		subjectRepository.deleteById(id);
		
		return valid;
	}
	
	@Transactional
	public Subject updateSubject(Subject subject) {
		
		if (findByIdSubject(subject.getIdSubject()) == null) {
			throw new EntityNotFoundException("Matéria não cadastrada");
		}
		return subjectRepository.save(subject);
	}
	
	private boolean existsBySubjectCode(String subjectCode) {
		return subjectRepository.existsBySubjectCode(subjectCode);
	}
}
