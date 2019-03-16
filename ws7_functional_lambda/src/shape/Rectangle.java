/**
 * 
 */
package shape;
/**
 * @author Gayeonko
 *
 */
public class Rectangle extends Parallelogram { //subclass
    private Area area = (w, h) -> w * h;

	public Rectangle(double width, double height) throws ParallelogramException{
			super(width, height); //call superclass's constructor
            //this.area = (w, h) -> w * h; // create an obj of Area interface using lambda expression
	}

	public Area getArea(){
	    return area;
    }

	@Override
	public String toString(){ //return string 
		return "Rectangle {w=" + getWidth() + ", h=" + getHeight() + "}" +
				" perimeter = " + perimeter() + " area = " + area.calArea(getWidth(), getHeight()); // defined calArea method by lambda
	}
}
