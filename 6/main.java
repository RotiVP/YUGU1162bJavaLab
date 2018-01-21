import java.util.Scanner;

class MyUtil {
	private MyUtil()
	{
		throw new AssertionError();
	}
	
	public static Scanner sc = new Scanner(System.in);

	public static String getIn(String help, String ptrn, String invalid)
	{
		System.out.println(help);

		while (!sc.hasNext(ptrn)){
			sc.next();
			System.out.println(invalid);
		}
		return sc.next();
	}
}

//Task1
class Horse {
	protected String name;

	public Horse()
	{
		name = MyUtil.getIn(
				"Horse's name: ",
				"\\w{3,}", 
				"Invalid name! Try again...");
	}
}
class Pegas extends Horse {
	
	public void fly()
	{
		System.out.println("I believe " + name + " can fly...");
	}
}
class Task1 {
	public static void main(String[] args)
	{
		Pegas p = new Pegas();
		p.fly();
	}
}

//Task24
class Pet {
	protected int age, weight;
	protected boolean isMale;

	public Pet() 
	{
		age = Integer.parseInt(MyUtil.getIn(
				"Pet age: ",
				"\\d+",
				"Invalid age! Try again..."));

		weight = Integer.parseInt(MyUtil.getIn(
				"Pet weight: ",
				"\\d+",
				"Invalid wight! Try again..."));

		String isMaleKey = "y";
		String isMaleAns = MyUtil.getIn(
				"Pet is male? ("+ isMaleKey +" if yes): ",
				"\\w+",
				"Invalid wight! Try again...");
		isMale = (isMaleAns.equals(isMaleKey)) ? true : false;
	}
}
class Cat extends Pet {	
	private String name;	
	public void changeName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public String getInfo()
	{
		String maleAns = (isMale) ? "male" : "not male";
		return 
		"Cat " + name + " is pet."
		+ "It has " + age + " old and " + weight + "weight."
		+ "Also it is " + maleAns + ".";
	}
}
class Dog extends Pet {
		
	public String name;	
	
	public String getInfo()
	{
		String maleAns = (isMale) ? "male" : "not male";
		return 
		"Dog " + name + " is pet."
		+ " It has " + age + " old and " + weight + " weight."
		+ " Also it is " + maleAns + ".";
	}
}
class Task24 {
	public static void main(String[] args)
	{
		Cat cat = new Cat();
		cat.changeName(MyUtil.getIn(
			"Cat's name: ",
			"\\w{3,}", 
			"Invalid name! Try again..."));
		System.out.println(cat.getInfo());

		Dog dog = new Dog();
		dog.name = MyUtil.getIn(
			"Dog's name: ",
			"\\w{3,}", 
			"Invalid name! Try again...");
		System.out.println(dog.getInfo());
	}
}

//Task3
class Fish {
	private boolean swimAbl = true;

	protected void changeSwimAbl(boolean b)
	{
		swimAbl = b;
	}
	protected boolean getSwimAbl()
	{
		return swimAbl;
	}
}
class Animal extends Fish {
	enum HairCowerType {
		FLUFFY, SHORT, BALD	
	}
	private HairCowerType hairCower = HairCowerType.SHORT;

	protected void changeHairType(HairCowerType type)
	{
		hairCower = type;
	}
	protected HairCowerType getHairCower()
	{
		return hairCower;
	}
}
class Ape extends Animal {
	private boolean likeBanana = true;

	protected void changeLikeBanana(boolean b)
	{
		likeBanana = b;
	}
	protected boolean isLikeBanana()
	{
		return likeBanana;
	}
}
class Human extends Ape {
	private boolean canSpeak = true;

	protected void changeCanSpeak(boolean b)
	{
		canSpeak = b;	
	}
	protected boolean getCanSpeak()
	{
		return canSpeak;
	}

	public void showInfo()
	{
		System.out.println(
		"1. Swim ability: " + ((getSwimAbl())?"true":"false")
		+ "\n2. Hair: " + getHairCower().name()
		+ "\n3. Like banana: " + ((isLikeBanana())?"true":"false")
		+ "\n4. Can speak: " + ((canSpeak)?"true":"false")
		);

	}
}
class Task3 {
	public static void main(String[] args)
	{
		Human human = new Human();
		while(true) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			//System.console().flush();
			human.showInfo();
			int num = Integer.parseInt(
				MyUtil.getIn(
					"Num to change: ",
					"\\d+",
					"Invalid number! Try again..."));
			switch(num) {
			case 1:
				human.changeSwimAbl(!human.getSwimAbl());
				break;
			case 2:
				String hairMenu=""; int i = 1;
				for(Animal.HairCowerType type : Animal.HairCowerType.values())
					hairMenu+=Integer.toString(i++)+" "+type.name()+" ";
				System.out.println(hairMenu);
				human.changeHairType(
						Animal.HairCowerType.values()[Integer.parseInt(
							MyUtil.getIn(
								"Num of hair: ",
								"[1-"+(i-1)+"]",
								"Invalid number! Try again..."))-1
						]);
				break;
			case 3:
				human.changeLikeBanana(!human.isLikeBanana());
				break;
			case 4:
				human.changeCanSpeak(!human.getCanSpeak());	
				break;
			}
		}
	}
}
