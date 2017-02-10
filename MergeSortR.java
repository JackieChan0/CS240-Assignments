package Lab2;

public class MergeSortR 
{
  public static void mergeThis(int[] array, int left, int mid, int right)
  {
	  int [] temp = new int[10];
	  int i, leftPoint, numOfElements, tempPoint;
	  
	  leftPoint = (mid - 1);
	  tempPoint = left;
	  numOfElements = (right - left + 1);
	  
	  while ((left <= leftPoint) && (mid <= right))
	  {
		 if(array[left] <= array[mid])
			 temp[tempPoint++] = array[left++];
		 else
			 temp[tempPoint++] = array[mid++];	 
	  }
	  
	  while (left <= leftPoint)
		  temp[tempPoint++] = array[left++];
	  while (mid <= right)
		  temp[tempPoint++] = array[mid++];
	  for(i = 0; i < numOfElements; i++)
	  {
		  array[right] = temp[right];
		  right--;
	  }
  }
  
  public static void mergeThisR(int[] num, int left, int right)
  {
	  int mid;
	  
	  if(right > left)
	  {
		  mid = (right + left)/2;
		  mergeThisR(num, left, mid);
		  mergeThisR(num, (mid + 1), right);
		  
		  mergeThis(num, left, (mid + 1), right);
	  }
  }
  
  public static void main(String[] args)
  {
	  int[] array = {8, 4, 2, 1, 3, 7, 6, 9, 10, 5};
	  int length = 10;
	  
	  System.out.println("Sorted Array:");
	  
	  mergeThisR(array, 0, length - 1);
      for (int i = 0; i < 10; i++)
          System.out.println(array[i]);
  }
  
}
