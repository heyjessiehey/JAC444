package shape;

public class Circle implements Shape{
	
	private double radius;
	
	//one argument constructor 
	public Circle(double radius) throws CircleException{
		if(radius > 0) //check the value is not negative or zero
			this.radius = radius;
		else // throw custom exception
			throw new CircleException("Invalid radius!");
	}
	
	//getter
	public double getRadius(){
		return radius;
	}
	
	//setter
	public void setRadius(double radius) throws CircleException{
		if(radius >0)
			this.radius = radius;
		else
			throw new CircleException("Invalid radius!");
	}
	
	/* 
	 * @see shape.Shape#perimeter()
	 */
	@Override
	public double perimeter() {
		return 2 * Math.PI * getRadius(); //calculate circle
	}
	
	@Override
	public String toString(){
		return "Circle {r=" + getRadius() + "}" + " perimeter = " + perimeter();
	}

}
