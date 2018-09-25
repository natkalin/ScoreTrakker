import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ScoreTrakker {

	private ArrayList<Student> students = new ArrayList<>();
	private static final String TEXT_FILE_NAME = "scores.txt";
	
	private void loadDataFromFile(String fileName) throws FileNotFoundException{
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		String studentName = "";
		String studentScore = "";
		
		while (in.hasNextLine()) {
			studentName = in.nextLine();
			studentScore = in.nextLine();
			Student student = new Student(studentName, Integer.parseInt(studentScore));
			students.add(student);
		}
		
		in.close();
		
	}
	
	private void printInOrder() {
		
		Collections.sort(students);
		
		System.out.println("Student Score List: ");
		for(Student student : students) {
			System.out.println(student);
		}
	}
	
	private void processFiles() throws FileNotFoundException {
		loadDataFromFile(TEXT_FILE_NAME);
		printInOrder();
	}
	
	public static void main (String [] args) throws FileNotFoundException {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}
	
	
	
}
