package ar.com.EduIt.Notepad.Controler;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileUtil file = new FileUtil();
		
		
		try {
   			file.createFile("C:\\Users\\jasfo\\Desktop\\prueba2.txt");
		} catch (CouldNotCreateFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(file.read("C:\\Users\\jasfo\\Desktop\\prueba.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
