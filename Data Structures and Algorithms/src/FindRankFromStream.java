import java.util.*;
class RankNode
{
	RankNode left,right;
	int data;
	int leftSize=0;
	
	public RankNode(int d)
	{
		data=d;
	}
	
	public void insert(int d)
	{
		if(d<=data)
		{
			if(left!=null)
				left.insert(d);
			else
				left=new RankNode(d);
		}
		else
		{
			if(right!=null)
				right.insert(d);
			else
				right=new RankNode(d);
		}
	}
	
	public int getRank(int d)
	{
		if(d==data)
			return leftSize;
		else
			if(d<data)
			{
				if(left==null)
					return -1;
				else
					return left.getRank(d);
			}
			else
			{
				int rightIndex;
				if(right==null)
				{
					rightIndex=0;
				}
				else
				{
					rightIndex=right.getRank(d);
				}
				if(rightIndex==-1)
					return -1;
				else
					
				return leftSize+1+rightIndex;
			}
		
		
		
		
	}
}
public class FindRankFromStream {

}
