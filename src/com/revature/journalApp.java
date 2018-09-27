package com.revature;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;

public class journalApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName;

        System.out.print("Enter a File Name: ");
        fileName = sc.nextLine();
        File workingFile = new File(fileName);
        if(workingFile.exists()){
            System.out.println("There is already a file with that name.  Would you like to view contents?");
            String choice = sc.nextLine();
            if(choice.equals("Y")||choice.equals("y")){
                readFile(fileName);
            }
        }else{
            writeToFile(fileName);
        }
        sc.close();
    }
    private static void writeToFile(String fileName){
        // implementation of writing text directly
        // try(FileWriter fw = new FileWriter(fileName)){
        //     fw.write(enterData());
        // }catch(IOException ex){
        //     ex.printStackTrace();
        // }

        // implementation of serialize
        try(ObjectOutputStream oos =
            new ObjectOutputStream(
                new FileOutputStream(fileName))){
                    oos.writeObject(obj);
                }
    }

    private static void readFile(String fileName){
        // try(FileReader fr = new FileReader(fileName)){
        //     int i;
        //     while((i = fr.read())!=-1){
        //         System.out.print((char) i);
        //     }
        // }catch(FileNotFoundException ex){
        //     ex.printStackTrace();
        // }catch(IOException ex){
        //     ex.printStackTrace();
        // }
    }

    private static String enterData(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String entry="";
        
        System.out.println("Please enter some data, when done type EditD1 on a new line:");
        while(!entry.equals("EditD1")){
            entry = sc.next();
            sb.append(entry);
        }
        
        sc.close();
        return sb.toString();
    }
}