package src.com.revature;

import java.util.*;
import java.io.*;


/**
* The JournalApp takes in user input to create or read from a file.
* This means the user selects a file and if it exists, read it. If
* not, create a file and write to it a bunch of times.
*
*/
public class JournalApp {

    public static void main( String [] args ) {

        //Create a scanner object to ask the user for a filename.
        Scanner sc = new Scanner( System.in );
        System.out.println( "Please enter a filename:" );
        String filename = sc.nextLine();

        //First step: If the file exists, we will first attempt to read from the file.
        try( FileReader fr = new FileReader( filename ) ) {

            int i;
            while ( (i = fr.read()) != -1 ) {
                System.out.print( (char) i );
            }
            System.out.print( "\n" );
        } catch( FileNotFoundException ex ) { 

            //If the file is not found, write to a new file with what the user wants to.
            try ( FileWriter fw = new FileWriter( filename ) ) {

                System.out.println( "The file does not exist. What would you like to write to " + filename + "?");
                fw.write( sc.nextLine() + " " );


                //Ask the user if they want to add more to the file and make sure they provide the right answer.
                System.out.println("Would you like to write anything else? yes or no");
                String answer = sc.nextLine().toLowerCase();

                //If the answer is yes then write to file and ask if they want to keep writing
                if( answer.equals("yes") ) {

                    while( answer.equals("yes") ) {

                        System.out.println( "What would you like to write?" );
                        fw.append( sc.nextLine() + " ");

                        //Ask if they keep writing and make sure their answer is correct.
                        System.out.println("Would you like to write anything else? yes or no");
                        while ( true ) {
                            answer = sc.nextLine().toLowerCase();

                            if( answer.equals("yes") || answer.equals("no") ) {
                                break;
                            }
                            else {
                                System.out.println( "Wrong answer! Please write yes or no" );
                            }                            
                        }
                    }
                }
                //If the answer is no end the program
                else if (answer.equals("no")) {}
                //If they give an answer other than yes or no ask them again
                else {
                    while ( true ) {
                        
                            System.out.println( "Wrong answer! Please write yes or no" );
                            answer = sc.nextLine().toLowerCase();

                            if( answer.equals("yes") || answer.equals("no") ) {
                                break;
                            }
                            else {
                                System.out.println( "Wrong answer! Please write yes or no" );
                            }                            
                        }
                }

                fw.close();
            } catch( IOException e ) {
                e.printStackTrace();
            }
        } catch( IOException ex ) {
            ex.printStackTrace();
        }

    }   
}