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

public class JournalApp {

	public static void main(String[] args) {
		// create a scanner obj to get input from the user from the console
		Scanner sc = new Scanner(System.in);

		String fileName;
		String userEntry;
		boolean hasChosenOneFromTheList = false;
		boolean isDeciding = true;

		System.out.println();
		System.out.println("Hi, Let's start by choosing a file or make one up!");

		// create a file obj, f, and give it a path to the dir, 'junk'
		File f = new File("junk");

		// find and collect all files in 'junk' dir that ends in 'txt'
		File[] matchingFiles = f.listFiles(new java.io.FilenameFilter(){
			public boolean accept(File dir, String name) {
				//return name.endsWith("txt");
				return true;
			}
		});

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

		if (hasChosenOneFromTheList) {
			try {
				System.out.println();
				fileName += ".txt";
				BufferedReader r = new BufferedReader(new FileReader("junk/"+fileName));
				String line;
				StringBuilder sb = new StringBuilder();
				ArrayList <String> existingLog = new ArrayList<>();
				while ((line = r.readLine()) != null) {
					//System.out.println("line: "+line);
					sb.append(line + "\n");
					existingLog.add(line);
				}
				r.close();
			
				System.out.println(sb.toString());
				//System.out.println("ArrayList: "+existingLog);

				System.out.println();
				System.out.println("Would you like to put an entry? (Press 1 for Yes, 2 for No): ");
				
				userEntry = sc.nextLine();
 
				while (isDeciding) {
					if (userEntry.equals("1")) {
						// Re-open the journal with FileWriter to write

						// add .txt postfix in case user didn't
						if (!fileName.contains(".txt")) {
							fileName += ".txt";
						}

						// create the new file in the 'junk' dir
						try(FileWriter fw = new FileWriter("junk/"+fileName)) {
							for (Iterator<String> it = existingLog.iterator(); it.hasNext();){
								fw.write(it.next()+"\n");
								//System.out.println("List existing log: "+ it.next());
							}							
							
							System.out.println();
							System.out.println("Add the current day (ie, Monday) to your new journal entry: ");
							System.out.println();

							// user entry from console the 
							userEntry = sc.nextLine();
							
							if (userEntry.equals("Monday")  
									|| userEntry.equals("Tuesday")
									|| userEntry.equals("Wednesday")
									|| userEntry.equals("Thursday")
									|| userEntry.equals("Friday")
									|| userEntry.equals("Saturday")
									|| userEntry.equals("Sunday")) {
								fw.write(userEntry+"\n");
								System.out.println("Please enter your log entry: ");
								userEntry = sc.nextLine();
								fw.write(userEntry+"\n");
								System.out.println("Nice, your entry was successful, Bye!");
							} else {
								System.out.println("Please enter the current day: ");
								userEntry = sc.nextLine();		
							}
							
							System.out.println();
						} catch (IOException ex) {
							ex.printStackTrace();
						}	
						isDeciding = false;
					} else if(userEntry.equals("2")) {
						isDeciding = false;
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
		} else {

			// add .txt postfix in case user didn't
			if (!fileName.contains(".txt")) {
				fileName += ".txt";
			}

			// create the new file in the 'junk' dir
			try(FileWriter fw = new FileWriter("junk/"+fileName)) {
				System.out.println();
				System.out.println("Add an entry to your new journal: ");
				System.out.println();

				// retrieve the user entry from console the 
				userEntry = sc.nextLine();
				fw.write(userEntry);
				System.out.println();
				System.out.println("Congrats on your first journal entry, Bye!");
				System.out.println();
			} catch (IOException ex) {
			    ex.printStackTrace();
			}			
		}

		sc.close();
	}
}