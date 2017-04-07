
public class InversionMerge 
{
	public static void main(String args[])
	{
		int ar1[] = {1, 5, 9, 10, 15, 20};
	    int ar2[] = {2, 3, 8, 13};
	    int m = ar1.length;
	    int n = ar2.length;
	    mergeInversion(ar1, ar2, m, n);
	 
	    System.out.println("Frist array");
	    for (int i=0; i<m; i++)
	        System.out.print(ar1[i]+" ");
	    System.out.println(" ");
	    System.out.println("second array");
	    for (int i=0; i<n; i++)
	    	 System.out.print(ar2[i]+" ");
		
	}
	// Merge ar1[] and ar2[] with O(1) extra space
	static void mergeInversion(int ar1[], int ar2[], int m, int n)
	{
	    // Iterate through all elements of ar2[] starting from
	    // the last element
	    for (int i=n-1; i>=0; i--)
	    {
	        /* Find the smallest element greater than ar2[i]. Move all
	           elements one position ahead till the smallest greater
	           element is not found */
	        int j;
	        int last = ar1[m-1];
	        
	        for (j=m-2; j >= 0 && ar1[j] > ar2[i]; j--)
	            ar1[j+1] = ar1[j];
	 
	        // If there was a greater element
	        if (j != m-2 || last > ar2[i])
	        {
	            ar1[j+1] = ar2[i];
	            ar2[i] = last;
	        }
	    }
	}

}
