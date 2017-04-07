class PrintMissingElement 
{
    // A O(n) function to print missing elements in an array
	/*
	 The idea is to use a boolean array of size 100 to keep track of array elements 
	 that lie in range 0 to 99. We first traverse input array and
	 mark such present elements in the boolean array.
	 Once all present elements are marked, 
	 the boolean array is used to print missing elements.
	 */
    void printMissing(int arr[], int n) 
    {
    	
        int LIMIT = 100;
        boolean seen[] = new boolean[LIMIT];
        
 
        // Initialize all number from 0 to 99 as NOT seen
        for (int i = 0; i < LIMIT; i++) 
            seen[i] = false;
        
        
 
        // Mark present elements in range [0-99] as seen
        for (int i = 0; i < n; i++) 
        {
            if (arr[i] < LIMIT)
                seen[arr[i]] = true;
        }
        
        
 
        // Print missing element
        int i = 0;
        while (i < LIMIT) 
        {
            // If i is missing
            if (seen[i] == false) 
            {
                // Find if there are more missing elements after i
                int j = i + 1;
                
                while (j < LIMIT && seen[j] == false)
                {
                    j++;
                }
                 
                // Print missing single or range
                int p = j-1;
                
                if(i+1==j)
                	System.out.println(i);
                else
                	System.out.println(i+ "-" + p);
 
                // Update i
                i = j;
            } 
            else
            {
                i++;
            }
        }
    }
 
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        PrintMissingElement missing = new PrintMissingElement();
        int arr[] = {88, 105, 3, 2, 200, 0, 10};
        int n = arr.length;
        missing.printMissing(arr, n);
    }
}