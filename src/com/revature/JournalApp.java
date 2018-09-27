package com.revature;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/** 
 * 	This is a Journal app that reads a file name from the user, requests
 *  the user to enter a line of input to the file, and then reads the contents
 *  the file back to the user.
 * Author: Steven Sly
 */
public class JournalApp {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		// get file name from user
		System.out.println("Enter a filename: ");
		String fileName = sc.nextLine();
		System.out.println("You entered file named: " + fileName);
		
		// try with resources - FileWriter object will be closed automatically
		try(FileWriter fw = new FileWriter(fileName)) {
			System.out.println("Enter a line of text to write to a file: ");
			String fileText = sc.nextLine();
			fw.write(fileText);
        } catch (IOException ex) {
			ex.printStackTrace();
		} 

		//try to read the file that was just written
		try (FileReader fr = new FileReader(fileName)) {
			int i;
			System.out.println("This is the line that was written to the file: ");
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
			}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
		}

		sc.close();
	}
}