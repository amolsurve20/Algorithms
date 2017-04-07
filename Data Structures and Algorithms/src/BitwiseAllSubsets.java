import java.util.*;
public class BitwiseAllSubsets 
{
	public static void main(String args[])
	{
		List<Object>list=new ArrayList<Object>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		System.out.println(getBitwiseSubsets(list));
		
	}
	
	public static Set<Set<Object>>getBitwiseSubsets(List<Object>list)
	{
		
		int subsets=(int)Math.pow(2, list.size());
		
		Set<Set<Object>>result=new HashSet<Set<Object>>();
		
		for(int i=0;i<subsets;i++)
		{
			Set<Object>temp=new HashSet<Object>();
			
			int mask=1;
			
			for(int j=0;j<list.size();j++)
			{
				if((mask&i)!=0)
				{
					temp.add(list.get(j));
				}
				
				mask=mask<<1;
			}
			
			result.add(temp);		
			
		}
		return result;
		
	}

}

/*
 * Bit Manipulation Approach

In this approach we will use Bits Manipulation for printing Subset of a set.

Before going ahead, first lets understand how to check any bit is set in a byte. 
Binary representation of a number 1 = 0001, 2 = 0010, ...., 5 = 0101, ....

How to identify whether LSB, that is bit at position 0 is set in 5(0101)?
Solution:

         
         Do a Logical AND of 1 and 5 that is (0001 & 0101).
         If the result is greater than 0, then LSB, that is bit at position 0 is set in value 5.

How to identify whether bit at position 1 is set in 5(0101)?
Solution: 
         Do a Logical AND of 2 and 5 that is (0010 & 0101).
         If the result is greater than 0, then bit at position 1 is set


So, to generalize it, if we want to check nth bit is set in a number, 
Step 1.  We will first take binary representation of 1 (0001), 
Step 2.  Move the LSB in binary representation of 1 to nth position.
              Eg: If we want to check whether bit at position 2 is set,  
              then move 1 two times on right side,
               = 1 << 2  
               =  0001 << 2  
               =  0100
Step 3. Once the LSB of binary 1 is moved to nth position, which we want to check, 
             just do logical AND of binary representation of 1 with the number,
             If the result is greater than 0, then the bit is set, not otherwise.


If we want to find subset of 3 characters [a, b, c], then how many total subset can be made out of it?
If you observe, the number of subsets equals to 2 to the power of the number of elements in the set.
Number of subsets that can be made from set of 3 characters [a, b, c] is 2^3 = 8 subsets.
Number of subsets that can be made from set of 4 characters [a, b, c, d] is 2^4 = 16 subsets.
So, If there are n characters [a, b, c.... n] in a set, then there will be 2^n total subsets.


How to find total number of subsets possible using bit manipulation?
By shifting the bit representation of the number 1 by n, we will get 2^n. 
Thus, if we shift the bit string of 1 by the number of elements in the given set, 
we'll get the number of subsets for that set. 

For example, if we have S = [a, b, c], length of set here is 3, 
So, for finding total subsets, we have to shift binary 1, 3 times, 
1 << 3 = (0001 << 3) = (1000) = 2^3 = 8 subsets of set S.   

If we compare subset of [a, b, c] to binaries representation of numbers from 0 to 7, 
we can find a relation with the bit sets in each number to subsets of [a, b, c].





 * 
 * 
 * */
