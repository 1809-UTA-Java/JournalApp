package com.revature;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class MyJournal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        optionList();
        option = sc.nextInt();
        fileOutput(option);
        sc.close();
    }

    static void optionList() {
        System.out.println("1. Write to a file: " );
        System.out.println("2. Read from file: " );
    }

    static int fileOutput(int option) {
        Scanner scan = new Scanner(System.in);
        String myfile;
        String edit;

        if (option == 1) {
            System.out.println("Which file would you like to write to: ");
            myfile = scan.nextLine();

            try (FileWriter fw = new FileWriter(myfile)) {
                System.out.println("What do you want to write: ");
                edit = scan.nextLine();
                fw.write(edit);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (option == 2) {
            System.out.print("Enter File Name: ");
            myfile = scan.nextLine();
            
            try (FileReader fr = new FileReader(myfile)) {
                int i;
                while ((i = fr.read()) != -1) {
                    System.out.print((char) i);
                }
                System.out.println(" ");
            } catch (FileNotFoundException ex) {
            System.out.println("File is not found");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Wrong input");
        }
            
        scan.close();
        return option;
    }
}