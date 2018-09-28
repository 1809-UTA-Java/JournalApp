package com.revature;
/**
 * Jamie Edwards' attempt at the journal program.
 * This should read from a file, write to a file
 * and optionally write to a byte stream.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
//is one import java.io.* better than  seperate import lines?
import java.util.Scanner;
import java.util.BufferedInputStream;

public class journalApp{
public static void main (String args[]) {
    String fileName = "Journal";
    Scanner sc = new Scanner(System.in);

    system.out.println("What do you want to write in your journal today?");
    system.out.println("Enter EXIT to stop writing.");
    try {
        while(true){
            String inputText = sc.nextLine();
                try{
                    FileWriter fw = new FileWriter(fileName);{
                    if(sc.nextLine.equal("EXIT")){break;}
                    fw.append(inputText);
                    sytem.out.println("You added " +inputText +" to your journal.");
                    }catch(IOException ex){ex.printStackTrace();}
                }catch (Exception e){
                    ex.printStackTrace();
                    }finally {sc.close();}
        }
    }
}