package br.com.casadocodigo.loja.infra;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	public String write(String baseFolder,MultipartFile file){
		String homeParh = System.getProperty("user.home");
		String baseFolderPath = homeParh +"/"+baseFolder;
		String filePath = baseFolderPath + "/"+file.getOriginalFilename();
		try {
			file.transferTo(new File(filePath));
			return filePath;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
