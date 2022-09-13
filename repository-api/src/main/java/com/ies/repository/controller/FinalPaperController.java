package com.ies.repository.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.repository.dto.FinalPaperDto;
import com.ies.repository.entity.FinalPaper;
import com.ies.repository.service.FinalPaperService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/final-paper")
public class FinalPaperController {

	@Autowired
	private FinalPaperService finalPaperService;
	
	@PostMapping
	public ResponseEntity<Object> saveNewFinalPaper(@RequestBody @Valid FinalPaperDto finalPaperDto){
		var finalPaper = new FinalPaper();
		BeanUtils.copyProperties(finalPaperDto, finalPaper);
		return ResponseEntity.status(HttpStatus.CREATED).body(finalPaperService.saveNewFinalPaper(finalPaper));
	}
	
	@GetMapping
	public ResponseEntity<List<FinalPaper>> getAllFinalPaper() {
		return ResponseEntity.status(HttpStatus.OK).body(finalPaperService.listAllFinalPaper());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FinalPaper> getFinalPaperById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(finalPaperService.findByIdFinalPaper(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteByIdFinalPaper(@PathVariable Long id) {
		finalPaperService.deleteByIdFinalPaper(id);
		return ResponseEntity.status(HttpStatus.OK).body("TCC excluído com sucesso.");
	}
	
	@PutMapping
	public ResponseEntity<Object> updateFinalPaper(@RequestBody @Valid FinalPaperDto finalPaperDto) {
		var finalPaper = new FinalPaper();
		BeanUtils.copyProperties(finalPaperDto, finalPaper);
		return ResponseEntity.status(HttpStatus.CREATED).body(finalPaperService.updateFinalPaper(finalPaper));
	}
}
