package com.revature;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JournalApp{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Name your file...");
        String fileName = scan.nextLine();

        try{
            FileWriter fw = new FileWriter(fileName);
            System.out.println("What would you like to write to " + fileName);
            String user = scan.nextLine();
            fw.write(user);
            fw.close(); 
        } 
        catch (IOException ex) {
             ex.printStackTrace();
        }

        System.out.println("Reading file " + fileName);
        try (FileReader fr = new FileReader(fileName)) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}