/**
 * Lucas White
 */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class JournalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your journal's name?");
        String name = sc.nextLine();
        System.out.println("Do you want to add to the journal?");
        String inputPrompt = sc.nextLine();
        while (inputPrompt.equals("yes")){
            try {
                FileWriter fw = new FileWriter(name, true);
                System.out.println("What would you like to add?");
                String userInput = sc.nextLine();
                fw.write(userInput);
                fw.append(System. getProperty("line.separator"));
                fw.close(); 
            } catch (IOException ex) {
                 ex.printStackTrace();
         }
            System.out.println("Do you want to add more to the journal?");
            inputPrompt = sc.nextLine();
        }

        try (FileReader fr = new FileReader(name)) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sc.close();
        System.out.println("");
    }
}