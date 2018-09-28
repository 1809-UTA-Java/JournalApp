package com.revature;

import java.util.Scanner;
import java.io.InputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
*
*
* @author su ean lim
*/

public class JournalApp {

	public static void main(String[] args) {
		String filename = "journal entry";

		Scanner scan = new Scanner(System.in);

		
		String anEntry = makeAnEntry(scan);
		

		
		System.out.println("Do you want to save this entry? Type y/n.");
		String saveAns = scan.next();

		if (saveAns.equals("y") || saveAns.equals("Y")) {
			writeFile(filename, anEntry);
			System.out.println("Entry has been saved to <" + filename + ">. Thank you.");
			//scan.close();
			optionReadFile(filename, scan);
		}
		else if (saveAns.equals("n") || saveAns.equals("N")) {
			System.out.println("Fine. Entry will be discarded.");
			scan.close();
		}
		else {
			System.out.println("I do not understand. Goodbye.");
			scan.close();
		}
		
	}

	public static void optionReadFile(String filename, Scanner readScan) {
		//Scanner readScan = new Scanner(System.in);
		System.out.println("Do you want to read your entry? y/n.");
		String readAns = readScan.next();

		if (readAns.equals("y") || readAns.equals("Y")) {
			//System.out.println("Okay One second.");
			System.out.println(readFile(filename));
		}
		else if (readAns.equals("n") || readAns.equals("N")) {
			System.out.println("Fine. Goodbye.");
		}
		else {
			System.out.println("I do not understand. Goodbye.");
		}
		readScan.close();

	}

	public static String makeAnEntry(Scanner sc) {
		//Scanner sc = new Scanner(System.in);

		System.out.println("How was your day today?");

		String entry = sc.nextLine();	
		System.out.println(entry);


		return entry;
	}

	public static void writeFile(String myFile, String myEntry) {
		try { FileWriter fw = new FileWriter(myFile);
			fw.write(myEntry);
			fw.close();
			} catch(IOException io) {
				io.printStackTrace();
			}
	}

	public static String readFile(String myFile) {

		StringBuilder stringEntry = new StringBuilder(); 		

		try { FileReader fr = new FileReader(myFile);
			int i;
			while ((i = fr.read()) != -1) {
				//System.out.println((char) i);
				stringEntry.append((char)i); 
			}
			fr.close(); } catch(FileNotFoundException ff) {
				ff.printStackTrace();
			} catch(IOException io2) {
				io2.printStackTrace();
			} 
		return stringEntry.toString();
	}

}