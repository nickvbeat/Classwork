package zoo;

abstract class Animal {
	private String name;
	private double weight;
	private int age;
	
	public Animal(String n, double weight, int age) {
		name=n;
		this.weight = weight;
		this.age = age;
	}
	public abstract void makeNoise();
	
	public double getWeight() {
		return weight;
	}
	
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", age=" + age + "]";
	}
	
}
