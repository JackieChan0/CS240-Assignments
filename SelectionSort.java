package Lab2;

public class SelectionSort <T>
{
	public static int[] selectionSort(int[] array)
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			int index = i;
			for(int j = i + 1; j < array.length; j++)

				if(array[j] < array[index])
					index = j;
				
				int smallerNum = array[index];
				array[index] = array[i];
				array[i] = smallerNum;
		
		}
		return array;
	}
	
	public static void main(String a[])
	{
		int[] firstArray = {2,10,3,1,5,7,6,8,9,4};
		int[] sortedArray = selectionSort(firstArray);
		
		for(int i: sortedArray)
		{
			System.out.println(i);
			System.out.println(", ");
		}
	}
}
