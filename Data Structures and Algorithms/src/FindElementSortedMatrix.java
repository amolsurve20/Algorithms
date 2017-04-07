import java.util.*;
public class FindElementSortedMatrix 
{
	static boolean  findElement(int matrix[][],int elem)
	{
		int row=0;
		int col=matrix[0].length-1;
		
		while(row<matrix.length&&col>=0)
		{
			if(matrix[row][col]==elem)
				return true;
			else
				if(matrix[row][col]>elem)
					col--;
				else
					row++;
		}
		return false;
	}
	
	public static void main(String args[])
	{
		int matrix[][]={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		      };
		
		boolean res=findElement(matrix,16);
		
		System.out.println(res);
		
		
	}

}
