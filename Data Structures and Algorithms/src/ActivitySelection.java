/*
 Let us consider the Activity Selection problem as our first example of Greedy algorithms. Following is the problem statement.
You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
Example:

Consider the following 6 activities. 
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
The maximum set of activities that can be executed 
by a single person is {0, 1, 3, 4}
 */
public class ActivitySelection 
{
	public static void main(String args[])
	{
		int start[]  =  {1, 3, 0, 5, 8, 5};
	    int finish[] =  {2, 4, 6, 7, 9, 9};
	    
	    printMaxActivities(start,finish);
	}
	
	static void printMaxActivities(int s[],int e[])
	{
		System.out.println("Following activities can be performed");
		
		int i=0;
		
		System.out.print(i+" ");
		
		for(int j=1;j<e.length;j++)
		{
			if(s[j]>=e[i])
			{
				System.out.print(j);
				i=j; //Important to assign value of j to i. Incrementing i by one won't work.
			}
			System.out.print(" ");
			
		}
		
		
	}

}
