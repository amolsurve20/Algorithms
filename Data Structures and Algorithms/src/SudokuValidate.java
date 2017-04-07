import java.util.Arrays;
/*
 Short Explanation:

A Sudoku has three elements to validate. 
Each has to contain the single digit numbers from 1 to 9 exactly once.
These three elements are: each single row, each single column, the 9 3x3 sqares.
These elements are exactly mapped by the three variables you see in the for-loop.
Each of these elements is given to a validate function to verify, 
that it contains the numbers only once. Originally this was a golfed solution, 
so the square calculation is heavily algorithmic.
The validate function is quite simple. It initializes a counter to 0, 
and then walks the sorted "validated element" through, 
while always incrementing by 1. this gives the numbers from 1 to 9.
 In fact it is just a shortened for-loop, written a little different it's:
this one

for(int i = 1; i <= 9; i++){
    if(check[i-1] != i){
       return false;
    }
}
return true;
Longer Explanation

How I got to the algorithmic generation for the squares:

[(i / 3) * 3 + j / 3]      [i * 3 % 9 + j % 3]
(i / 3) * 3 + j / 3
This part is relatively simple. It gives the correct "column" 
by help of implicit integer conversion: The first part of the equation is a little difficult:

(i/3)(i/3)
0,1,2↦00,1,2↦0
3,4,5↦13,4,5↦1
6,7,8↦26,7,8↦2
take it * 3 and you got the score you want to get in to. 
then if we now iterate row-wise, we need to jump to 
the next column every 3 Elements. That's done with j / 3.

Now for the difficult one:

 i * 3 % 9 + j % 3
(i∗3%9)(i∗3%9)
0,3,6↦00,3,6↦0
1,4,7↦31,4,7↦3
2,5,8↦62,5,8↦6
This one is for "jumping" the scores vertically. 
Then we just have to iterate 0, 1, 2. 
This is accomplished by running the % 3 operation.
  
  
 */
public class SudokuValidate 
{
	static boolean checkSudoku(int arr[][])
	{
		for(int i=0;i<9;i++)
		{
			int row[]=new int[9];
			int square[]=new int[9];
			int column[]=arr[i].clone();
			
			for(int j=0;j<9;j++)
			{
				row[j]=arr[j][i];
				square[j]=arr[(i/3*3)+(j/3)][(i*3%9)+(j%3)];
			}
			
			if(!(validate(row)&&validate(column)&&validate(square)))
				return false;
		}
		return true;
		
	}
	
	static boolean validate(int arr[])
	{
		Arrays.sort(arr);
		for(int i=1;i<=9;i++)
		{
			if(arr[i-1]!=i)
				return false;
		}
		return true;
	
	}
	
	public static void main(String args[])
	{
		int[][] matrix={

                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
            };
		
		boolean res=checkSudoku(matrix);
		
		System.out.print(res);
		
	}

}
