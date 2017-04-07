import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


 */
class Interval 
{
	      int start;
	      int end;
	      
	     Interval() 
	     { 
	    	 start = 0; 
	    	 end = 0; 
	     }
	     Interval(int s, int e) 
	     { 
	    	 start = s; 
	    	 end = e; 
	     }
	 }

class IComparator implements Comparator<Interval>
{
	public int compare(Interval i1, Interval i2)
	{
		if(i1.start<=i2.start)
			return -1;
		else
			return 1;
	}
}

public class MergeIntervals 
{
	public List<Interval> merge(List<Interval> intervals)
	{
		List<Interval>result=new ArrayList<Interval>();
		
		if(intervals==null||intervals.size()==0)//if no element, return newly created empty arraylist
			return result;
		
		Interval pre=intervals.get(0);
		
		for(int i=1;i<intervals.size();i++)
		{
			Interval curr=intervals.get(i);
			if(curr.start>=pre.end)//>=is very important for two adjacent intervals
			{
				result.add(pre);
				pre=curr;
			}
			else
			{
				Interval merged=new Interval(pre.start,Math.max(curr.end,pre.end));
				pre=merged;
			}
		}
			
			result.add(pre);		
			
			return result;	
	}	
	/*
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
	public List<Interval>insertInterval(List<Interval>lst,Interval newInterval)
	{
		List<Interval>result=new ArrayList<Interval>();
		
		for(Interval interval:lst)
		{
			if(interval.end<newInterval.start)
				result.add(interval);
			else
				if(interval.start>newInterval.end)
					result.add(interval);
				else
					if(interval.end>=newInterval.start&&interval.start<=newInterval.end)
					{	
			//create new interval with the updated values of start and end			
            newInterval=new Interval(Math.min(interval.start, newInterval.start),
		                             Math.max(interval.end, newInterval.end));
					}
		}
		result.add(newInterval);
		//Add new interval at the end of the iteration
		return result;
		
	}

	public static void main(String args[])
	{
		List<Interval>input=new ArrayList<Interval>();
		
		Interval i1=new Interval(1,2);
		Interval i2=new Interval(3,5);
		Interval i3=new Interval(6,7);
		Interval i4=new Interval(8,10);
		Interval i5=new Interval(12,16);
		

		input.add(i1);
		input.add(i2);
		input.add(i3);
		input.add(i4);
		input.add(i5);

		//List<Interval>lst=new ArrayList<Interval>();
		
		MergeIntervals obj=new MergeIntervals();
		//lst=obj.merge(input);
		
		
		
		Interval i6=new Interval(4,9);
		List<Interval>lst1=new ArrayList<Interval>();
		lst1=obj.insertInterval(input,i6);
		
		
		for(int i=0;i<lst1.size();i++)
		{
			System.out.println(lst1.get(i).start+" "+lst1.get(i).end);
		}
	}
}
			

		
		
		
		
		
		
		
				
				
	


