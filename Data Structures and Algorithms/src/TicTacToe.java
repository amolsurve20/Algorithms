
public class TicTacToe 
{
	private char board[][];
	private char player;
	
	public TicTacToe()
	{
		board=new char[3][3];
		player='x';
		initializeBoard();	
	}
	
	public void initializeBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]='-';
			}
		}
	}
	
	public void printBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			
			System.out.println(" ");		
		}
	}
	
	public boolean isFull()
	{
		boolean isFull=true;
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]=='-')
				{
					isFull=false;
				}
			}
		}
		return isFull;	
	}
	
	public boolean checkForWin()
	{
		return (rowWin()||colWin()||diagWin());		
	}
	
	public boolean checkVal(char c1,char c2, char c3)
	{
		return ((c1!='-') && (c1==c2) && (c1==c3));
	}
	
	public boolean rowWin()
	{
		for(int i=0;i<3;i++)
		{
		if(checkVal(board[0][i],board[1][i],board[2][i])==true)
			return true;
		}
		return false;	
	}
	
	public boolean colWin()
	{
		for(int i=0;i<3;i++)
		{
		if(checkVal(board[i][0],board[i][1],board[i][2])==true)
			return true;
		}
		return false;	
	}
	
	public boolean diagWin()
	{
		for(int i=0;i<3;i++)
		{
		if((checkVal(board[0][0],board[1][1],board[2][2])==true)||(checkVal(board[0][2],board[1][1],board[2][0])==true))
			return true;
		}
		return false;	
	}
	
	public void changePlayer()
	{
		if(player=='x')
			player='y';
		else
			player='x';
	}
	
	public boolean placeMarker(int row,int col)
	{
		if(row>=0&&row<3)
		{
			if(col>=0&&col<3)
			{
				if(board[row][col]!='-')
					board[row][col]=player;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		TicTacToe game=new TicTacToe();
		game.placeMarker(0,2);
		
		// Lets print the board
	
		game.printBoard();
		
		// Did we have a winner?
		
		if (game.checkForWin()) {
		
		   System.out.println("We have a winner! Congrats!");
		
		   System.exit(0);
		
		}
		
		else 
			if (game.isFull()) 
		{
		
		   System.out.println("Appears we have a draw!");
		   System.exit(0);
		
		}
			else
			{
			
		
		// No winner or draw, switch players to 'o'

		game.changePlayer();

		// Repeat steps again for placing mark and checking game status...
			}
	}
	
	

}
