import java.util.concurrent.TimeUnit;

class MyUtil {
	private MyUtil()
	{
		throw new AssertionError();
	}

	public static int getRandom(int lval, int rval)
	{
		return (int) Math.round((Math.random() * (rval - lval) + lval ));
	}
	public static void printArray(int[] array)
	{
		for(int i = 0; i < array.length; ++i)
			System.out.print(Integer.toString(array[i]) + " ");
		System.out.println();
	}
	public static void sortArray(int[] array, boolean isAsc)
	{
		//вставками
		for(int i = 1; i < array.length; ++i)
			for(int j = i; j > 0; --j) {
				if(	!isAsc && array[j] > array[j-1]
					|| isAsc && array[j] < array[j-1] ) {
						int tmp = array[j];
						array[j] = array[j-1];
						array[j-1] = tmp;
				} else break;	   
			}
	}
	public static long fib(int index)
	{
		if(index < 1) return 0;
		if(index == 1) return 1;
		return fib(index-2) + fib(index-1);
	}
}

class Task1 {
	public static void main(String[] args)
	{
		int a = 0, b = 10;
		System.out.println("Массив из 20 случайных целых отрезка [" + a + ";" + b + "]:");
		
		int[] randNums = new int[20];
		for(int i = 0; i < randNums.length; ++i)
			randNums[i] = MyUtil.getRandom(a, b);

		MyUtil.printArray(randNums);
	}
}
class Task2 {
	public static void main(String[] args)
	{
		int a = 0, b = 10;
		System.out.println("5 массивов из 10 случайных целых отрезка [" + a + ";" + b + "]:");
		 
		for(int i = 0; i < 5; ++i) {
			int[] randNums = new int[10];
			for(int j = 0; j < randNums.length; ++j)
				randNums[j] = MyUtil.getRandom(a, b);
			MyUtil.printArray(randNums);
		}
	}
}
class Task3 {
	public static void main(String[] args)
	{
		int a = 0, b = 10;
		System.out.println("Сортировка массива из 10 случайных целых отрезка [" + a + ";" + b + "]:");
		
		int[] randNums = new int[10];
		for(int j = 0; j < randNums.length; ++j)
			randNums[j] = MyUtil.getRandom(a, b);
		MyUtil.printArray(randNums);

		MyUtil.sortArray(randNums, true);
		MyUtil.printArray(randNums);
		MyUtil.sortArray(randNums, false);
		MyUtil.printArray(randNums);
	}
}
class Task4 {
	public static void main(String[] args)
	{
		int fibIndex = 0;
		long startTime;
		do {
			startTime = System.nanoTime();
			System.out.println("Index: " + fibIndex + " Value: " + MyUtil.fib(fibIndex++));
		}while(System.nanoTime() - startTime < TimeUnit.SECONDS.toNanos(60));
		
		System.out.println("Начиная с позиции " + Integer.toString(fibIndex-2) + " вычисление числа Фибоначчи занимает более минуты");
	}
}
