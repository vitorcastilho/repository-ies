package com.ies.repository.storage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	@Value("${SAVE_ON_DISK.ROOT}")
	private static String root;

	@Value("${SAVE_ON_DISK.DIRECTORY}")
	private static String directory;

	public static String saveFile(String fileName, MultipartFile multipartFile, String author) throws IOException {
		String dir = author;
		Path uploadPath = Paths.get("Files-Upload", dir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		String fileCode = RandomStringUtils.randomAlphanumeric(8);

		Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save file: " + fileName, ioe);
		}

		return filePath.toString();
	}
}
