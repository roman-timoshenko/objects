package io;

import java.util.Scanner;

public class Input {
    Scanner in = new Scanner(System.in);
    public int getSize(){
        return in.nextInt();}
    public String[] getNames(){
        String input = in.nextLine();
        String[] temp =  input.split(" ");
        return temp;
    }

}
