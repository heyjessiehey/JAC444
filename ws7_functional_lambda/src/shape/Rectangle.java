/**
 * 
 */
package shape;

/**
 * @author Gayeonko
 *
 */
public class Rectangle extends Parallelogram { //subclass
	public Rectangle(double width, double height) throws ParallelogramException{
			super(width, height); //call superclass's constructor
	}
	
	@Override
	public String toString(){ //return string 
		return "Rectangle {w=" + getWidth() + ", h=" + getHeight() + "}" +
				" perimeter = " + perimeter() + " area = " + getarea().getArea(getWidth(), getHeight());
	}
}
