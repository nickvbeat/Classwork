package zoo;

public class Horse extends Animal {
	
	double topSpeed;

	public Horse(String n, double weight, int age, double topSpeed) {
		super(n, weight, age);
		this.topSpeed = topSpeed;
	}
	
	public void makeNoise() {
		System.out.println("Whinny");
	}
	
	public String toString() {
		return super.toString() + " top speed = " + topSpeed;
	}
	
	

}