package jac444_ws4_5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentObjectInputStream {
	public static ObjectInputStream input; // input data from file
	
	public static void main(String[] args){
		openFile();
		readStudents();
		closeFile();
	}
	// open the file
	public static void openFile(){
		try{ 
			//Opens a file, returning an input stream to read from the file.
			//Converts the given URI to a Path object.
			input = new ObjectInputStream(Files.newInputStream(Paths.get("students.ser")));
		}catch (IOException err){
			System.err.println("Error opening file.");
			System.exit(1);}
	}
	
	public static void readStudents(){
		System.out.printf("%-12s%-12s%-12s%-25s%n",
				"Student ID", "First Name", "Last Name", "Courses");
		try{
			while(true){ // loop until EOFException
				//Student student = (Student) input.readObject(); //deserialization of object
				Student student = readObject();
				//display student object
				System.out.printf("%-12d%-12s%-12s",
						student.getStdID(), student.getFirstName(), student.getLastName());
				System.out.println(student.getCourses());
			}
		}catch (EOFException endOfFileException) {
			System.out.printf("No more records%n");
		}catch (ClassNotFoundException classNotFoundException){
			System.err.println("Invalid object type. Terminating.");
		}catch (IOException err){
			System.err.println("e");
		}
	}
	
	public static Student readObject() throws ClassNotFoundException, IOException{
		return (Student) input.readObject(); //deserialization of object
	}
	
	public static void closeFile(){
		try{
			if (input != null)
				input.close();
		}catch (IOException err){
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}
}
