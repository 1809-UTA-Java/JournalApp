package com.revature;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;


/**
 * This is a Jornal App that will either make a file for the user
 * to wrtie to, or open an existing file and print the entry
 * to the consol.
 * 
 * Author: Cody Phillips
 */

class JournalApp {

    public static void main(String[] args) {

        int option = 0;
        String filename = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Journal App!");
        
        // Option menu that asks the user to choose between making
        // a file, or to read an exsisiting file.

        while (option !=1 && option !=2){
            System.out.println("Would you like to make a new enrty (1), or open an exsisting one? (2)");
            System.out.print("Type 1 or 2: ");
            option = Integer.parseInt(sc.nextLine());
            if(option !=1 && option !=2)
                System.out.println("Invalid Entry..");
            
        }

        switch (option) {
            case 1: System.out.println("Where would you like to save your file?");
                    System.out.print("Filename: ");
                    filename = sc.nextLine(); 
                    break;
            case 2: System.out.println("Which file would you like to open?");
                    System.out.print("Filename: ");
                    filename = sc.nextLine();
                    break;
            default:break;
        }
        
        if(option==1)
            fileWriter(filename, sc);
        else if (option ==2)
            fileReader(filename);

        sc.close();
  
    }

    static void fileWriter(String filename, Scanner sc){

        try(FileWriter fw = new FileWriter(filename)) {
            System.out.println("Type your journal entry below. Type 'exit' when you want to save the file.\n");
            String journalEntry = sc.nextLine();
            fw.write(journalEntry);
            while(true) {
                journalEntry = sc.nextLine();
                if(journalEntry.equals("exit"))
                    break;
                fw.write("\n" + journalEntry);
            }
        } catch ( IOException ex) {
            ex.printStackTrace();
        }
    }

    static void fileReader(String filename){

        try(FileReader fr = new FileReader(filename)) {
            int i;
            while ((i = fr.read()) !=-1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}