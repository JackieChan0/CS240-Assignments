package Lab2;

public class MergeSort 
{

	public static int min(int a, int b)
		{
			return (a < b)? a : b; 
		}

	public static void mergeThis(int [] array, int n)
	{
		int length;  
        int leftPoint; 
 
		for (length = 1; length <= n-1; length = 2*length)
		{
       
			for (leftPoint = 0; leftPoint < n - 1; leftPoint += 2*length)
			{
           
				int middle = leftPoint + length - 1;
 
				int rightPoint = min(leftPoint + 2*length - 1, n-1);
 
				merge(array, leftPoint, middle, rightPoint);
			}
		}
	}
 
	public static void merge(int array[], int left, int mid, int right)
	{
		int i;
		int j; 
		int k;
		
		int num1 = mid - left + 1;
		int num2 =  right - mid;
 
		int [] leftNumber = new int[num1];
		int [] rightNumber = new int[num2];
 
    
		for (i = 0; i < num1; i++)
			leftNumber[i] = array[left + i];
		
		for (j = 0; j < num2; j++)
			rightNumber[j] = array[mid + 1+ j];
		
    
		i = 0;
		j = 0;
		k = left;
		
		while (i < num1 && j < num2)
		{
			if (leftNumber[i] <= rightNumber[j])
			{
				array[k] = leftNumber[i];
				i++;
			}
			else
			{
				array[k] = rightNumber[j];
				j++;
			}
			k++;
		}
 
    
		while (i < num1)
		{
			array[k] = leftNumber[i];
			i++;
			k++;
		}
   
		while (j < num2)
		{
			array[k] = rightNumber[j];
			j++;
			k++;
		}
	}
	public static void print(int [] arr)
	{
		for(int i= 0;i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		int[] a = {5, 7, 10, 8, 2, 1, 3, 9, 6, 4};
		
		print(a);
		mergeThis(a, a.length);
		
		print(a);
  
	}
}
