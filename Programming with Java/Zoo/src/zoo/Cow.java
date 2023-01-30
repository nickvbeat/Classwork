package zoo;

public class Cow extends Animal {
	
	private int numberSpots;

	public Cow(String n, double weight, int age, int numberSpots) {
		super(n, weight, age);
		this.numberSpots = numberSpots;
	}
	
	public void makeNoise() {
		System.out.println("Mooooo");
	}
	
	public String toString() {
		return super.toString() + " number of spots = " + numberSpots;
	}
	
}