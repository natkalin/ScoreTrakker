/**
 * @author Natalie Kalin
 * @author Cale Waress
 * 
 * Class for student that contains name and score
 */
public class Student implements Comparable<Student>{

	private String name;
	private int score;
	
	/**
	 * 
	 * @param name of student
	 * @param score of student
	 */
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	/**
	 * Sorts based on student score
	 */
	@Override
	public int compareTo(Student other) {
		if (this.score < other.score) {
			return -1;
		}
		if (this.score == other.score) {
			return 0;
		}
		return 1;
	}

	/**
	 * Prints name and score of student
	 */
	@Override
	public String toString() {
		return name + " " + score;
	}

	

}

