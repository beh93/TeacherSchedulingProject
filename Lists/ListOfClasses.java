package Lists;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import University.Class;

/***
 * @author Bianca Jones
 */

public class ListOfClasses {
	Class[] classes = new Class[6];
	
	public ListOfClasses() {
		populate();
	}
	
	/**This method reads data from our input file, parses it via a Scanner and instantiates a Class object with the relevant data. This Class object is then
	 * added to the classes array
	 */
	public void populate() {		
		int nClasses = 0;
		FileReader reader = null;
		
		try {			
			// initialising a new FileReader
			reader = new FileReader("data.csv");
			
			Scanner s = new Scanner(reader);
			
			while(s.hasNextLine()) {				
				String line = s.nextLine(); // storing input as a String from the file while there is still data to be reaad	
				String[] tokens = line.split(",");// splitting the data at ','
				
				String subject = tokens[1]; // isolating the subject name from the String
				
				classes[nClasses++] = new Class(subject); // instantiating a new class using the subject name and adding it to the classes array
				}
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		finally {
			if(reader!=null) { 
				try {
					reader.close(); //closing the file
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/** This method prints out the names of all classes that exist in the data file, emulating a database.  For testing purposes only, so you know which classes are valid*/
	public void showClasses() {
		for (int i = 0; i < classes.length; i++) {
			System.out.println(classes[i].getName());
		}
	}
	
	/** This method validates that the class entered exists in the classes array and then adds a new Requirement object to the class that is found*/
	public void addRequirement() {
		Print print = new Print();
		
		int index = print.getSubject(this); // validating that the class the user input exists in the classes array
		
		
		try {
			classes[index].addRequirements(); // calls the addRequirements method from the relevant Class object and adds a requirement to the class
		}			catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("This course does not exist."); // returns this error message if the input class is not found in the classes array
		}
	}
	
	public void searchRequirement() {
		Print print = new Print();
						
		int index = print.getSubject(this);// validating that the class the user input exists in the classes array
		
		try {
			classes[index].showRequirements(); // if a valid class exists, it will show the Requirements for that particular class
		}
		catch(NullPointerException e) {
			System.err.println("There are no details for this class. \n"); // if no valid class exists, this error message is returned
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("This class does not exist.\n"); // returning this error if the input class does not exist in the classes array
		}
	}
	
	/**A simple printing method*/
	public String toString() {
		String input = "";
		for(int i = 0; i < classes.length; i++) {
			input += classes[i].getName() + "\n";
		}
		
		return input;
	}

	//Getters and setters
	public Class[] getClasses() {
		return classes;
	}
}
