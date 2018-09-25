/**
 * @author Natalie Kalin
 * @author Cale Waress
 * 
 * Reads in files of Student data
 * and sorts based on score
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ScoreTrakker {

	private ArrayList<Student> students;
	private static final String[] FILES = {"scores.txt", "badscore.txt", "nofile.txt"};

	/**
	 * Reads in data and stores in student arraylist
	 * @param fileName - name of file
	 * @throws FileNotFoundException - if file is not found
	 */
	private void loadDataFromFile(String fileName) throws FileNotFoundException{
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		students = new ArrayList<>();
		String studentName = "";
		String studentScore = "";
		
		while (in.hasNextLine()) {
			
			studentName = in.nextLine();
			studentScore = in.nextLine();
			
			try {
				Student student = new Student(studentName, Integer.parseInt(studentScore));	
				students.add(student);	
			} catch(NumberFormatException e){
				System.out.println("Incorrect format for " + studentName + " not a valid score: "
									+ studentScore);
				System.out.println("");
			}
					
		}
		
		in.close();
		
	}
	
	/**
	 * Prints students in order of score to console
	 */
	private void printInOrder() {
		
		Collections.sort(students);
		
		System.out.println("Student Score List: ");
		for(Student student : students) {
			System.out.println(student);
		}
	}
	
	/**
	 * Calls loadDataFromFile and printInOrder for all files
	 */
	private void processFiles() {
		
		for(String file : FILES)
		{
			try {
			loadDataFromFile(file);
			printInOrder();
			System.out.println("");
			} catch(FileNotFoundException e) {
				System.out.println("Can't open file " + file);
			}
		}

	}
	
	public static void main (String [] args){
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}
	
	
	
}
