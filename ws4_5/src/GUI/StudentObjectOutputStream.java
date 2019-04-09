package jac444_ws4_5;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentObjectOutputStream {
	public static ObjectOutputStream output;// output data to file
	
	public static void main(String[] args){
		openFile();
		addStudents();
		closeFile();
	}
	// open file studnets.ser
	public static void openFile(){
		try{
			//truncate and overwrite an existing file, or create the file if it doesn't initially exist
			//Converts the given URI to a Path object
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("students.ser")));
		}catch(IOException err){
			System.err.println("Error openin file.");
			System.exit(1); //terminate the program
		}
	}
	// add student informations to file
	public static void addStudents(){
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%nEnter: ", 
				"Enter Student ID, First Name, Last Name, and Courses.",
				"End input Ctrl+Z for Windows, Ctrl+D for Mac.");
		
		while(input.hasNext()){ // loop through until EOF
			try{		
				Student student = new Student(); // call default constructor
			
				student.setStID(input.nextInt());
				student.setFirstName(input.next());
				student.setLastName(input.next());
				
				//extract courses
				String[] tokens = input.nextLine().split("\\s+");
				//set the courses
				for(int i = 0; i < tokens.length; i++){
					if(tokens[i].equals("")){ 
						continue;
					}else
						student.setCourses(tokens[i]);
				}
				output.writeObject(student); //serialize student object into file
			}catch (NoSuchElementException elementException){
				System.err.println("Invalid input. Please try again.");
				input.nextLine(); // discard input so user can try again
			}catch (IOException err){
				System.err.println("Error writing to file. Terminating.");
				break;
			} 
			System.out.print("Enter: ");
		}
		input.close(); //prevent memory leak
	}
	// close students.ser file
	public static void closeFile(){
		try{
			if(output != null)
				output.close();
		}catch(IOException err){
			System.err.println("Error open file.");
		}
	}
}
