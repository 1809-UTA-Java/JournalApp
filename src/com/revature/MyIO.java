package com.revature;

import java.io.*;

class MyIO {

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

    static void readFileMenu() {
        toConsole("\nEnter existing file's name: ");
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

    static void optionMenu() {
        toConsole("*** OPTION MENU ***");
        toConsole("1. WRITE a file.");
        toConsole("2. READ from an existing file.");
        toConsole("3. EXIT application");
        toConsole("Enter operation name: ");
    }

    static void toConsole(String message) {
        System.out.println(message);
    }

}