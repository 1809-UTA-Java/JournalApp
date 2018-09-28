package com.revature;

import java.util.*;
import java.io.*;

/** 
 * 	This is a Journal app that reads a file name from the user, requests
 *  the user to enter a line of input to the file, and then reads the contents
 *  the file back to the user.
 * Author: Steven Sly
 */
public class JournalApp {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> journalEntries = new ArrayList<>();

		// get file name from user
		System.out.println("Enter a filename: ");
		String fileName = sc.nextLine();
		System.out.println("You entered file named: " + fileName);
		
		// try with resources - FileWriter object will be closed automatically
		try(FileWriter fw = new FileWriter(fileName)) {
			System.out.println("Enter a line of text to write to a file: ");
			String fileText = sc.nextLine();
			
			//add to journalEntries ArrayList
			journalEntries.add(fileText);

			//Write the fileText to the file
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
			System.out.println();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
		}

		//serialize the ArrayList object to a file
		String serializeFile = "serial";
		writeObject(serializeFile, journalEntries);

		//TODO: Learn to append instead of overwrite serial file object.

		readObject(serializeFile);

		sc.close();
	}

	//from Demo:  Create an ObjectOutputStream with the FileOutputStream for the 
	//selected file as a paramter and write call the writeObject method from the 
	//ObjectOutputStream object.
	static void writeObject(String filename, Object obj){
		try(ObjectOutputStream oos = 
		new ObjectOutputStream(
			new FileOutputStream(filename))) {
				oos.writeObject(obj);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}

	// from Demo: create and object input stream with File input stream
	// parameter to read the object from the file and print it to the 
	// console
	static void readObject(String filename){
		try (ObjectInputStream ois = 
			new ObjectInputStream(
				new FileInputStream(filename)
			)){
				Object obj = ois.readObject();
				System.out.println("This is the object:");
				System.out.println(obj);
				System.out.println();
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
	}
}