package com.revature.journal;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
* FileIO and ArrayList demo
* JournalApp
* Creates and/or opens a text file and saves user input
* @authore Zach Leonard
*/
class JournalApp {	
	public static void main (String[] args) {
		ClearTerminal();
		ArrayList<String> appendices = new ArrayList<>(); //Am I polluting the string pool?
		String fileName;
		String userAppendInput = " ";
		int menuSelection = Menu();
		switch (menuSelection) {
			case 1:
				do {
					fileName = GetFileNameFromInput();
				} while (!IsValidFileName(fileName));
				try {
        				FileWriter fw = new FileWriter(fileName, true);
					System.out.println("Program will append to file line by line. To exit appending, type the sentinel: !~");
					while (!userAppendInput.equals("!~")) {
						userAppendInput = GetInput();
						appendices.add(userAppendInput);				
					}
					//Commit appendices to file
					AppendToFile(fw, appendices);
					fw.close(); 	
        			} catch (IOException ex) {
        				ex.printStackTrace();
					System.out.println("Not able to create/open the specified file!");
        			}	
				break;
			case 2:
		
				break;
			case 3: 
				break;
		}		
	}
	static String GetFileNameFromInput() {
		String fileName;		
		Scanner sc = new Scanner(System.in);
        	System.out.println("What is your journal file name to create and/or open? (No spaces)");
        	fileName = sc.nextLine();
		ClearTerminal();
        	return fileName;
	}
	static boolean IsValidFileName (String fileName) {

		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(fileName);
		return (!matcher.find());

	}
	static void AppendToFile(FileWriter fw, ArrayList<String> appendices) {
		try {
			for (int i = 0; i < appendices.size(); i++) {		      
           			if (!appendices.get(i).equals("!~")) {
					fw.append(appendices.get(i) + "\n");        	
				}	
      			}
		} catch (IOException ex) {
            		ex.printStackTrace();
        	}
		ClearTerminal();
	}
	static String GetInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public static void ClearTerminal() {  
    		System.out.print("\033[H\033[2J");  
    		System.out.flush();  
	}
	//A rather unfortunate text menu
	public static int Menu() {
		int selection = 0;
		while (!((selection == 1) || (selection == 2) || (selection == 3))) {
			ClearTerminal();
			System.out.println("1. Write in journal");
			System.out.println("2. Read journal");
			System.out.println("3. Exit");
			System.out.print("Enter menu selection: ");
			try {
				selection = Integer.parseInt(GetInput());
			} catch (Exception ex) {
				selection = 0;
			}
		}
		ClearTerminal();
		return selection;
	}  	
}