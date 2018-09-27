package com.revture;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

class FileIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename;
        System.out.println("Please enter a new or existing filename");
        filename = sc.nextLine();

        try (FileReader fr = new FileReader(filename)) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(filename);
                String input;
                StringBuilder sb = new StringBuilder();

                System.out.println("Now writing to "+filename+" enter a blank line to quit");
                
                do {
                    input = sc.nextLine();
                    sb.append(input+"\n");
                } while (!input.equals(""));
                fw.write(sb.toString());
                fw.close();
            } catch (IOException IOEx) {
                IOEx.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        sc.close();
    }
}