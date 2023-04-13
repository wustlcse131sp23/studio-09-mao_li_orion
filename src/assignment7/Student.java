package assignment7;

public class Student {
	
	// instance variables
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double qualityPoints;
	private double bearBucks = 0;
	
	public Student(String initFirstName, String initLastName, int initId) {
		firstName = initFirstName;
		lastName = initLastName;
		id = initId;
	}
	
	/**
	 * Get student's full name.
	 * 
	 *  @return String 	student full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * Get student's ID number.
	 * 
	 * @return int 	student ID number
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get student's number of attempted credits.
	 * 
	 * @return int 	total attempts credits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	/**
	 * Get student's number of passing credits.
	 * 
	 * @return int total passing credits
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	/**
	 * Calculate student's grade point average.
	 * 
	 * @return double 	grade point average
	 */
	public double calculateGradePointAverage() {
		return qualityPoints/(double)attemptedCredits;
	}
	
	/**
	 * Update the student's grades using a course grade and number of credits.
	 *
	 * @param double 	the grade the student earned in a course
	 * @param int 	the number of credits in the course
	 */
	public void submitGrade(double grade, int credits) {
		
		attemptedCredits += credits;
		
		if (grade >= 1.7) {
			passingCredits += credits;
		}
		
		qualityPoints += credits*grade;
		
	}
	
	/**
	 * Calculate student's class standing.
	 * 
	 * @return String 	class standing
	 */
	public String getClassStanding() {
		
		if (passingCredits < 30) {
			return "First Year";
		} else if (passingCredits < 60){
			return "Sophomore";
		} else if (passingCredits < 90){
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	/**
	 * Determine whether student is eligible for Phi Beta Kappa.
	 * 
	 * @return boolean 	eligible/ineligible
	 */
	public boolean isEligibleForPhiBetaKappa() {
		
		if ((passingCredits >= 98) && (this.calculateGradePointAverage() >= 3.60)) {
			return true;
		} else if ((passingCredits >= 75) && (this.calculateGradePointAverage() >= 3.80)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Add funds to student Bear Bucks account.
	 * 
	 * @param double	amount in dollars to add
	 */
	public void depositBearBucks(double amount) {
		bearBucks += amount;
	}
	
	/**
	 * Deduct funds from student Bear Bucks account.
	 * 
	 * @param double	amount in dollars to deduct
	 */
	public void deductBearBucks(double amount) {
		bearBucks -= amount;
	}
	
	/**
	 * Get Bear Bucks balance.
	 * 
	 * @return double	Bear Bucks balance
	 */
	public double getBearBucksBalance() {
		return bearBucks;
	}
	
	/**
	 * Cash out Bear Bucks balance.
	 * 
	 * @return double	amount cashed out
	 */
	public double cashOutBearBucks() {
		
		double tempBucks = bearBucks;
		bearBucks = 0;
		
		if (tempBucks > 10) {
			return tempBucks - 10;
		} else {
			return 0.0;
		}
	}
	
	/**
	 * Create a new Student based on two existing parent students and add parents' Bear Bucks' balance to the student's account.
	 *
	 * @param String 	first name of child student
	 * @param Student 	second parent of child student 
	 * @param boolean	whether the child's surname is hyphenated
	 * @param int		student ID of child student
	 * @return Student 	the child student
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		
		String kidLastName;
		
		if (isHyphenated) {
			kidLastName = this.lastName + "-" + otherParent.lastName;
		} else {
			kidLastName = this.lastName;
		}
		
		Student kiddo = new Student(firstName, kidLastName, id);
		
		kiddo.depositBearBucks(this.cashOutBearBucks() + otherParent.cashOutBearBucks());
		
		return kiddo;
	}
	
	/**
	 * Return the first name, last name, and ID of student as a string.
	 * 
	 * @return String 	first name, last name, and ID of student
	 */
	public String toString() {
		return firstName + " " + lastName + " " + id;
	}
	
	/**
	 * Update the student's first name.
	 * 
	 * @param String	new first name
	 */
	public void changeFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	/**
	 * Update the student's last name.
	 * 
	 * @param String	new last name
	 */
	public void changeLastName(String newLastName) {
		firstName = newLastName;
	}
	
}
