package com.revature;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fileFound = true;
        System.out.println("Enter a filename to write to: ");
        String fileName = sc.next();

        System.out.println("You entered " + fileName);

        try (FileReader fr = new FileReader(fileName)) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException ex) {
            // ex.printStackTrace();
            fileFound = false;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if (!fileFound) {
            System.out.println("Type to save to new file. Type exit to save and close program: ");

            String str = "";
            while (!str.equals("exit")) {
                str = sc.next();
            }
            byte data[] = str.getBytes();

            try {
                FileOutputStream out = new FileOutputStream(fileName);
                out.write(data);
                out.close();                
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();;
            }
            catch (IOException e) {
                e.printStackTrace();;
            }
        }

        sc.close();
    }
}