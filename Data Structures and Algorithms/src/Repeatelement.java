
public class Repeatelement 
{
    void printRepeating(int arr[], int size) 
    {
        int count[] = new int[size];
        int i;
 
        System.out.println("Repeated elements are : ");
        for (i = 0; i < size; i++) 
        {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }
    }
    /*
     * Traverse the array. Do following for every index i of A[].
{
check for sign of A[abs(A[i])] ;
if positive then
   make it negative by   A[abs(A[i])]=-A[abs(A[i])];
else  // i.e., A[abs(A[i])] is negative
   this   element (ith element of list) is a repetition
}
Example: A[] =  {1, 1, 2, 3, 2}
i=0; 
Check sign of A[abs(A[0])] which is A[1].  A[1] is positive, so make it negative. 
Array now becomes {1, -1, 2, 3, 2}

i=1; 
Check sign of A[abs(A[1])] which is A[1].  A[1] is negative, so A[1] is a repetition.

i=2; 
Check sign of A[abs(A[2])] which is A[2].  A[2] is  positive, so make it negative. '
Array now becomes {1, -1, -2, 3, 2}

i=3; 
Check sign of A[abs(A[3])] which is A[3].  A[3] is  positive, so make it negative. 
Array now becomes {1, -1, -2, -3, 2}

i=4; 
Check sign of A[abs(A[4])] which is A[2].  A[2] is negative, so A[4] is a repetition.

     */
    void printRepeating1(int arr[], int size)
    {
        int i;  
        System.out.println("The repeating elements are : ");
    
        for(i = 0; i < size; i++)
        {
            if(arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }         
    } 
        
 
    public static void main(String[] args)
    {
        Repeatelement repeat = new Repeatelement();
        int arr[] = {1,2,3,4,5,5};
        int arr_size = arr.length;
        repeat.printRepeating(arr, arr_size);
        
        Repeatelement repeat1 = new Repeatelement();
        int arr1[] = {4, 2, 4, 5, 2, 3, 1};
        int arr1_size = arr1.length;
        repeat1.printRepeating(arr1, arr_size);
    }
}


