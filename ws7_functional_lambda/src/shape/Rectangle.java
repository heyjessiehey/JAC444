/**
 * 
 */
package shape;
/**
 * @author Gayeonko
 *
 */
public class Rectangle extends Parallelogram { //subclass
   // private ShapeProperty area = array -> array[0] * array[1];
	private ShapeProperty property = () -> getWidth() * getHeight();

	public Rectangle(double width, double height) throws ParallelogramException{
			super(width, height); //call superclass's constructor
	}

	public ShapeProperty getArea(){
	    return property;
    }

	@Override
	public String toString(){ //return string 
		return "Rectangle {w=" + getWidth() + ", h=" + getHeight() + "}" +
				" perimeter = " + perimeter() + " area = " + property.getProperty();
	}
}
