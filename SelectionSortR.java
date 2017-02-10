package Lab2;

public class SelectionSortR 
{
	final static int number = 15;
	
	public static void main(String[] args)
	{
		double[] a = new double[number];
		init(a, number);
		System.out.println("Organized: ");
		selectionSort(a, number);
		printit(a, number);		
	}
	
	static int maxind(double[] a, int n)
	{
		int maxi;
		if(n == 1) return 0;
		maxi = maxind(a, n - 1);
		if(a[n - 1] > a[maxi]) return n - 1;
		return maxi;
	}
	
	static void init (double[] a,int n)
	{
		int i;
		for(i = 0; i < n; i++)
			a[i] = Math.random();
	}
	
	static void interchange(double[] a, int i, int j)
	{
		double t = a[i];
		a[i] = a[j];
		a[i] = t;
	}
	
	static void selectionSort(double[] a, int n)
	{
		if(n > 1)
		{
			int maxi = maxind(a, n);
			interchange(a, maxi, n - 1);
			selectionSort(a, n - 1);
		}
	}
		
		static void printit(double[]a, int n)
		{
			for(int i = 0; i < n; i++)
				System.out.println("a[" + i + "]: "+ a[i]);
		}
}
