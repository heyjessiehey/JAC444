/**
 * 
 */
package shape;

/**
 * @author Gayeonko
 *
 */
public class Square extends Rectangle{ // subclass 
	public Square(double side) throws ParallelogramException{
		super(side, side); // call super class constructor
	}
	
	@Override
	public String toString(){ // return string
		return "Square {s=" + super.getHeight() + "}" +
				" perimeter = " + perimeter() + " area = " + getArea().calArea(getWidth(), getHeight()); // defined calArea method by lambda
	}
}
