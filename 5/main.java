import java.util.Scanner;

class MyUtil {
	private MyUtil() 
	{
		throw new AssertionError();
	}

	public static Scanner sc = new Scanner(System.in);
	public static int getInt()
	{
		while(!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid integer data! Try again...");
		}
		return sc.nextInt();
	}
	public static double[] getSqrt(double a, double b, double c) {
		double d = Math.pow(b, 2) - 4*a*c;
		if(d < 0) return null;
		else if ( d > 0 ) 
			return new double[]{
				(-b + Math.sqrt(d)) / (2*a),
				(-b - Math.sqrt(d)) / (2*a)
			};
		else
			return new double[]{
				(-b + Math.sqrt(d)) / (2*a)
			};
	}
	public static void showHelp() {
		System.out.println(
			"1 - get length"
			+ "\n2 - set origin"
			+ "\n3 - get distance"
			+ "\n4 - is single intersection"
			+ "\n5 - get intersection coords"
			+ "\n6 - this message");
	}
}
class Circle {

	class IntersectionResult{
		public double[] x;
		public double[] y;
	}

	int x;
	int y;
	int r;

	public Circle() 
	{
		System.out.print("Origin coord: ");
		x = MyUtil.getInt();
		y = MyUtil.getInt();
		System.out.print("Radius: ");
		r = MyUtil.getInt();
	}

	private int getRandomPoint()
	{
		return (int)Math.round(Math.random()*99*2-99);
	}

	public double getLength()
	{
		return 2*Math.PI*r;
	}
	public void setRandomOrigin()
	{
		x = getRandomPoint();
		y = getRandomPoint();
	}
	public double getCircleDistance(Circle circle)
	{
		return Math.sqrt(Math.pow(x-circle.x, 2) + Math.pow(y-circle.y, 2));
	}
	public boolean isSingleIntersection(Circle circle)
	{
		double d = getCircleDistance(circle);
		if(	d == r + circle.r
			|| r == circle.r + d
			|| circle.r == r + d) return true;
		return false;
	}
	public IntersectionResult getIntersection(Circle circle)
	{
		IntersectionResult result = new IntersectionResult();

		if(x == circle.x && y == circle.y) return result;

		//xA + yB + C = 0
		int A = 2 * (circle.x - x);
		int B = 2 * (circle.y - y);
		double C =	Math.pow(x, 2) - Math.pow(circle.x, 2)
					+ Math.pow(y, 2) - Math.pow(circle.y, 2)
					- Math.pow(r, 2) + Math.pow(circle.r, 2);

		double a,b,c;
		if(A == 0) {
			double yintersection = -C/B;
			
			a = 1;
			b = -2*x;
			c = - Math.pow(r, 2)
				+ Math.pow(x, 2)
				+ Math.pow(yintersection, 2)
				- 2*yintersection*y
				+ Math.pow(y, 2);

			result.x = MyUtil.getSqrt(a, b, c);
			if(result.x == null) return result;
			else { 
				result.y = new double[result.x.length];
				for(int i = 0; i < result.y.length; ++i)
					result.y[i] = yintersection;
			}
		} else {

			//ay^2 + by + c = 0
			a = Math.pow(B, 2) / Math.pow(A, 2)
				+ 1;
			b = 2*B*C / Math.pow(A, 2) 
				+ 2*x*B / A 
				- 2*y;
			c = Math.pow(C, 2) / Math.pow(A, 2) 
				+ 2*x*C / A 
				+ Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(r, 2);

			result.y = MyUtil.getSqrt(a, b, c);
			if(result.y == null) return result;

			result.x = new double[result.y.length];
			for(int i = 0; i < result.x.length; ++i)
				result.x[i] = -(result.y[i]*B+C)/A;
		}

		return result;
	}
}
class Main {
	public static void main(String args[])
	{
		System.out.println("Creating two circles...");
		Circle[] circles = new Circle[]{new Circle(), new Circle()};
		System.out.println("Ok.");
		MyUtil.showHelp();
		/*
		1 - get length
		2 - set origin
		3 - get distance
		4 - is single intersection
		5 - get intersection coords
		6 - this message
		*/

		boolean exit = false;
		String answer;
		do {
			switch(MyUtil.getInt()){
			case 1:
				answer = "1: " + circles[0].getLength() 
								+ "\n2: " + circles[1].getLength();
				System.out.println(answer);
				break;
			case 2:
				for(int i = 0; i<circles.length; ++i)
					circles[i].setRandomOrigin();
				answer =	"1: x1=" + circles[0].x + " y1=" + circles[0].y
							+ "\n2: x2=" + circles[1].x + " y2=" +circles[1].y;
				System.out.println(answer);
				break;
			case 3:
				System.out.println(
						Double.toString(circles[0].getCircleDistance(circles[1])));
				break;
			case 4:
				if(circles[0].isSingleIntersection(circles[1]))
					answer = "yes";	
				else answer = "no";
				System.out.println(answer);
				break;
			case 5:
				Circle.IntersectionResult data = circles[0].getIntersection(circles[1]);
				if(data.x == null)
					answer = "Do not intersect";
				else {
					answer = "x1=" + data.x[0] + " y1=" + data.y[0];
					if (data.x.length == 2)
						answer += "\nx2=" + data.x[1] + " y2=" + data.y[1];
				}
				System.out.println(answer);
				break;
			case 6:
				MyUtil.showHelp();
				break;
			default:
				System.out.println("Invalid option. Try again...");
			}
		}while(!exit);
	}
}
