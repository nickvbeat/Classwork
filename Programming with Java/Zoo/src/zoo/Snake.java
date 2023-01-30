package zoo;

public class Snake extends Animal{
	
	private int num_fangs;
	
	public Snake(String n, double weight, int age, int num_fangs) {
		super(n, weight, age);
		this.num_fangs = num_fangs;
	}
	
	public void makeNoise() {
		System.out.println("Hisssssssss");
	}

	
	public String toString() {
		return super.toString()+ " number of fangs = " + num_fangs;
	}
	
	

}