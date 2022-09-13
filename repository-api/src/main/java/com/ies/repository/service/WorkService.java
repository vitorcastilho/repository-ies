package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.Work;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.WorkRepository;

@Service
public class WorkService {

	@Autowired
	private WorkRepository workRepository;

	@Transactional
	public Work saveNewWork(Work work) {
		if (existsWork(work)) {
			throw new BusinessException("Trabalho já cadastrado.");
		}
		return workRepository.save(work);
	}

	public List<Work> listAllWork() {
		List<Work> workList = workRepository.findAll();
		if(workList.isEmpty()) {
			throw new EntityNotFoundException("Ainda não existe trabalho cadastrado.");
		}
		return workList;
	}

	public Work findWorkById(Long id) {
		return workRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trabalho não cadastrado."));
	}
	
	@Transactional
	public void deleteByIdWork(Long id) {
		findWorkById(id);
		workRepository.deleteById(id);
	}
	
	@Transactional
	public Work updateWork(Work work) {
		findWorkById(work.getIdWork());
		return workRepository.save(work);
	}
	
	public Boolean existsWork(Work work) {
		if (workRepository.existsByFilePath(work.getFilePath())) {
			return true;
		}
		return false;
	}
}
