import java.util.ArrayList;

/*
Power Set
Power Set Power set P(S) of a set S is the set of all subsets of S. For example S = {a, b, c} 
then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.

If S has n elements in it then P(s) will have 2^n elements


Algorithm:

Input: Set[], set_size
1. Get the size of power set
    powet_set_size = pow(2, set_size)
2  Loop for counter from 0 to pow_set_size
     (a) Loop for i = 0 to set_size
          (i) If ith bit in counter is set
               Print ith element from set for this subset
     (b) Print seperator for subsets i.e., newline
Example:

Set  = [a,b,c]
power_set_size = pow(2, 3) = 8
Run for binary counter = 000 to 111

Value of Counter            Subset
    000                    -> Empty set
    001                    -> a
    011                    -> ab
   100                     -> c
   101                     -> ac
   110                     -> bc
   111                     -> abc
 
 */
public class PowerSet
{
	public static ArrayList<ArrayList<Character>> powerSet(char set[])
	{
		int setsize=set.length;
		int totalelements = (int)Math.pow(2, setsize);
		
		ArrayList<ArrayList<Character>>res=new ArrayList<ArrayList<Character>>();

		for(int i=0;i<totalelements;i++)
		{
			ArrayList<Character>each=new ArrayList<Character>();
			for(int j=0;j<setsize;j++)
			{
				 if((i & (1<<j))>0)	//Here checking for >0 is important rather than writing ==1 since these are int
					 //so bit is set when it's g
					 //greater than zero
				 {
					each.add(set[j]);
				 }
		
			}
		res.add(each);
			
		}
		return res;
	}
	public static void main(String srgs[])
	{
		ArrayList<ArrayList<Character>>result=new ArrayList<ArrayList<Character>>();
		char set[]={'a','b','c'};
		result=powerSet(set);
		for(ArrayList lst:result)
		{
			System.out.println(lst);
		}
	}

}
