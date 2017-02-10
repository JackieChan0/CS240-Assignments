package Lab2;

public class InsertionSortR 
{
    static int[] array = {7, 10, 9, 8, 5, 2, 4, 6, 1, 3};
    int max = array.length;

    public static void main(String[] args) 
    {
        print(array);
        new InsertionSortR().sort(array.length);
    }

  
    private int sort(int max) 
    {
        if (max <= 1) 
        {
            
            return max;
        }

        max = sort(max - 1);  
        
        int key = array[max];  

        int i = max - 1;

        while ((i >= 0) && (array[i] > key)) {
            array[i+1] = array[i];
            i--;
        }
        
        array[i +1 ] = key;
        print(array);
        return max + 1;
    }
    
    private static void print(int[] array) 
    {
    
    	System.out.println("Sorting List: ");
    	for (int i = 0; i < 10; i++)
            System.out.println(array[i]);
        
    }
}
