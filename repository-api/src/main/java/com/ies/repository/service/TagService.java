package com.ies.repository.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.repository.entity.Tag;
import com.ies.repository.exception.BusinessException;
import com.ies.repository.exception.EntityNotFoundException;
import com.ies.repository.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	@Transactional
	public Tag saveNewTag(Tag tag) {
		if(existsByTag(tag.getTag())) {
			throw new BusinessException("Tag já cadastrada.");
		}
		return tagRepository.save(tag);
	}
	
	public Tag findByIdTag(Long id) {
		return tagRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tag não cadastrada."));
	}
	
	@Transactional
	public void deleteByIdTag(Long id) {
		findByIdTag(id);
		tagRepository.deleteById(id);
	}
	
	@Transactional
	public Tag updateTag(Tag tag) {
		
		if(existsByTag(tag.getTag())) {
			throw new BusinessException("Tag já cadastrada.");
		}
		
		if(findByIdTag(tag.getIdTag()) == null) {
			throw new EntityNotFoundException("Tag não cadastrada.");
		}
		
		return tagRepository.save(tag);
	}
	
	public Boolean existsByTag(String tag) {
		return tagRepository.existsByTag(tag);
	}
}
