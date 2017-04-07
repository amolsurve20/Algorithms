
public class MergeArrays 
{
	public static void merge(int[] A, int[] B) 
	{
	      int i, j, k, m, n;
	      i = 0;
	      j = 0;
	      k = 0;
	      m = A.length;
	      n = B.length;
	      int C[]=new int[m+n];
	      while (i < m && j < n) 
	      {
	            if (A[i] < B[j]) 
	            {
	                  C[k] = A[i];
	                  i++;
	            } 
	            else  if (A[i] > B[j]) 
	            {
	                  C[k] = B[j];
	                  j++;
	            }
	            else
	            {
	            	j++;

	            }
	            k++;
	      }
	      
	      if (i < m) 
	      {
	            for (int p = i; p < m; p++) 
	            {
	                  C[k] = A[p];
	                  k++;
	            }
	      } 
	      else 
	      {
	            for (int p = j; p < n; p++) 
	            {
	                  C[k] = B[p];
	                  k++;
	            }
	      }
	      
	      for(int z=0;z<C.length;z++)
	      {
	    	  System.out.print(C[z]+" ");
	      }
	}
	
	public static void main(String args[])
	{
		int arr1[]={1,2,3,4,5};
		
		int arr2[]={1,2,3};
		
		
		
		merge(arr1,arr2);
	}

}
