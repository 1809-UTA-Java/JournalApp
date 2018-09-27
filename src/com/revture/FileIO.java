package com.revture;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename;
        System.out.println("Please enter a new or existing filename");
        filename = sc.nextLine();
        ParseFile ps = new ParseFile();

        try (FileReader fr = new FileReader(filename)) {
            ps.read(filename, fr);
        } catch (FileNotFoundException ex) {
            ps.write(filename, sc);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        sc.close();
    }
}