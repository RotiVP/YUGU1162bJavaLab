import java.util.ArrayList;

abstract class Pet {
	String	name;
	short	age;
	boolean hungry;

	public abstract void voice();
}
class Snake 
	extends Pet 
{
	public void voice()
	{
		System.out.println("Sss...");
	}
}
class Dog 
	extends Pet 
{
	public void voice() 
	{
		System.out.println("Woof.");
	}
}
class PatrolDog 
	extends Pet 
{
	public void voice() 
	{
		System.out.println("WOOF!");
	}
}
class Cat 
	extends Pet 
{
	public void voice()
	{
		System.out.println("Meow.");
	}
}
class Fish 
	extends Pet 
{
	public void voice()
	{
		System.out.println("...");
	}
}

interface PassengersAuto {
	void carryPassenger();	
}
interface CargoAuto {
	void carryCargo();	
}
class Truck 
	implements PassengersAuto, CargoAuto
{
	public void carryPassenger()
	{
		System.out.println("Truck carry passenger.");
	}
	public void carryCargo()
	{
		System.out.println("Truck carry cargo.");
	}
}
class Sedan
	implements PassengersAuto, CargoAuto
{
	public void carryPassenger()
	{
		System.out.println("Sedan carry passenger.");
	}
	public void carryCargo()
	{
		System.out.println("Sedan carry cargo.");
	}
}
class Pickup
	implements PassengersAuto, CargoAuto
{
	public void carryPassenger()
	{
		System.out.println("Pickup carry passenger.");
	}
	public void carryCargo()
	{
		System.out.println("Pickup carry cargo.");
	}
}

class Main {
	public static void main(String[] args)
	{
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(new Snake());
		list.add(new Dog());
		list.add(new PatrolDog());
		list.add(new Cat());
		list.add(new Fish());
		for(Object obj : list){
			Pet pet = (Pet)obj;	
			pet.voice();
		}

		list = new ArrayList<Object>(); 
		list.add(new Truck());
		list.add(new Sedan());
		list.add(new Pickup());
		for(Object obj : list) {
			PassengersAuto pacar = (PassengersAuto) obj;	
			pacar.carryPassenger();
			CargoAuto cacar = (CargoAuto) obj;
			cacar.carryCargo();
		}
		
	}
}
