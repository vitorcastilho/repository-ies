package com.ies.repository.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SaveOnDisk {

	@Value("${SAVE_ON_DISK.ROOT}")
	private String root;

	@Value("${SAVE_ON_DISK.DIRECTORY}")
	private String directory;

	public Path saveWork(MultipartFile work) {
		return this.saveFile(this.directory, work);
	}

	private Path saveFile(String directory, MultipartFile work) {
		Path directoryPath = Paths.get(this.root, directory);
		Path filePath = directoryPath.resolve(work.getOriginalFilename());
		
		try {
			Files.createDirectories(directoryPath);
			work.transferTo(filePath);
			return filePath.getParent();
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar o arquivo.");
		}
		
	}
	
}
