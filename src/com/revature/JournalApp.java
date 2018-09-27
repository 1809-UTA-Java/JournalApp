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




		Scanner sc = new Scanner(System.in);

		System.out.println("How was your day today?");

		String entry = sc.nextLine();	
		System.out.println(entry);


		sc.close();



		try { FileWriter fw = new FileWriter(filename);
		fw.write(entry);
		fw.close();
		} catch(IOException io) {
			io.printStackTrace();
		}

		try { FileReader fr = new FileReader(filename);
			int i;
			while ((i = fr.read()) != -1) {
				System.out.println((char) i);
			}} catch(FileNotFoundException ff) {
				ff.printStackTrace();
			} catch(IOException io2) {
				io2.printStackTrace();
			} 

		
	}

}