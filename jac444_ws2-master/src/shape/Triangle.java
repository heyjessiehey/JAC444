/**
 * 
 */
package shape;

/**
 * @author Gayeonko
 *
 */
public class Triangle implements Shape {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(double side1, double side2, double side3) throws TriangleException{
		if(side1 > 0 && side2 > 0 && side3 > 0 && (side1 + side2) > side3){ //check the values are not negative or zero
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}else // throw custom exception if value is invalid
			throw new TriangleException("Invalid side(s)!");
	}
	//getters
	public double getSide1(){
		return side1;
	}
	public double getSide2(){
		return side2;
	}
	public double getSide3(){
		return side3;
	}
	//setters
	public void setSide1(double side1) throws TriangleException{
		if(side1 > 0){
			this.side1 = side1;
		}else
			throw new TriangleException("Invalid side1!");
	}
	public void setSide2(double side2) throws TriangleException{
		if(side2 > 0){
			this.side2 = side2;
		}else
			throw new TriangleException("Invalid side2!");
	}
	public void setSide3(double side3) throws TriangleException{
		if(side3 > 0){
			this.side3 = side3;
		}else
			throw new TriangleException("Invalid side3!");
	}
	

	/* (non-Javadoc)
	 * @see shape.Shape#perimeter()
	 */
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return getSide1() + getSide2() + getSide3(); //calculate triangle
	}
	
	public String toString(){
		return "Triangle {s1=" + getSide1() + ", s2=" + getSide2() + ", s3=" + getSide3() + "}" +
				" perimeter = " + perimeter();
	}

}
