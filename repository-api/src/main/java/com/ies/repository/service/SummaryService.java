package com.ies.repository.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.Summary;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.SummaryRepository;

@Service
public class SummaryService {

	@Autowired
	private SummaryRepository summaryRepository;

	@Transactional
	public Summary saveNewSummary(Summary summary) {
		return summaryRepository.save(summary);
	}

	public Summary findSummaryById(Long id) {
		return summaryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Resumo não cadastrado."));
	}

	@Transactional
	public void deleteByIdSummary(Long id) {
		findSummaryById(id);
		summaryRepository.deleteById(id);
	}
	
	@Transactional
	public Summary updateSummary(Summary summary) {		
		findSummaryById(summary.getIdSummary());		
		return summaryRepository.save(summary);
	}

}
