package com.revature.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.*;

public  class SerializableJournalApp {

    public static void main (String [] args) {

        File [] existingFiles = findAllFilesIn("junk");

        boolean serFileExist = false;
        String nameOfSerFile = "";
        Hashtable<String,String> journalContents;

		// see if serialized file "ser" exist in junk dir
		for (int i = 0; i < existingFiles.length; i++) {
			// if user choose a file 			
			if (existingFiles[i].toString().contains("ser")) {
				serFileExist = true;
                nameOfSerFile = existingFiles[i].toString(); 
			}
		}

        // if ser file exist, then load it up
        if (serFileExist) { 
            journalContents = openAndReadSerJournalApp(nameOfSerFile);
        } else { // else create a new ser-journal file, add contents and serialized it
            String fileName = "ser-journal-app";
            Journal journal = new Journal("Monday","Quiz, Mock interview, QC, and intro DB");
            writeObject("junk/"+fileName,journal); // serialized it
            journalContents = openAndReadSerJournalApp("junk/"+fileName); //de-serialzed it
        }

        // first display the contents of the ser file then ask the user what to do
        displayJournalContents(journalContents);

        // start dialog using Scanner obj, sc
        Scanner sc = new Scanner(System.in);

        // prompt user to add entry or quit
        System.out.println("Hi, enter 1 to add an entry, 2 to exit: ");
        String userEntry = sc.nextLine();
         
        boolean dialogIsUp = true;
        while (dialogIsUp) {
            // user choose to add an entry
            if (userEntry.equals("1")) {
                System.out.println("Add a current day (ie, Monday) to your entry: ");
                String day = sc.nextLine();

                boolean validatingDay = true;
                while (validatingDay) {
                    if (day.equals("Monday")  
                        || day.equals("Tuesday")
                        || day.equals("Wednesday")
                        || day.equals("Thursday")
                        || day.equals("Friday")
                        || day.equals("Saturday")
                        || day.equals("Sunday")) {

                        System.out.println("Please enter your log entry: ");			
                        userEntry = sc.nextLine();

                        // put the contents in journalContents
                        journalContents.put(day,userEntry);

                        validatingDay = false; // user finally spell days correctly			
                    } else {
                        System.out.println("Please enter the current day: ");
                        day = sc.nextLine();		
                    }
                }

                // instanstiate Journal obj
                Journal journal = new Journal();

                // enumerate the key and value so it can be populated into journal obj
                Enumeration nameOfTheDays = journalContents.keys();
                Enumeration theEntries = journalContents.elements();
        
                // populate journal obj with the journal contents
                for (;nameOfTheDays.hasMoreElements();) {
                    //System.out.println(nameOfTheDays.nextElement());
                    //System.out.println(theEntries.nextElement());
                    journal.addContents(nameOfTheDays.nextElement().toString(),theEntries.nextElement().toString());
                } 

                // serialized the updated journal obj
                writeObject(nameOfSerFile,journal); 
    
                System.out.println("Nice, your entry was successful, bye!");
                dialogIsUp = false; // user is finish adding an entry

            } else if (userEntry.equals("2")) {
                System.out.println("Great, See ya next time, bye!");
                dialogIsUp = false; // user decide to exit the app
            } else {
                System.out.println("Please enter 1 or 2: ");
                userEntry = sc.nextLine();
            }
        }

        sc.close();
    }

    static void writeObject(String filename, Object obj) {
        try(ObjectOutputStream oos = 
            new ObjectOutputStream(
                new FileOutputStream(filename))) {
                    oos.writeObject(obj);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }

    static void readObject (String filename) {
        try (ObjectInputStream ois =
            new ObjectInputStream(
                new FileInputStream(filename)
            )) {
                Journal journal = (Journal) ois.readObject();
                System.out.println(journal);
                System.out.println("SerJourAppContents: \n"+journal.getContents());
         
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
    }   

    static Hashtable<String,String> openAndReadSerJournalApp(String fileName) {
        Hashtable<String, String> contents = null;  
        try (ObjectInputStream ois =
            new ObjectInputStream(
                new FileInputStream(fileName)
            )) {
                Journal journal = (Journal) ois.readObject();
                contents = journal.getContents();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        return contents;
    }

	static File [] findAllFilesIn(String path) {
		// create a file obj, f, and give it a path to the dir, 'junk'
		File f = new File(path);

		// find and collect all files in 'junk' dir that ends in 'txt' or not
		File[] matchingFiles = f.listFiles(new java.io.FilenameFilter(){
			public boolean accept(File dir, String name) {
				//return name.endsWith("txt");
				return true; // or just return all files it sees
			}
		});
		return matchingFiles;
	}  

    static void displayJournalContents (Hashtable<String,String> ht) {
        Enumeration<String> nameOfTheDays = ht.keys();
        Enumeration<String> theEntries = ht.elements();

        for (;nameOfTheDays.hasMoreElements();) {
            System.out.println(nameOfTheDays.nextElement());
            System.out.println("   "+theEntries.nextElement());
        } 
    }          
}