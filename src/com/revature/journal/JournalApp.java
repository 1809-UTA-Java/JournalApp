package com.revature.journal;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
*
*/
class JournalApp {	
	public static void main (String[] args) {
		String fileName;
		String userAppendInput = " ";
		do {
			fileName = GetFileNameFromInput();
		} while (!IsValidFileName(fileName));
		try {
        		FileWriter fw = new FileWriter(fileName);
			System.out.println("Program will append to file line by line. To exit appending, type the sentinel: !~");
			while (!userAppendInput.equals("!~")) {
				userAppendInput = GetInputToAppendToFile();
				AppendToFile(fw, userAppendInput);
			}
			fw.close(); 
        		
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
		
		
	}
	static String GetFileNameFromInput() {
		String fileName;		
		Scanner sc = new Scanner(System.in);
        	System.out.println("What is your journal file name to create and/or open? (one word input only)");
        	fileName = sc.nextLine();
        	System.out.println(fileName);
		return fileName;
	}
	static boolean IsValidFileName (String fileName) {

		//implement
		return true;

	}
	static void AppendToFile(FileWriter fw, String stringToAppend) {
		try {
			if (!stringToAppend.equals("!~")) {
				fw.append(stringToAppend + "\n");        	
			}
		} catch (IOException ex) {
            		ex.printStackTrace();
        	}
	}
	static String GetInputToAppendToFile() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
}