


public class ListY 
{
	int search(Listy obj, int value)
	{
		int index=1;
		while((obj.elementAt(index)!=-1)&&(value<obj.elementAt(index)))
		{
			index=index*2;
		}
		
		return binarySearchNew(obj,value,low,high)
				
	}
	
	static int binarySearchNew(Listy obj,int value,int low, int high)
	{
		int mid;
		while(low<=high)
		{
			mid=(low+high)/2;
			
			int middle=elementAt(mid);
			
			if(middle>value||middle==-1)
			{
				high=mid-1;
			}
			else
				if(mid<value)
			{
				low=mid+1;
			}
				else
				{
					return mid;
				}
				
		}
		return -1;
	}
	

}
