package main;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {
    public static void main(String[] args) {
        //System.out.println("Hello world");

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(new Main());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        System.out.println("Pressionou: " + NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
        System.out.println("Soltou: " + NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));
    }

    @Override
    public  void nativeKeyTyped(NativeKeyEvent nativeEvent) {

    }
}
