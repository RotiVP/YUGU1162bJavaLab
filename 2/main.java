import java.util.Scanner;

class MyUtil {

	private MyUtil() 
	{
		throw new AssertionError();
	}

	static Scanner sc = new Scanner(System.in);

	static public int getInt()
	{
		while(!sc.hasNextInt()) {
			System.out.println("Invalid data!");
			sc.next();
		}
		return sc.nextInt();
	}
	static public String getName()
	{
		boolean isValidName;// = true;
		String name;
		do {
			isValidName = true;
			name = sc.nextLine();
			if (name.matches("\\W")) {
				System.out.println("Invalid data!");
				isValidName = false;
			}
		} while (!isValidName);
		return name;
	}
	static public int getMin(int r, int l)
	{
		return (l < r) ? l : r;
	}
	static public int getMin(int v1, int v2, int v3, int v4)
	{
		return getMin(getMin(getMin(v1, v2), v3), v4);
	}
}
class Point {
	public Point(int _x, int _y)
	{
		x = _x;
		y = _y;
	}
	public int x, y;
	public int getQuarter() 
	{
		if(x == 0 || y == 0) return 0;	
		if(x > 0) {
			if(y>0) return 1; 
			else return 4;
		} 
		if(y>0) return 2;
		else return 3;
	}
}
class Task1 {
	public static void main(String[] args)
	{
		System.out.println("Четные числа от 1 до 100 включительно:");

		for(int i = 1; i <= 100; ++i)
			if(i%2==0)
				System.out.print(Integer.toString(i)+' ');
		System.out.println();
	}
}
class Task2 {
	public static void main(String[] args)
	{
		System.out.print("Введите m и n для построения прямоугольника: ");

		int row = MyUtil.getInt(), col = MyUtil.getInt();

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j)
				System.out.print("8");
			System.out.println();
		}
	}
}
class Task3 {
	public static void main(String[] args)
	{
		System.out.println("Прямоугольный треугольник 10x10:");

		for(int i = 0; i < 10; ++i) {
			for(int j = 0; j < 10; ++j) {
				if(j > i) break;
				else System.out.print("8");
			}
			System.out.println();
		}
	}
}
class Task4 {
	public static void main(String[] args)
	{
		System.out.print("Введите 2 числа для вывода минимального: ");

		int r = MyUtil.getInt(), l = MyUtil.getInt();
		System.out.println(MyUtil.getMin(r,l));	
	}
}
//--- 
class Task5 {
	public static void main(String[] args)
	{
		System.out.println("Введите 2 имени для проверки:");

		String firstName = MyUtil.getName(), secondName = MyUtil.getName();
		String resultMsg;

		if( firstName.equals(secondName) )
			resultMsg = "Имена идентичны.";
		else if ( firstName.length() == secondName.length() )
			resultMsg = "Длины имен равны.";
		else resultMsg = "Имена не совпадают.";

		System.out.println(resultMsg);
	}
}
class Task6 {
	public static void main(String[] args)
	{
		System.out.print("Введите 4 числа для вывода минимального: ");

		System.out.println("Min value: " 
							+ Integer.toString(MyUtil.getMin(	
										MyUtil.getInt(), 
										MyUtil.getInt(),
										MyUtil.getInt(),
										MyUtil.getInt())) );
	}
}
class Task7 {
	public static void main(String[] args)
	{
		System.out.print("Введите координаты точки, не лежащей на координатных осях: ");

		Point pnt = new Point(MyUtil.getInt(), MyUtil.getInt());
		int quarter = pnt.getQuarter();
		String outputMsg;
		if(quarter == 0) outputMsg = "Точка лежит на координатной оси.";
		else outputMsg = "Четверть точки: " + Integer.toString(quarter);

		System.out.println(outputMsg);
	}
}
