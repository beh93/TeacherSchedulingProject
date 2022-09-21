package University;
import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * @author Megan Rooney
 */
public class Requirement {
	private int yearsOfExperience;
	
	/**The constructor prompts the user for input and then sets the yearsOfExperience variable to be the number that was input.  Please only input a number 
	 * when instantiating a Requirement object, error-checking for valid input has not been done.
	 */
	public Requirement() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the number of years of experience required to teach this class: " );
		
		try {
			yearsOfExperience = s.nextInt();
		}
		catch(InputMismatchException e) {
			System.err.println("Invalid input"); // returning this error if the user does not input a number
		}
		
		
	}

	//Getters and Setters
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	//A simple print method
	public String toString() {
		return "This class requires " + yearsOfExperience + "  years of experience to teach. \n";
	}
}
