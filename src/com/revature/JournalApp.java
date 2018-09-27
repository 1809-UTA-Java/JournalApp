package com.revature;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class JournalApp {
    
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Input file name");
        String filename = sc.nextLine();
        File tmp = new File(filename);
        try{
            if (tmp.exists()){
                System.out.println("File Exists - Do you wish to read file [Y/n]");
                char check = sc.next().charAt(0);
                while (check != 'n' && check != 'N' && check != 'y' && check != 'Y'){
                    System.out.println("File Exists - Do you wish to read file [Y/n]");
                    check = sc.next().charAt(0);
                }
                if (check == 'Y' || check == 'y'){
                    FileInputStream in = new FileInputStream(tmp);
                    int c; 
                    while ((c = in.read()) != -1)
                        System.out.print(c);
                    in.close();
                }
                System.out.println("Do you wish to write to file [Y/n]");
                check = sc.next().charAt(0);
                while (check != 'n' && check != 'N' && check != 'y' && check != 'Y'){
                    System.out.println("Do you wish to write to file [Y/n]");
                    check = sc.next().charAt(0);
                }
                if (check == 'Y' || check == 'y'){
                    System.out.println("Input what you wish to write to file");
                    sc.nextLine();
                    String str = sc.nextLine();
                    byte[] b = str.getBytes();
                    FileOutputStream out = new FileOutputStream(tmp);
                    out.write(b);
                    out.close();
                }
            }
            else{
                System.out.println("File does not exist - Input what you wish to write");
                String str = sc.nextLine();
                byte[] b = str.getBytes();
                FileOutputStream out = new FileOutputStream(tmp);
                out.write(b);
                out.close();
            }
        }
        finally{

        }
    }
}