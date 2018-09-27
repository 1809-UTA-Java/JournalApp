package com.revture;

import java.io.Serializable;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class ParseFile implements Serializable {
    public void write (String filename, Scanner sc) {
        try (FileWriter fw = new FileWriter(filename)) {
            String input;
            StringBuilder sb = new StringBuilder();

            System.out.println("Now writing to "+filename+" enter a blank line to quit");
            
            do {
                input = sc.nextLine();
                sb.append(input+"\n");
            } while (!input.equals(""));

            fw.write(sb.toString());
        } catch (IOException IOEx) {
            IOEx.printStackTrace();
        }
    }
    public void read (String filename, FileReader fr) throws FileNotFoundException, IOException {
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
    }
}