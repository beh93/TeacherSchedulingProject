package Lists;
import java.util.Scanner;

import University.Class;
/***
 * @author Bianca Jones
 */

public class Print {
	
	public Print() {
		
	}
	
	/** This method takes in a ListOfClasses object and prompts the user to input a course name.  If the course name matches the name of one of the classes
	 * that exists in the ListOfClasses object, it will return the index at which that class exists.  If the class does not exist, it will return -1
	 */
	public int getSubject(ListOfClasses classes) {
		Class[] courses = classes.getClasses();
		
		System.out.println("Please enter the name of the class you're looking for : ");
		
		String subject = new Scanner(System.in).nextLine();
		int index = -1; // setting a default value for i
		
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].getName().equalsIgnoreCase(subject)) {
				index = i; // setting index to i if a class matching the user input exists
			}
		}
		return index;
	}
}