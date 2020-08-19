package ar.com.EduIt.Notepad.Controler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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
	
	
	public String read(File file ) throws FileNotFoundException,IOException {
		
		if (!file.canRead()) {
			throw new IOException("Could not read file " + file.getPath());
		}
		
		if (!file.exists()) {
			throw new FileNotFoundException(file.getPath() + " not found.");			
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
	
	
	public void write(String lines, File file) throws IOException, FileNotFoundException {
		
		
		if (!file.exists()) {
			throw new FileNotFoundException(file.getPath() + " not found.");			
		}
		if (!file.canWrite()) {
			throw new IOException("Could not read file " + file.getPath());
		}
		
		BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file));
		bufferWriter.write(lines + "\n");
		bufferWriter.close(); // Save file

		
	}
	
	public boolean createFile(File file) throws CouldNotCreateFileException {
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				throw new CouldNotCreateFileException("Could not create file " + file.getPath(), ex);
			}
			return true;
		}
		return false;
	}

}
