package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.FinalPaper;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.FinalPaperRepository;

@Service
public class FinalPaperService {

	@Autowired
	private FinalPaperRepository finalPaperRepository;
	
	@Transactional
	public FinalPaper saveNewFinalPaper(FinalPaper finalPaper) {
		return finalPaperRepository.save(finalPaper);
	}
	
	public List<FinalPaper> listAllFinalPaper() {
		List<FinalPaper> finalPaper = finalPaperRepository.findAll();
		
		if (finalPaper.isEmpty()) {
			throw new EntityNotFoundException("Não existe TCC cadastrado.");
		}
		
		return finalPaper;
	}
	
	public FinalPaper findByIdFinalPaper(Long id) {
		return finalPaperRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TCC não cadastrado."));
	}	
	
	@Transactional
	public void deleteByIdFinalPaper(Long id) {
		findByIdFinalPaper(id);
		finalPaperRepository.deleteById(id);
	}
	
	@Transactional
	public FinalPaper updateFinalPaper(FinalPaper finalPaper) {
		findByIdFinalPaper(finalPaper.getIdFinalPaper());
		return finalPaperRepository.save(finalPaper);
	}
	
	//Falta definir uma verificação se o TCC já está cadastrado!!
}
