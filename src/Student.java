
public class Student implements Comparable<Student>{

	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

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


	@Override
	public String toString() {
		return name + " " + score;
	}

	

}

