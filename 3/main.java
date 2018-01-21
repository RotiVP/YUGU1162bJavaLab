class MyUtil {

	private MyUtil()
	{
		throw new AssertionError();
	}
	
	static int[] getEvenOddCount(int start, int end)
	{
		int evenCount = 0;
		int oddCount = 0;

		for(int i = start; i <= end; ++i) {
			if( i % 2 == 0) ++evenCount;
			else ++oddCount;
		}

		return new int[]{evenCount, oddCount};
	}
	static int[] getEvenOddCount(int[] array)
	{
		int evenCount = 0;
		int oddCount = 0;
		
		for(int i = 0; i < array.length; ++i) {
			if(array[i]/* % 10)*/ % 2 == 0) ++evenCount;
			else ++oddCount;
		}
		return new int[]{evenCount, oddCount};
	}
	static void randomFillArray(int[][] array, int lval, int rval)
	{
		for(int i = 0; i < array.length; ++i)
			for(int j = 0; j < array[i].length; ++j)
				array[i][j] = (int) Math.round(Math.random() * (rval-lval) + lval);
	}
	static void randomFillArray(int[] array, int lval, int rval)
	{
		for(int i = 0; i < array.length; ++i)
			array[i] = (int) Math.round(Math.random() * (rval-lval) + lval);
	}
	static void printArray(int[][] array)
	{
		for(int i = 0; i < array.length; ++i) {
			for(int j = 0; j < array[i].length; ++j) {
				System.out.print(Integer.toString(array[i][j]) + "\t");
			}
			System.out.println();
		}
	}
	static void printArray(int[] array, String spliter)
	{
		for(int i = 0; i < array.length; ++i)
			System.out.print(Integer.toString(array[i]) + spliter);
		System.out.println();
	}
}
class Task1 {
	public static void main(String[] args)
	{
		System.out.println("Четные числа из массива от 2 до 20 сначала в строку, затем в столбец:");

		//init
		int start = 2, end = 20;
		int evenCount = MyUtil.getEvenOddCount(start, end)[0];
		int[] nums = new int[evenCount];	
		
		//fill
		for(int i = start, j = 0; i <= end; ++i)
			if( (i % 10) % 2 == 0 )
				nums[j++] = i;

		//output
		MyUtil.printArray(nums, " ");
		MyUtil.printArray(nums, "\n");
	}
}
class Task2 {
	public static void main(String[] args)
	{
		System.out.println("Массив из чисел от 1 до 99 в прямом и обратном порядке:");

		//init
		int start = 1, end = 99;
		int oddCount = MyUtil.getEvenOddCount(start, end)[1];
		int[] nums = new int[oddCount];

		//fill
		for(int i = start, j = 0; i <= end; ++i)
			if( (i % 10) % 2 != 0 )
				nums[j++] = i;
		
		//output
		MyUtil.printArray(nums, " ");
		for(int i = nums.length - 1; i >= 0; --i)
			System.out.print(Integer.toString(nums[i]) + " ");
		System.out.println();
		
	}
}
class Task3 {
	public static void main(String[] args)
	{
		System.out.println("Массив из случайных целых отрезка [0;9]:");

		int[] nums = new int[15];
		
		MyUtil.randomFillArray(nums, 0, 9);
		MyUtil.printArray(nums, " ");

		int[] evenOddCount = MyUtil.getEvenOddCount(nums);
		System.out.println("Четных элементов: " + evenOddCount[0]);
		System.out.println("Нечетных элементов: " + evenOddCount[1]);
	}
}
class Task4 {
	public static void main(String[] args)
	{
		System.out.println("Двумерный массив 8x5 из случайных целых отрезка [10;99]:");
		int row = 8, col = 5;
		int[][] nums = new int[row][col];

		MyUtil.randomFillArray(nums, 10, 99);
		MyUtil.printArray(nums);
	}	
}
class Task5 {
	public static void main(String[] args)
	{
		System.out.println("Двумерный массив 7x4 из случайных целых отрезка [-5;5]:");
		int row = 7, col = 5;
		int[][] nums = new int[row][col];

		MyUtil.randomFillArray(nums, -5, 5);
		MyUtil.printArray(nums); 

		int[] mulRows = new int[]{1, 1, 1, 1, 1, 1, 1};
		for(int i = 0; i < nums.length; ++i){
			for(int j = 0; j < nums[i].length; ++j)
				mulRows[i] *= nums[i][j];
			mulRows[i] = Math.abs(mulRows[i]);
		}
		//из сортировки выборкой
		int indexOfBiggest = 0;
		for(int i = 1; i < mulRows.length; ++i)
			if(mulRows[i] > mulRows[indexOfBiggest])
				indexOfBiggest = i;

		System.out.println("Наибольшее произведение элементов строки по модулю: "
							+ Integer.toString(mulRows[indexOfBiggest]) + "\n"
							+ "Строка под индексом: "
							+ Integer.toString(indexOfBiggest));
	}
}
