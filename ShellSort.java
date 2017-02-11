package Lab2;

public class ShellSort 
{
	public static void main(String[] args)
	{
		int j;
		int temp;
		int i;
		int a[] = {3, 1, 9, 4, 5, 10, 8, 7, 2, 6};
		
		System.out.println("Array (Disorganized): ");
		
		for(int l = 0; l < a.length; l++)
		{
			System.out.print(a[l] + " ");
		}
		int increments = 1;
		int k = 0;
		while(increments <= a.length + 1)
		{
			for(i = increments; i <= a.length - 1; i++)
			{
				temp = a[i];
				j = i;
				while(j >= increments && a[j - increments] > temp)
				{
					a[j] = a[j - increments];
					j = j - increments;
				}
				a[j] = temp;
			}
			k = k + 1;
			increments = (int)(java.lang.Math.pow(2, k)) - (int)1;
			
		}
		System.out.println(" ");
		System.out.println( "Organized Entries: ");
		for(int l = 0; l < a.length; l++)
		{
			System.out.print(a[l] + " ");
		}
	}

}
