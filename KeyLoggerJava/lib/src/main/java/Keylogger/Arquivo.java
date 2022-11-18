package Keylogger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	public static void criar(String filename) {
		try {
			File novo = new File(filename);
			novo.createNewFile();
			System.out.println("Arquivo criado");
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	public static void escrever(String filename, String conteudo)  {
		try {
			File existente = new File(filename);
			FileWriter fw = new FileWriter(existente, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(conteudo);
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	

}
