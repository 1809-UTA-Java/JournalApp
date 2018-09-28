package com.revature;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;

public class Journal {
    String fileName;
    boolean fileFound;
    Scanner sc;


    Journal() {
        fileName = "";
        fileFound = false;
        sc = new Scanner(System.in);
    }

    void openJournal() {
        System.out.println("Welcome! Enter a file name you'd like to open: ");
        fileName = sc.next();

        System.out.println("Opening " + fileName + "...");

        try (FileReader fr = new FileReader(fileName)) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException ex) {
            fileFound = false;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // if (!fileFound) {
            createJournal();
        // }
    }

    void createJournal() {
        System.out.println("Type to save to new entry. Type exit to save and close program: ");

        FileOutputStream out;
        String str = "";
        try {
            out = new FileOutputStream(fileName); 
            while (!str.equals("exit")) {
                str = sc.nextLine();
                byte data[] = str.concat("\n").getBytes();
                out.write(data);
            }             
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    void closeJournal() {
        sc.close();
    }

}