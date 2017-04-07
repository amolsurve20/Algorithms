import java.util.*;
public class PeaksValleyLocalMinimaMaxima 
{
	static void sortValley(int array[])
	{
		for(int i=1;i<array.length;i=i+2)
		{
			int biggest=biggestIndex(array,i-1,i,i+1);
			if(i!=biggest)
			{
				swap(array,i,biggest);
			}
		}
	}
	
	static void swap(int array[],int a, int b)
	{
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	static int biggestIndex(int array[],int a,int b,int c)
	{
		int len=array.length;
		
		int aValue=a>=0 && a<len?array[a]:Integer.MIN_VALUE;
		int bValue=b>=0 && b<len?array[b]:Integer.MIN_VALUE;
		int cValue=c>=0 && c<len?array[c]:Integer.MIN_VALUE;
		
		int biggest=Math.max(aValue, Math.max(bValue, cValue));
		
		if(biggest==aValue)
			return a;
		else	
		if(biggest==bValue)
			return b;
		else 
			return c;
		
	}
	
	public static void main(String args[])
	{
		int arr[]={9,1,0,4,8,7,11,2,3};
		sortValley(arr);
		System.out.println("Sorted array for peaks and valleys is as follow:");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}
