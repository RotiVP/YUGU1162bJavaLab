class MyUtil {
	private MyUtil()
	{
		throw new AssertionError();
	}

	static void printClassName(Object obj)
	{
		System.out.println("Class name: " + obj.getClass().getSimpleName());
	}
	
	static void print(int data)
	{
		System.out.printf("type: int\n%d\n", data);
	}
	static void print(String data)
	{
		System.out.printf("type: string\n%s\n", data);
	}
	static void print(long data)
	{
		System.out.printf("type: long\n%d\n", data);
	}
	static void print(float data)
	{
		System.out.printf("type: float\n%f\n", data);
	}
	static void print(double data)
	{
		System.out.printf("type: double\n%f\n", data);
	}

	static int min(int a, int b)
	{
		return (a<b)?a:b;
	}
	static long min(long a, long b)
	{
		return (a<b)?a:b;
	}
	static double min(double a, double b)
	{
		return (a<b)?a:b;
	}

	static int max(int a, int b)
	{
		return (a>b)?a:b;
	}
	static long max(long a, long b)
	{
		return (a>b)?a:b;
	}
	static double max(double a, double b)
	{
		return (a>b)?a:b;
	}
}

class Cow {
	public String getName()
	{
		return "Я - корова";
	}
}
class Whale extends Cow{

	public String getName()
	{
		return "Я не корова, я - кит";
	}
}

class Cat {
	public Cat getChild()
	{
		System.out.println("Cat is borned");
		return new Cat();
	}
}
class Bird {
}
class Lamp {
}
class Dog extends Cat {

	public Dog getChild() 
	{
		System.out.println("Dog is borned");
		return new Dog();
	}
}

class Main {
	public static void main(String[] args)
	{
		Cow cow = new Whale(); cow.getName();

		Cat cat = new Cat(); cat.getChild();
		Dog dog = new Dog(); dog.getChild();

		MyUtil.printClassName(cat);
		MyUtil.printClassName(dog);

		MyUtil.print(MyUtil.max(1,2));	
		MyUtil.print(MyUtil.max(1l,2l));
		MyUtil.print(MyUtil.max(1d,2d));

		MyUtil.print(MyUtil.min(1,2));	
		MyUtil.print(MyUtil.min(1l,2l));
		MyUtil.print(MyUtil.min(1d,2d));
	}
}
