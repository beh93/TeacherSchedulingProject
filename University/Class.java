package University;
/***
 * @author Bianca Jones
 */

public class Class {
	
	private String name;
	private Requirement requirements; // this object contains all the requirements necessary to teach the class and can be used to search for qualified teachers
	
	public Class(String n) {
		name = n;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public Requirement getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirement requirements) {
		this.requirements = requirements;
	}
	
	/**This method calls the requirements toString() method in order to print out the number of years of experience required to teach the class*/
	public void showRequirements() {
		System.out.println(this.getRequirements().toString());
	}

	/** This method instantiates the Requirement constructor, which takes user input and instantiates a new Requirement object.  This class object then sets
	 * the new Requirement object to be it's own Requirement variable
	 */
	public void addRequirements() {
		this.setRequirements(new Requirement()); 
	}
}
