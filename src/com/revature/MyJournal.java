package com.revature;

import java.util.Scanner;
import java.io.*;

class MyJournal {
    public static void main (String[] args) {
       String option = new String();
       
       do {
           option = optionMenu();
            switch (option) {
                case "1":
                    String[] input = writeFileMenu();
                    writeNewFile(input[0], input[1]);
                    break;
                case "2":
                    readFile(readFileMenu());
                    break;
                default:
                    break;
     
            } 
        } while (!option.contentEquals("-1"));
    }

    static boolean readFile(String fileName) {
        try (FileReader fr = new FileReader(fileName)) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            toConsole("");
        } catch (FileNotFoundException ex) {
            toConsole("ERROR: A file with that name DOES NOT exist.");
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return true;
    }

    static String readFileMenu() {
        Scanner s = new Scanner(System.in);

        toConsole("\nEnter existing file's name: ");
        String name = s.nextLine();
        s.close();
        return name;
    }

    static boolean writeNewFile(String fileName, String contents) {
        try(FileWriter fw = new FileWriter(fileName)) {
            fw.write(contents);
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }

    static String[] writeFileMenu() {
        Scanner s = new Scanner(System.in);
        String[] response = new String[2];

        toConsole("\nEnter new file's name: ");
        response[0] = s.nextLine();
        toConsole("Enter file contents: ");
        response[1] = s.nextLine();

        s.close();
        return response;
    }

    static String optionMenu() {
        Scanner s = new Scanner(System.in);
        String option;

        toConsole("*** OPTION MENU ***");
        toConsole("(1) Write text to a file.");
        toConsole("(2) Open & read from an existing file.");
        toConsole("[Enter -1 to exit application]");
        toConsole("Enter operation number you would like to do: ");
        
        do {
            option = s.nextLine();
            
            if (option.contentEquals("-1") || option.contentEquals("1") || option.contentEquals("2")) {
                s.close();
                return option;
            }
        } while (1);
    }

    static void toConsole(String message) {
        System.out.println(message);
    }
}