package ar.com.EduIt.Notepad.Controler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.Exception;


public class FileUtil {
	
	
	public boolean createFile(String filePath) throws CouldNotCreateFileException {
		File file = new File(filePath);
		
		if ((!file.exists()) && (filePath != null)) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new CouldNotCreateFileException();
			}
			return true;
			
		}
		return false;
		
		
		
	}
	
	
	public String read(String filePath) throws FileNotFoundException,IOException {
		File file = new File(filePath);
		
		if (!file.canRead()) {
			throw new IOException("Could not read file " + filePath);
		}
		
		if (!file.exists()) {
			throw new FileNotFoundException(filePath + " not found.");			
		}
		
		Reader reader = new FileReader(file);
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		StringBuilder text = new StringBuilder();
		String line = "";
		
		while ((line = bufferedReader.readLine()) != null) {
			text.append(line)
				.append("\n");
		}
		
		bufferedReader.close();
		
		return text.toString();
		
	}

}
