package Lists;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import University.Teacher;
import University.Class;
import University.Requirement;
/***
 * @author Bianca Jones
 */

public class ListOfTeachers implements Populate {
	Teacher[] teachers = new Teacher[6];
	
	public ListOfTeachers() {
		populate();
	}
	
	/**This method reads data from our input file, parses it via a Scanner and instantiates a Teacher object with the relevant data. This Teacher object is then
	 * added to the teachers array
	 */
	public void populate() {
		int nTeachers = 0;
		FileReader reader = null;
		
		try {			
			// creating a FileReader and a Scanner to read our data tile
			reader = new FileReader("data.csv");
			Scanner s = new Scanner(reader);
			
			// continue reading the file while there are still lines to be read
			while(s.hasNextLine()) {
				
				String line = s.nextLine();	 // getting input from the scanner					
				String[] tokens = line.split(","); // splitting the lines using a comma
				
				String name = tokens[0]; // isolating the teacher's name	
				String subject = tokens[1]; //isolating the teacher's subject				
				int exp = Integer.parseInt(tokens[2]); // converting the teacher's years of experience into an int from a String
				
				// creating a new Teacher and adding it to the teachers array
				teachers[nTeachers++] = new Teacher(name, subject, exp);
				}
			}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			// closing the file
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**This method retrieves the requirements of a Class based on user input, then determines whether a teacher able to teach the relevant subject has the required level
	 * of experience.  If there is a suitable teacher, their name is printed.  If there are no suitable teachers or the class does not exist/have requirements, various
	 * error messages are displayed instead
	 */
	public void searchTeacher(ListOfClasses classes) {
		Print print = new Print();
		int index = print.getSubject(classes); // validating that the class actually exists
		int exp = 100; // setting the value high so teacher could reasonably have this number of years of experience; used as a control
		
		if(index != -1) {
			Class course = classes.getClasses()[index]; // isolating the valid class that was found
		
			// returning this error if a class exists, but there are no requirements for it
			try {
				exp = course.getRequirements().getYearsOfExperience(); // isolating the number of years of experience required to teach this class
			}
			catch(NullPointerException e) {
				System.err.println("There are no requirements for this class.");
			}
			
			// isolating the course name
			String sub = course.getName(); 
			
			// an int to validate whether a suitable Teacher exists or not
			int ind = -1; 
				
			for(int i = 0; i < teachers.length; i++) {
				// this checks whether a teacher qualified to teach the subject has the requisite experience
				if(teachers[i].getSubject().equalsIgnoreCase(sub) && teachers[i].getExperience() == exp || teachers[i].getSubject().equalsIgnoreCase(sub) && teachers[i].getExperience() > exp) {
					ind = i; // if a suitable teacher is found, ind is set to the index in the teachers array
				}
			}
		
			try {
				System.out.println(teachers[ind].toString()); // printing out the name of the teacher that was identified
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.err.println("There are no qualified teachers available."); // returning this error if no suitable teacher was found
				}
			}
			else {
				System.err.println("This class does not exist."); // returning this error if the class entered does not exist
			}
		}
		
	//a simple printing method
	public String toString() {
		String input = "";
		for(int i = 0; i < teachers.length; i++) {
			input += teachers[i].getName() + "\n";
		}
		
		return input;
	}
}
