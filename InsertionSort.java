package Lab2;


public class InsertionSort 

{

	public static int[] insertionSort(int[] array)
	{
		
		int temp;
		for(int i = 1; i < array.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(array[j] < array[j - 1])
				{
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					
				}
			}
		}
		return array;
		
	}
	
	public static void main(String a[])
	{
		int[] firstArray = {3,2,5,6,4,10,1,9,7,8};
		int[] sortedArray = insertionSort(firstArray);
		for(int i: sortedArray)
		{
			System.out.println(i);
			System.out.println(" ");
		}
	}
	

}
