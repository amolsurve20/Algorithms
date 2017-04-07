class Array
{
	private int arr[];
	private int nelem;
	
	public Array(int max)
	{
		arr=new int[max];
		nelem=0;
	}
	
	public void insert(int element)
	{
		arr[nelem++]=element;
	}
	
	public void display()
	{
		for(int i=0;i<nelem;i++)
			
			System.out.print(arr[i]+" ");
	}
	
	private void swap(int one, int two)
	{
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}
	
	public void bubbleSort()
	{
		
		for(int i=nelem-1;i>0;i--)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					swap(j,j+1);
				}
				
			}
		}
	}
	
	/*
	 * The selection sort improves on the bubble sort by reducing the number of swaps
necessary from O(N2) to O(N). Unfortunately, the number of comparisons remains
O(N2). However, the selection sort can still offer a significant improvement for large
records that must be physically moved around in memory, causing the swap time to
be much more important than the comparison time.
*/
	 
	public void selectionSort()
	{
		for(int i=0;i<nelem-1;i++)
		{
			int min=i;
			for(int j=i+1;j<nelem;j++)
			{
				if(arr[j]<arr[min])
				{
					min=j;
				}
				swap(i,min);
			}
		}
	}
	
	
	
}
public class ArraySorts 
{
	public static void main(String args[])
	{
		Array obj=new Array(5);
		obj.insert(10);
		obj.insert(60);
		obj.insert(30);
		obj.insert(5);
		
		obj.display();
		
		obj.selectionSort();
		
		System.out.println("After Bubble Sort, the array looks like:");
		
		obj.display();
	}

}
