package com.revature;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.util.*;

/**
 * JournalApp is a simple app that allows user 
 * to create a journal entry and save it to a 
 * .txt file in the 'junk' dir.  At bare min, it
 * will ask user to provide the current day and a log
 * entry.  
 * 
 * The app is currently design to only add 
 * one entry at a time.  It uses the Scanner
 * and the Collection API in the java.util.*;
 * package and a host of IO API in the java.io.*;
 * package.
 * 
 * @author Leonardo De Leon
 */
public class JournalApp {

	public static void main(String[] args) {
		// create a scanner obj to get input from the user from the console
		Scanner sc = new Scanner(System.in);

		String fileName;
		String userEntry;
		boolean hasChosenOneFromTheList = false;
		boolean isDeciding = true;

		System.out.println();
		System.out.println("Hi, choose a journal or make one up!");

		File [] matchingFiles = findAllJunkFile();

		System.out.println();
		System.out.println("Your choice of files are: ");
		System.out.println();

		// list all the text file already exist for the user
		for (int i = 0; i < matchingFiles.length; i++) {
			System.out.println("  "+(i+1)+". "+matchingFiles[i].toString().substring(5));
		}

		System.out.println();

		// prompt user to choose one or create another text file
		System.out.print("Choose a journal or create a new one (as in nameOfFile): ");

		// retrieve the user input from console the 
		fileName = sc.nextLine();
		System.out.println();

		// see if user choose one from the list
		for (int i = 0; i < matchingFiles.length; i++) {
			// if user choose a file 			
			if (matchingFiles[i].toString().contains(fileName)) {
				hasChosenOneFromTheList = true;
			}
		}
		System.out.println();
		if (hasChosenOneFromTheList) {
			try {
				// open the journal and read the contents
				ArrayList<String> existingLog = openAndReadFilesContent(fileName);	

				// show the contents of the journal
				for (Iterator<String> it = existingLog.iterator(); it.hasNext();){
					System.out.println(" "+ it.next());
				}		

				System.out.println();

				// prompt user on what to do next
				System.out.println("Would you like to put an entry? (Press 1 for Yes, 2 for No): ");
				
				userEntry = sc.nextLine();
 
				while (isDeciding) {
					if (userEntry.equals("1")) { 
						
						// add .txt postfix in case user didn't
						if (!fileName.contains(".txt")) {
							fileName += ".txt";
						}
						// Open with FileWriter(fileName) constructor and
						// create a new file in the 'junk' dir, then,
						// populate the new file with the existing log;
						// another option is to use FileWriter(fileName,true) -
						// in this case there is no need to re-populate the 
						// file since write will only append a new entry not
						// wiping the log, resulting in less code
						try(FileWriter fw = new FileWriter("junk/"+fileName)) {
							for (Iterator<String> it = existingLog.iterator(); it.hasNext();){
								fw.write(it.next()+"\n");
							}
							openAndWriteToFile(fw, sc);
							isDeciding = false; // user finish new entry
							System.out.println();
						} catch (IOException ex) {
							ex.printStackTrace();
						}	
						
					} else if(userEntry.equals("2")) {
						isDeciding = false; //here user decide to quit the app
						System.out.println("Great! See ya next time, bye!");
					} else {
						System.out.println("Please enter 1 or 2: ");
						userEntry = sc.nextLine();
					}
				}
				System.out.println();

			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else { // user is creating a new journal

			// add .txt postfix in case user didn't
			if (!fileName.contains(".txt")) {
				fileName += ".txt";
			}

			// create the new file in the 'junk' dir
			try(FileWriter fw = new FileWriter("junk/"+fileName)) {
				openAndWriteToFile(fw, sc);
			} catch (IOException ex) {
			    ex.printStackTrace();
			}			
		}

		sc.close();
	}

	static File [] findAllJunkFile() {
		// create a file obj, f, and give it a path to the dir, 'junk'
		File f = new File("junk");

		// find and collect all files in 'junk' dir that ends in 'txt' or not
		File[] matchingFiles = f.listFiles(new java.io.FilenameFilter(){
			public boolean accept(File dir, String name) {
				//return name.endsWith("txt");
				return true; // or just return all files it sees
			}
		});
		return matchingFiles;
	}

	static ArrayList<String> openAndReadFilesContent (String fileName) throws IOException {
		ArrayList <String> contents = new ArrayList<>();
		String line;
		BufferedReader br = new BufferedReader(new FileReader("junk/"+(fileName+=".txt")));
		while ((line = br.readLine()) != null) {;
			contents.add(line);
		}
		br.close();		
		return contents;
	}

	static boolean isDayCorrectlyEntered (String u, boolean b, FileWriter f, Scanner s) throws IOException {
		
		if (u.equals("Monday")  
				|| u.equals("Tuesday")
				|| u.equals("Wednesday")
				|| u.equals("Thursday")
				|| u.equals("Friday")
				|| u.equals("Saturday")
				|| u.equals("Sunday")) {
			f.write(u+"\n");
			System.out.println("Please enter your log entry: ");
			u = s.nextLine();
			f.write(u+"\n");
			b = false; // user finally spell days correctly
			
			System.out.println("Nice, your entry was successful, Bye!");
		} else {
			System.out.println("Please enter the current day: ");
			u = s.nextLine();		
		}

		return b;
	}							

	static void openAndWriteToFile(FileWriter f, Scanner s) throws IOException {	
		
		System.out.println();
		System.out.println("Add the current day (ie, Monday) to your journal entry: ");
		System.out.println();

		// user entry from console the 
		String userInput = s.nextLine();
		boolean stillValidatingDay = true;
		while (stillValidatingDay){
			stillValidatingDay = isDayCorrectlyEntered(userInput,stillValidatingDay,f,s);
		}
	}


}