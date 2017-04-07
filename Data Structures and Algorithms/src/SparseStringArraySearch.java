import java.util.*;
public class SparseStringArraySearch 
{
	static int search(String str[], String val,int first, int last)
	{
		if(first>last)
			return -1;
		
		int mid=(first+last)/2;
		
		if(str[mid].isEmpty())
		{
			int left=mid-1;
			int right=mid+1;
			
			while(true)
			{
			if(left<first&&right>last)
				return -1;
			else	
			if(left>=first && !str[left].isEmpty())
				{
					mid=left;
					break;
				}	
			else		
				if(right<=last && !str[right].isEmpty())
					{
						mid=right;
						break;
					}
			left--;
			right++;
			}
		
		}
		
		if(str[mid]==val)
			return mid;
		else
			if(str[mid].compareTo(val)<0)
				return search(str, val, mid+1,last);
			else
				return search(str,val,first,mid-1);
	}
	
	static int search(String[] strings,String val)
	{
		if(strings.length==0||strings==null||val==null)
			return -1;
		
		return search(strings,val,0,strings.length-1);
	}
	
	public static void main(String args[])
	{
		String arr[]={"AMol","","","Dinesh","Tarjun","","Zen"};
		String key="Zen"
				+ "";
		int res=search(arr,key);
		System.out.println(res);
	}

}
