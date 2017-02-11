package Lab2;


public class RadixSort 
{
	public static void main(String[] args)
	{
		int a[] = {0,4,2,1,7,8,6,9,10,5,3};
		System.out.print("Array (Disorganized: ");
		printArray(a);
		radixSort(a);
	}
	public static void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void radixSort(int array[])
	{
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++)
			max = Math.max(max,  array[i]);
		
		int p = 1;
		int pass = 1;
		
		while(max / p > 0)
		{
			array = countingSort(array, array.length, p);
			System.out.print("After " + pass + ": ");
			
			printArray(array);
			pass++;
			p *= 10;
		}
		
	}
	
	public static int[] countingSort(int array[], int N, int p)
	{
		int output[] = new int[N];
		int count[] = new int[10];
		
		for(int i = 0; i < N; i++)
			count[(array[i]/p)%10]++;
		
		for(int i = 1; i < 10; i++)
		{
			count[i] += count[i - 1];
		}
		
		for(int i = N - 1; i >= 0; i--)
		{
			output[count[(array[i]/p) % 10] - 1] = array[i];
			count[(array[i] / p) % 10]--;
		}
		return output;
	}
}
