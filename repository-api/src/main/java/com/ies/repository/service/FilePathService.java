package com.ies.repository.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.FilePath;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.FilePathRepository;

@Service
public class FilePathService {

	@Autowired
	private FilePathRepository filePathRepository;
	
	@Transactional
	public FilePath saveNewFilePath(FilePath filePath) {
		if (existsByFilePath(filePath.getFilePath())) {
			throw new BusinessException("Caminho do arquivo já está em uso!");
		}
		return filePathRepository.save(filePath);
	}
	
	public List<FilePath> listAllFilePath() {
		List<FilePath> filePath =filePathRepository.findAll();
		
		if (filePath.isEmpty()) {
			throw new EntityNotFoundException("Não existe caminho do arquivo cadastrado.");
		}
		return filePath;
	}
	
	public FilePath findByIdFilePath(Long id) {
		return filePathRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Caminho do arquivo não cadastrado."));
	}
	
	public Boolean existsByFilePath(String filePath) {
		return filePathRepository.existsByFilePath(filePath);
	}

	@Transactional
	public void deleteByIdFilePath(Long id) {
		findByIdFilePath(id);
		filePathRepository.deleteById(id);		
	}

	@Transactional
	public FilePath updateFilePath(FilePath filePath) {
		
		if (existsByFilePath(filePath.getFilePath())) {
			throw new BusinessException("Caminho do arquivo já está em uso!");
		}
		
		if (findByIdFilePath(filePath.getIdFilePath()) == null) {
			throw new EntityNotFoundException("Caminho do arquivo não cadastrado.");
		}
		
		findByIdFilePath(filePath.getIdFilePath());
		return filePathRepository.save(filePath);
	}
}
