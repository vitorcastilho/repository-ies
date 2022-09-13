package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.KindOfWork;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.KindOfWorkRepository;

@Service
public class KindOfWorkService {

	@Autowired
	private KindOfWorkRepository kindOfWorkRepository;
	
	@Transactional
	public KindOfWork saveNewKindOfWork(KindOfWork kindOfWork) {
		if (existsByKindOfWork(kindOfWork.getKindOfWork())) {
			throw new BusinessException("Tipo de trabalho já cadastrado.");
		}
		return kindOfWorkRepository.save(kindOfWork);
	}
	
	public List<KindOfWork> listAllKindOfWork() {
		List<KindOfWork> kindOfWork = kindOfWorkRepository.findAll();
		
		if (kindOfWork.isEmpty()) {
			throw new EntityNotFoundException("Não existe tipo de trabalho cadastrado.");
		}
		return kindOfWork;
	}
	
	public KindOfWork findByIdKindOfWork(Long id) {
		return kindOfWorkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tipo de trabalho não cadastrado."));
	}
	
	@Transactional
	public void deleteByIdKindOfWork(Long id) {
		findByIdKindOfWork(id);
		kindOfWorkRepository.deleteById(id);
	}
	
	@Transactional
	public KindOfWork updateKindOfWork(KindOfWork kindOfWork ) {
		findByIdKindOfWork(kindOfWork.getIdKindOfWork());
		return kindOfWorkRepository.save(kindOfWork);
	}
	
	public Boolean existsByKindOfWork(String kindOfWork) {
		return kindOfWorkRepository.existsByKindOfWork(kindOfWork);
	}
}
