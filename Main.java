import Lists.ListOfClasses;
import Lists.ListOfTeachers;

public class Main {

	public static void main(String[] args) {
		ListOfClasses classes = new ListOfClasses(); // instantiating and populating a new ListOfClasses() object;
		ListOfTeachers teachers = new ListOfTeachers(); // instantiating and populating a new ListOfTeachers() object;
		
		classes.addRequirement(); // demo of adding a requirement
		System.out.println();
		
		classes.searchRequirement(); // demo of searching for the requirements of a particular class
		
		teachers.searchTeacher(classes); // demo of searching for qualified teachers for a class using the class' Requirement object
	}
}
