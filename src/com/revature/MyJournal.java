package com.revature;

import java.util.Scanner;
import java.io.*;

enum Actions {
    WRITE, READ, EXIT;
}

class MyJournal {
    public static void main (String[] args) {
       String option = new String();
       Scanner s = new Scanner(System.in);
       
       do {
            MyIO.optionMenu();
        
            do {
                option = s.nextLine().toUpperCase();
            
                if (option.contains(Actions.WRITE.toString()) ||
                    option.contains(Actions.READ.toString()) ||
                    option.contains(Actions.EXIT.toString())) 
                {
                    break;
                } else {
                    MyIO.toConsole("\nINVALID INPUT!\n");
                    MyIO.optionMenu();
                }
            } while (true);

            switch (option) {
                case "WRITE":
                    String[] input = new String[2];

                    MyIO.toConsole("\nEnter new file's name: ");
                    input[0] = s.nextLine();
                    MyIO.toConsole("Enter file contents: ");
                    input[1] = s.nextLine();
                    MyIO.writeNewFile(input[0], input[1]);
                    break;
                case "READ":
                   MyIO.readFileMenu();
                   String name = s.nextLine();

                    MyIO.readFile(name);
                    break;
                default:
                    break;
     
            } 
        } while (!option.contentEquals("-1"));
    }
}