package Lab2;

public class RadixSortR 
{
	public static int[] sort(int[] numbers, int digit) 
	{

	     if (numbers.length == 0 || digit <= 0)
	           return numbers;

	     int[][]space = new int[10][1];
	     int[] length = new int[10];
	     int i, j = 0;

	      for (j = 0; j < numbers.length; j++) 
	      {
	            i = (numbers[j] / digit) % 10;
	            length[i]++;
	            space[i] = intoBucket(space[i], numbers[j]);
	      }


	      for (i = 0; i < 10; i++)
	      {
	          int[] bucket = new int[length[i]];
	          for (int k = 0; k < length[i]; k++) 
	              bucket[k] = space[i][k];
	          space[i] = sort(bucket, digit / 10); 
	      }

	      int k = 0;

	      for (i = 0; i < 10; i++) 
	      {
	          for (j = 0; j < length[i]; j++) 
	          {
	              numbers[k] = space[i][j];
	              k++;
	          }
	      }

	      return numbers; 

	}

	private static int[] intoBucket(int[] bucket, int num) 
	{

	    int[] bucket2 = new int[bucket.length+1];
	    
	    for (int i = 1; i < bucket2.length; i++) 
	    {
	        bucket2[i] = bucket[i-1];
	    }
	    	bucket2[0] = num;

	    	return bucket2;

	}
}
