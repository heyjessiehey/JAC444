package ws11;

import java.util.ArrayList;

public class Student implements java.io.Serializable {
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;
	
	//default constructor
	Student(){
		stdID = 0;
		firstName = "";
		lastName = "";
		courses = new ArrayList<String>();
	}
	
	// stdID getter and setter
	public int getStdID(){
		return stdID;
	}
	public void setStID(int stdID){
		this.stdID = stdID;
	}
	// firstName getter and setter
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	// lastName getter and setter
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	// lastName getter and setter
	public ArrayList<String> getCourses(){
		return courses; 
		//return new ArrayList<String>(courses); 
		//don't want to be modified my private courses field
	}
	public void setCourses(String  courses){
		this.courses.add(courses);
	}
}
