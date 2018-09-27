package com.revature;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;


/**
 * This is a Jornal App that will prompt you for a file
 * name to write your journal entry to. Once you have given 
 * the app a file name, it will ask you type your entry.
 * 
 * After saving your entry to the file, the Journal App opens
 * and reads that file and displays the entry.
 * 
 * Author Cody Phillips
 */

class JournalApp {

    public static void main(String[] args) {

        //int option = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Journal App!");
        System.out.println("What would you like to name you file?");
        System.out.print("Filename: ");
        String filename = sc.nextLine();
        
        // Option menu that asks the user to choose between making
        // a file, or to read an exsisiting file.

        /*while (option !=1 && option !=2){
            System.out.println("Would you like to make a new enrty (1), or open an exsisting one? (2)");
            System.out.print("Type 1 or 2: ");
            option = sc.nextInt();
            //System.out.println(option);
            if(option !=1 && option !=2)
                System.out.println("Invalid Entry..");
            
        }

        if(option==1) {
            System.out.println("Where would you like to save your file?");
            System.out.print("Filename: ");
            //filename = sc.nextLine(); 
            fileWriter(filename, sc);
        }
        if(option==2) {
            System.out.println("Which file would you like to open?");
            System.out.print("Filename: ");
            //filename = sc.nextLine();
            fileReader(filename);
        }*/

        try(FileWriter fw = new FileWriter(filename)) {

            System.out.println("Type your journal entry below.\n");
            String journalEntry = sc.nextLine();
            fw.write(journalEntry);

        }catch ( IOException ex) {
            ex.printStackTrace();
        }

        try( FileReader fr = new FileReader(filename)) {

            int i;
            while ((i = fr.read()) !=-1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        sc.close();  
    }

    //Methods implemented, something is causing an issue when
    // using the option feature above.

    /*static void fileWriter(String filename, Scanner sc){
        try(FileWriter fw = new FileWriter(filename)) {

            System.out.println("Type your journal entry below.\n");
            String journalEntry = sc.nextLine();
            fw.write(journalEntry);

        }catch ( IOException ex) {
            ex.printStackTrace();
        }
    }

    static void fileReader(String filename){

        try( FileReader fr = new FileReader(filename)) {

            int i;
            while ((i = fr.read()) !=-1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}