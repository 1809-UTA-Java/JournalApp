/**
*
* This is an application that takes a filename from the user and opens it to either write to the file, read from the file, or (eventually) write with a 
* byte stream and serialize an object. We'll see on the last part.
*
* @author Brian Morales
*/
package com.revature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JournalApp {
    public static void main(String[] args) {
        // get file name
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the exact file name and only the file name.");
        String sFileName = sc.nextLine();

        // ask for read or append
        System.out.println("Would you like to 'read' or 'append'?");
        String sCommand = sc.next();

        // read from file
        if(sCommand.equals("read")) {
            try(FileReader fr = new FileReader(sFileName)) {
                int iCnt;
                while ((iCnt = fr.read()) != -1) {
                    System.out.print((char) iCnt);
                }
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        // append to file
        } else if(sCommand.equals("append")) {
            try(FileWriter fw = new FileWriter(sFileName, true)) {
                System.out.println("Please enter in a single line all that you wish to append to the file.");
                String sAppend = sc.nextLine();
                fw.write(sAppend);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}