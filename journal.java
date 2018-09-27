import java.util.*;
import java.io.*;

class JournalApp {

	public static void main(String[] args) {

		System.out.println("Enter a file path\n");
		Scanner in = new Scanner(System.in);
		String userIn = "";
		try{userIn = in.nextLine();}
		catch(InputMismatchException err) {
			System.out.println("Some Error\n");
		}
		FileWriter fileWriter = null;
			
		System.out.println("1 - Write to file\n2 - Read from file\n");
		int userSel = 0;
		try{userSel = in.nextInt();}
		catch(InputMismatchException err) {
			System.out.println("Must be an int\n");
		}
		if(userSel == 1) {
			try {
				String stuff = "";
				fileWriter = new FileWriter(userIn, true);
				System.out.println("Enter stuff");
				
				Scanner in2 = new Scanner(System.in);
				try{stuff = in2.nextLine();}
				catch(InputMismatchException err) {
					System.out.println("Some Error\n");
				}
				fileWriter.write(stuff);
			}
			catch (Exception err) {
				err.printStackTrace();
			}
			finally {
				try { 
					if(fileWriter != null) {
						fileWriter.flush();
						fileWriter.close();
					}
				}
				catch(IOException ex) {
					System.out.println("Error reading file " + userIn);                  
				}
			}
		}

		if(userSel == 2) {
			try {
				String ln = null;
				FileReader fileReader = new FileReader(userIn);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while((ln = bufferedReader.readLine()) != null) {
					System.out.println(ln);
				}
				bufferedReader.close();
			}
			catch(FileNotFoundException ex) {
				System.out.println("Unable to open file " + userIn);                
			}

			catch(IOException ex) {
				System.out.println("Error reading file " + userIn);                  
			}
		}
	}
}
