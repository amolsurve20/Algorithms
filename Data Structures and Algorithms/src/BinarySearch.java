/*
 *  find min of array that decrease then increase, like   [5,4,3,2,1,2,3,4,5] 
 */
public class BinarySearch 
{
	public static void main(String args[])
	{
		int arr[]={5,4,3,2,2,1,1,1,4,5};
		int res=binSearch(arr,0,arr.length);
		
		System.out.println(res);
	}
	
	public static int binSearch(int arr[], int s, int e)
	{
		if(arr.length==0)
			return -1;
		else
			if(arr.length==1)
				return arr[0];
			else
			{	
				int mid=(s+e)/2;
				
				if((arr[mid]<=arr[mid-1])&&(arr[mid]<=arr[mid+1]))
					return arr[mid];
				else
					
				if(arr[mid]<=arr[mid-1])
						
					return binSearch(arr,mid,e);
				else
							
					return binSearch(arr,s,mid+1);
			}
	}

}
