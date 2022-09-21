package University;

/***
 * @author Bianca Jones
 */
public class Teacher {
	
	private String name;
	private String subject;
	private int experience;
	
	public Teacher(String n, String s, int exp) {
		name = n;
		subject = s;
		experience = exp;
	}
	
	/** a simple printing method*/ 
	public String toString() {
		return "" + name;
	}
	
	// Required Getters
	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public int getExperience() {
		return experience;
	}
}
