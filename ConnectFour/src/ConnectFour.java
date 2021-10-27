import java.util.Scanner;
public class ConnectFour 
{
		static Scanner input = new Scanner(System.in);
		static char[][] board = new char[6][7];
		public static void main(String[] args) 
		{

		initialize(board);

		int count = 1;
		char color = 'Y';
		boolean winner = false;		

	
		while (winner == false && count <= 6*7)
		{
			boolean colIsFull;
			int col;
			do 
			{
				displayBoard(board);

				col = input.nextInt();
				colIsFull = columnIsFull(board, col);
				if(colIsFull == true)
				{
					System.out.println("YOU ENTERED AN INVALID INTEGER OR THE COLUMN IS FULL.0");
					
				}

			}
			while (colIsFull == false);

			//drop the checker
			for (int row = board.length-1; row >= 0; row--)
			{
				if(board[row][col] == ' ')
				{
					board[row][col] = color;
					break;
				}
			}

			winner = isWinner(board);

			if (color == 'Y')
			{
				color = 'R';
			}
			else
			{
				color = 'Y';
			}

			count++;			
		}
		displayBoard(board);

		if (winner)
		{
			if (color=='Y')
			{
				System.out.println("Y has WON the game!");
				System.out.println("DO YOU WANT TO PLAY A NEW GAME? (type 1 for yes)");
				int userInput = input.nextInt();
				if (userInput == 1)
				{
					clearBoard();
					count = 1;
					
				}
			}
			else{
				System.out.println("R has WON the game!");
				System.out.println("DO YOU WANT TO PLAY A NEW GAME? (type 1 for yes)");
				int userInput = input.nextInt();
				if (userInput == 1)
				{
					clearBoard();
					count = 1;
					
				}
			}
		}
		else
		{
			System.out.println("I declare a draw");
		}
		

		
	}

	private static void displayBoard(char[][] board) 
	{
		for(int i = board.length - 1; i >= 0; i--)
		{
			System.out.print("| ");
			for(int j = 0; j <board[i].length; j++)
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();//new line
		}
		
	}
	
	//This method will initialize the array by setting it to the space in the 6th row and 1st column
	public static void initialize(char[][] board) 
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				board[row][col] = ' ';
			}
		}
		
	}
	public static boolean columnIsFull(char[][] board, int col)
	{
		//valid column?
		if (col < 0 || col > board[0].length)
		{
			return false;
		}

		//full column
		if (board[0][col] != ' ')
		{
			return false;
		}

		return true;
	}

	public static boolean isWinner(char[][] board)
	{
		//boolean across= false;
				for(int i = 0; i < board.length; i++)
				{
					for (int j = 0; j < 3;j++)
					{
						if (board[i][j] != ' ' && board[i][j] == board[i][j+1]  && board[i][j+1] == board[i][j+2] && board[i][j+2] == board[i][j+3])
						{
							//across = true;
							return true;
						}
					}			
				}
				
				//boolean upDown= false;
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < board[0].length; j++)
					{
						if (board[i][j] != ' ' && board[i][j] == board[i+1][j] && board[i+1][j] == board[i+2][j] && board[i+2][j] == board[i+3][j])
						{
							//upDown = true;
							return true;
						}
					}
				}
				
				//boolean diagonalUp = false;
				for(int i = 3; i < board.length; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						if (board[i][j] != ' ' && board[i][j] == board[i-1][j+1] && board[i-1][j+1] == board[i-2][j+2] && board[i-2][j+2] == board[i-3][j+3])
						{
							//diagonalUp = true;
							return true;
						}
					}
				}
				
				//boolean diagonalDown = false;
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						if (board[i][j] != ' ' && board[i][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+2][j+2] && board[i+2][j+2] == board[i+3][j+3])
						{
							//diagonalDown = true;
							return true;
						}
					}
				}
				
				//if(across == true || upDown == true || diagonalUp == true || diagonalDown == true)
				//{
					//return true;
				//}
				return false;
	}
	
	//This method will clear the board, which means it will assign every array to ' '
	public static void clearBoard()
	{
        for (int row = 0; row < board.length; row++ ) 
        {
            for (int col = 0; col < board[row].length; col++) 
            {
                    board[row][col] = ' ';   
                }
            }
        }
	
}