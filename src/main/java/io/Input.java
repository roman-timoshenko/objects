package io;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    public Input(Scanner scanner){
        this.scanner = scanner;
    }
    public int getSize(){
        return scanner.nextInt();}
    public String[] getNames(){
        String input = scanner.nextLine();
        String[] temp =  input.split(" ");
        return temp;
    }

}
