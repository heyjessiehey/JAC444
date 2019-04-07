import java.io.Serializable;

@SuppressWarnings("serial")
public class Car implements Serializable {
	
	private String model;
	private String owner;
	private double mileage;
	private String registration;

	public Car( String brand, String name, double m ) {
		model = brand;
		owner = name;
		mileage = m;
		registration = "unregistered";
	}

	@Override
	public String toString() {
		return "Model: " + model + " Owner: " + owner +
				" mileage: " +  mileage +
				" Registration: " + registration;
	}

	public void getRegistered(String plate) {
		registration = plate;
	}
}
