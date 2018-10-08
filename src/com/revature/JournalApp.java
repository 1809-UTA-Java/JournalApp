package com.revature;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * @Nishan Shrestha
 * studying code
 */
public class JournalApp{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String fileName = input.nextLine();

        try{
            FileWriter fwrite = new FileWriter(fileName);
            System.out.println("Write your journal " + fileName);
            String user = input.nextLine();
            fwrite.write(user);
            fwrite.close(); 
        } 
        catch (IOException ex) {
             ex.printStackTrace();
        }

        System.out.println("Reading file " + fileName);
        try (FileReader fread = new FileReader(fileName)) {
            int i;
            while ((i = fread.read()) != -1) {
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