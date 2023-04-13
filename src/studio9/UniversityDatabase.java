package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {

	private Map<String, Student> students;
	
/**
	 * @param students
	 */
	public UniversityDatabase() {
		students = new HashMap<String, Student>();
	}
	
	public void addStudent(String accountName, Student student) {
		students.put(accountName, student);
	}

	public int getStudentCount() {
		return students.size();
	}

	public String lookupFullName(String accountName) {
		if (students.get(accountName) != null) {
			return students.get(accountName).getFullName();
		} else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		
		double count = 0;
		
		for (Student student : students.values()) {
			count += student.getBearBucksBalance();
		}
		
		return count;

	}
}
