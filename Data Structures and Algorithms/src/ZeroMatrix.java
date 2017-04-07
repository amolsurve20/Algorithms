
public class ZeroMatrix 
{
	public static void main(String args[])
	{
		int arr[][]=new int[][]
				{
				{1,2,0,3},
				{1,2,3,4},
				{2,3,4,5},
				{2,3,4,6},
				{0,2,0,3}
				};
				
		setZeroes(arr);		
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]);
				
			}
			System.out.println(" ");
		}
	}
	
	public static void setZeroes(int matrix[][])
	{
		boolean rowZero=false,colZero=false;
		
		for(int i=0;i<matrix[0].length;i++)
		{
			if(matrix[0][i]==0)
			{
				rowZero=true;
			break;
			}
		}
		
		for(int i=0;i<matrix.length;i++)
		{
			if(matrix[i][0]==0)
			{
				colZero=true;
			break;
			}
		}
		
		for(int i=1;i<matrix.length;i++)
		{
			for(int j=1;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		for(int i=1;i<matrix.length;i++)
		{
			if(matrix[i][0]==0)
				nullifyRow(matrix,i);
		}
		
		for(int i=1;i<matrix[0].length;i++)
		{
			if(matrix[0][i]==0)
				nullifyColumn(matrix,i);
		}
		
		if (colZero==true)
			nullifyColumn(matrix,0);
		
		if(rowZero==true)
			nullifyRow(matrix,0);
		
	}
	
	public static void nullifyRow(int matrix[][],int row)
	{
		for(int i=0;i<matrix[0].length;i++)
			matrix[row][i]=0;	
		
	}
	
	public static void nullifyColumn(int matrix[][],int col)
	{
		for(int i=0;i<matrix.length;i++)
			matrix[i][col]=0;	
		
	}

}
