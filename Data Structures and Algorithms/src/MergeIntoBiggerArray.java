import java.util.*;

public class MergeIntoBiggerArray 
{
	public static void merge(int a[],int b[], int lastA, int lastB)
	{
		//index of last element of array A
		int indexA=lastA-1;
		
		//index of last element of array B
		int indexB=lastB-1;
		
		//index of the last element of merged array
		int indexMerged=lastA+lastB-1;
		
		while(indexB>=0)
		{
			if(indexA>=0 && a[indexA]>b[indexB])
			{
				a[indexMerged]=a[indexA];
				indexA--;
			}
			else
			{
				a[indexMerged]=b[indexB];
				indexB--;
			}
			indexMerged--;	
		}
		
	}
	
	public static void main(String args[])
	{
		int a[]=new int[20];
		a[0]=21;
		a[1]=32;
		a[2]=34;
		a[3]=36;
		
		
		int b[]={2,5,45};
		
		merge(a,b,4,3);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}

}
