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

public class JournalApp {

	public static void main(String[] args) {
		// create a scanner obj to get input from the user from the console
		Scanner sc = new Scanner(System.in);
		String fileName;
		String userEntry;
		boolean hasChosenOneFromTheList = false;

		System.out.println();
		System.out.println("Hi, Let's start by choosing a file or make one up!");

		// create a file obj, f, and give it a path to the dir, 'junk'
		File f = new File("junk");

		// find and collect all files in 'junk' dir that ends in 'txt'
		File[] matchingFiles = f.listFiles(new java.io.FilenameFilter(){
			public boolean accept(File dir, String name) {
				return name.endsWith("txt");
			}
		});

		System.out.println();
		System.out.println("Your choice of files are: ");
		System.out.println();

		// list all the text file already exist for the user
		for (int i = 0; i < matchingFiles.length; i++) {
			System.out.println("  "+(i+1)+". "+matchingFiles[i]);
		}

		System.out.println();

		// prompt user to choose one or create another text file
		System.out.print("Choose a txt file or create a new one (as in nameOfFile.txt): ");

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
				BufferedReader r = new BufferedReader(new FileReader("junk/"+fileName));
				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = r.readLine()) != null) {
					sb.append(line + "\n");
				}
				r.close();
				System.out.println(sb.toString());
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