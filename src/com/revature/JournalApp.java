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
			writeReadFile(filename,anEntry);
			System.out.println("Entry has been saved to " + filename + ". Thank you.");
		}
		if (saveAns.equals("n") || saveAns.equals("N")) {
			System.out.println("Fine. Entry will be discarded. Goodbye.");
		}
		else {
			System.out.println("I do not understand. Goodbye.");
		}
		scan.close();
		

		



		// Scanner sc = new Scanner(System.in);

		// System.out.println("How was your day today?");

		// String entry = sc.nextLine();	
		// System.out.println(entry);


		// sc.close();



		// try { FileWriter fw = new FileWriter(filename);
		// fw.write(entry);
		// fw.close();
		// } catch(IOException io) {
		// 	io.printStackTrace();
		// }

		// try { FileReader fr = new FileReader(filename);
		// 	int i;
		// 	while ((i = fr.read()) != -1) {
		// 		System.out.println((char) i);
		// 	}} catch(FileNotFoundException ff) {
		// 		ff.printStackTrace();
		// 	} catch(IOException io2) {
		// 		io2.printStackTrace();
		// 	} 

		
	}

	public static String makeAnEntry(Scanner sc) {
		//Scanner sc = new Scanner(System.in);

		System.out.println("How was your day today?");

		String entry = sc.nextLine();	
		System.out.println(entry);


		//sc.close();
		return entry;
	}

	public static void writeReadFile(String myFile, String myEntry) {
		try { FileWriter fw = new FileWriter(myFile);
			fw.write(myEntry);
			fw.close();
			} catch(IOException io) {
				io.printStackTrace();
			}
	
			try { FileReader fr = new FileReader(myFile);
				int i;
				while ((i = fr.read()) != -1) {
					System.out.println((char) i);
				}
				fr.close(); } catch(FileNotFoundException ff) {
					ff.printStackTrace();
				} catch(IOException io2) {
					io2.printStackTrace();
				} 
	}

}