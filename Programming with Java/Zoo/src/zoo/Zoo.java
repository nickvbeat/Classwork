package zoo;
import java.util.Scanner;

public class Zoo {
	
	private int num_cages;
	private static Animal[] animals = new Animal[0];
	
	public Zoo() {
		num_cages=3;
	}
	
	public Zoo(int num_cages) {
		this.num_cages = num_cages;
	}
	
	void add(Animal a) {
		if(animals.length<num_cages)	
		animals = addAnimals(animals, a);
		else
			System.out.println("Zoo is full......can't add animal");
	}
	
	public static Animal[] addAnimals(Animal[] animals, Animal a) {
		Animal[] animalList = new Animal[animals.length+1];
		
		for(int i=0; i<animals.length; i++) {
			animalList[i]=animals[i];
		}
		animalList[animalList.length-1]=a;
		return animalList;		
	}
	
	public double totalWeight() {
		double totalWeight=0;	
		
		for(int i=0; i<animals.length; i++) {
			totalWeight += animals[i].getWeight();			
		}
		return totalWeight;
	}
	
	public void makeAllNoises() {
		for(int i=0; i<animals.length; i++) {
			animals[i].makeNoise();
		}		
	}
	public void printAllAnimals() {
		for(int i=0; i<animals.length; i++) {			
		System.out.println(animals[i].toString());
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Zoo!");
	
		Zoo userZoo = new Zoo();
		
		System.out.println("Let's get you started with a Cow. What will you name your cow?");
		
		String cowName = scan.nextLine();
		
		System.out.println(cowName + ", what a great name!");
		
		double randomCowWeight = (int)Math.floor(Math.random() * (1500-1000 +1));
		int randomCowAge = (int)Math.floor(Math.random() * (22 - 1 +1));
		int randomCowSpots = (int)Math.floor(Math.random() * (10 - 1 +1));
		
		Cow userCow = new Cow(cowName, randomCowWeight, randomCowAge, randomCowSpots);
		
		userCow.makeNoise();
		System.out.println("Wow " + cowName + " sure is happy to be in your zoo!");
		
		userZoo.add(userCow);
		
		
		
		
		System.out.println("Can't have a zoo with just one cow...How about a horse? \n" + 
									"What will you name your stallion?");
		
		String horseName = scan.nextLine();
	
		System.out.println("Giddie up, " + horseName + "!");
		
		int randomHorseAge = (int)Math.floor(Math.random() * (30 - 1 +1));
		double randomHorseWeight = (int)Math.floor(Math.random() * (10 - 1 +1));
		int randomHorseSpeed = (int)Math.floor(Math.random() * (30 - 25 +1));
		
		Horse userHorse = new Horse(horseName, randomHorseWeight, randomHorseAge, randomHorseSpeed);
		
		userZoo.add(userHorse);
		
		userHorse.makeNoise();
		
		
		
		
		System.out.println("Alright so we've got "+ cowName + " the cow and " + 
								horseName + " the horse. How about a snake to finish this zoo?!\n" +
								"What will you name your snake?");
		
		String snakeName = scan.nextLine();
		
		System.out.println(snakeName + "! Such a slithery one.");
		
		int randomSnakeAge = (int)Math.floor(Math.random() * (30 - 1 +1));
		double randomSnakeWeight = (int)Math.floor(Math.random() * (350 - 2 +1));
		int randomSnakeFangs = (int)Math.floor(Math.random() * (4 - 1 +1));
		
		Snake userSnake = new Snake(snakeName, randomSnakeWeight, randomSnakeAge, randomSnakeFangs);
		userZoo.add(userSnake);
		userSnake.makeNoise();
		
		
		
		
		System.out.println("Ahh! Sorry, snakes scare me.\n" + "What a beautiful zoo! "
						+ "Let's see your zoo's stats:");
		
		System.out.println("Zoo's total weight (all animals combined): "+ userZoo.totalWeight());
		userZoo.printAllAnimals();
		System.out.println("Thanks for making this zoo! Bye for now!");
		
	}	
	
}