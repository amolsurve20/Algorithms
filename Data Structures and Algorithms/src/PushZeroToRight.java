
public class PushZeroToRight 
{
	public static void main(String args[])
	{
		int arr[]={1,2,6,4,0,0,7,0,8,0,55};
		int result[]=new int[arr.length];
		result=pushZero(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(result[i]+" ");
		}
	}
	
	public static int[] pushZero(int arr[])
	{
		int count=0;
		// Count of non-zero elements
		
		// Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)                       
				arr[count++]=arr[i];    
		}
		
		// here count is
        // incremented
// Now all non-zero elements have been shifted to
// front and 'count' is set as index of first 0.
// Make all elements 0 from count to end.
		
		while(count<arr.length)
		{
			arr[count++]=0;
		}
		return arr;
	}

}
