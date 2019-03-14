/**
 * 
 */
package shape;

/**
 * @author Gayeonko
 *
 */
public class Parallelogram implements Shape{
	private double width;
	private double height;
	private Area area; // functional interface
	
	//2 arguments constructor
	public Parallelogram(double width, double height) throws ParallelogramException{
		if(width > 0 && height > 0){ //check the values are not negative or zero
			this.width = width;
			this.height = height;
			this.area = (w, h) -> w * h; // create an obj of Area interface using lambda expression
		}else // throw exception
			throw new ParallelogramException("Invalid side!"); 
	}
	//getters
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public Area getArea() { return area;}
	//setters
	public void setWidth(double width) throws ParallelogramException{
		if(width > 0){
			this.width = width;
		}
		else{
			throw new ParallelogramException("Invalid width!");
		}
	}
	public void setHeight(double height) throws ParallelogramException{
		if(height > 0){
			this.height = height;
		}
		else{
			throw new ParallelogramException("Invalid height!");
		}
	}
	
	/* (non-Javadoc)
	 * @see shape.Shape#perimeter()
	 */
	@Override
	public double perimeter() {
		return 2 * getWidth() + 2 * getHeight(); //calculate parallelogram
	}

	@Override
	public String toString(){
		return "Parallelogram {w=" + getWidth() + ", h=" + getHeight() + "}" +
				" perimeter = " + perimeter();
	}

}
