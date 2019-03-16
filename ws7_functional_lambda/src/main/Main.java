/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import shape.Circle;
import shape.CircleException;
import shape.Shape;
import shape.Parallelogram;
import shape.ParallelogramException;
import shape.Rectangle;
import shape.Triangle;
import shape.TriangleException;
import shape.Square;

/**
 * @author Gayeonko
 *
 */
public class Main {
	/**
	 * @param args
	 * @throws CircleException, ParallelogramException, TriangleException 
	 */
	public static void main(String[] args) {
		//Shape[] arrayOfShapes = new Shape[50]; // array to contain all the shapes
		List<Shape> shapeList = new LinkedList<>();
		int counter = 0;
		
		System.out.println("------->JAC 444 <--------");
		System.out.println("------->Task 4 ... <--------");
		
		//read a file
		try (BufferedReader br = new BufferedReader(new FileReader("Shapes.txt"))) { 
			String s;
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
					if(tokens[0].equals("Circle") && tokens.length == 2){  //compare contents and proper number of tokens
						try{
							double value = Double.parseDouble(tokens[1]); // convert string to double
							shapeList.add(new Circle(value)); // create Circle object
							counter++;
						}catch(CircleException e){
							System.out.println(e.getMessage());
						}
					}else if(tokens[0].equals("Triangle") && tokens.length == 4){
						try{
							double value1 = Double.parseDouble(tokens[1]);
							double value2 = Double.parseDouble(tokens[2]);
							double value3 = Double.parseDouble(tokens[3]);
							shapeList.add(new Triangle(value1, value2, value3)); //create Triangle object
							counter++;
						}catch(TriangleException e){
							System.out.println(e.getMessage());
						}
					}else if(tokens[0].equals("Parallelogram") && tokens.length == 3){
						try{
							double value1 = Double.parseDouble(tokens[1]);
							double value2 = Double.parseDouble(tokens[2]);
							shapeList.add(new Parallelogram(value1, value2)); // create Parallelogram object
							counter++;
						}catch(ParallelogramException e){
							System.out.println(e.getMessage());
						}
					}else if(tokens[0].equals("Rectangle") && tokens.length == 3){
						try{
							double value1 = Double.parseDouble(tokens[1]);
							double value2 = Double.parseDouble(tokens[2]);
							shapeList.add(new Rectangle(value1, value2)); // create Rectangle object
							counter++;
						}catch(ParallelogramException e){ // use superclass custom exception handler
							System.out.println(e.getMessage());
						}
					}else if(tokens[0].equals("Square") && tokens.length == 2){
						try{
							double value = Double.parseDouble(tokens[1]);
							shapeList.add(new Square(value)); // create Square object
							counter++;
						} catch(ParallelogramException e){ // use superclass custom exception handler
							System.out.println(e.getMessage());
						}
					}else{
						continue; //ignore and continue read a file
					}
			}
				
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { // must execute 
			System.out.println(); // print blank line 
			System.out.println(counter + " shapes were created:");
		
			for(Shape shape : shapeList){ // use for each loop print Shape array elements
				if(shape == null)
					break;
				System.out.println(shape);
			}
			
		}
	}
}
