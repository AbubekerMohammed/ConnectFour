import java.util.Scanner;

public class ConnectFour 
{
	static Scanner input = new Scanner(System.in);
	static final int rows = 6, cols = 7;
	static char[][] board = new char[rows][cols];

	public static void main(String[] args) 
	{

		initialize(board);

		int count = 1;
		char color = 'Y';
		boolean winner = false;
		
		

		while (winner == false && count <= 6 * 7) 
		{
			// We have 6 rows and 7 columns so the total items will be 6*7=42
			boolean colIsFull = true;
			int col;
			
		
			displayBoard(board);

			col = input.nextInt();
			
			if(colIsFull == columnIsFull(board, col))
			{
				
				continue;
			}
			
			
			
			
			// This loop will drop the disk
			for (int row = 0; row < board.length; row++) 
			{
				if (board[row][col] == ' ') 
				{
					board[row][col] = color;
					break;
				}
			}
			
			winner = isWinner(board);

			// This statement will swap turns between Y and R every time the game is played
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
			if (color == 'Y') 
			{
				// If there is a winner during Y's turn, the winner is R since it took the last move
				System.out.println("R has WON the game!");
				System.out.println("DO YOU WANT TO PLAY A NEW GAME? (type 1 for yes)");
				int userInput = input.nextInt();
				if (userInput == 1) 
				{
					clearBoard();
				}
			} 
			else 
			{
				// If there is a winner during R's turn, the winner is Y since it took the last move
				System.out.println("Y has WON the game!");
				System.out.println("DO YOU WANT TO PLAY A NEW GAME? (type 1 for yes)");
				int userInput = input.nextInt();
				if (userInput == 1) 
				{
					clearBoard();

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
		for (int i = board.length - 1; i >= 0; i--) 
		{
			System.out.print("| ");
			for (int j = 0; j < board[i].length; j++) 
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();// new line
		}
	}

	public static void initialize(char[][] board) 
	{
		// This method will initialize the array by setting it to the space in the 6th
		// row and 1st column
		for (int row = 0; row < board.length; row++) 
		{
			for (int col = 0; col < board[0].length; col++) 
			{
				board[row][col] = ' ';
			}
		}
	}

	public static boolean columnIsFull(char[][] board, int colValue) 
	{
		boolean isColumnFull = false;
		// This statement will check if the column is valid and is in bound
		if (colValue < 0 || colValue > 6 || board[5][colValue] != ' ' ) 
		{
			System.out.println("YOU ENTERED AN INVALID INTEGER OR THE COLUMN IS FULL.");
			isColumnFull = true;
			
		} 
		else 
		{
			return isColumnFull;
		}
		
		return isColumnFull;
	}

	public static boolean isWinner(char[][] board) 
	{
		// This loop will check if there's a winner horizontally across the board
		for (int i = 0; i < board.length; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				if (board[i][j] != ' ' && board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2]
						&& board[i][j + 2] == board[i][j + 3]) 
				{
					return true;
				}
			}
		}

		// This loop will check if there's a winner vertically along the board
		for (int i = 0; i < board[0].length - 4; i++) 
		{
			for (int j = 0; j < board[0].length - 4; j++) 
			{
				if (board[i][j] != ' ' && board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j]
						&& board[i + 2][j] == board[i + 3][j]) 
				{
					return true;
				}
			}
		}

		// This loop will check if there's a winner diagonally up the board
		for (int i = 3; i < board.length; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				if (board[i][j] != ' ' && board[i][j] == board[i - 1][j + 1]
						&& board[i - 1][j + 1] == board[i - 2][j + 2] && board[i - 2][j + 2] == board[i - 3][j + 3]) {
					return true;
				}
			}
		}

		// This loop will check if there's a winner diagonally down the board
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				if (board[i][j] != ' ' && board[i][j] == board[i + 1][j + 1]
						&& board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]) {
					return true;
				}
			}
		}

		return false;
	}

	public static void clearBoard() 
	{
		// This method will clear the board, which means it will assign every array to ' '
		for (int row = 0; row < board.length; row++) 
		{
			for (int col = 0; col < board[row].length; col++) 
			{
				board[row][col] = ' ';
			}
		}

		main(null); //This will call the main method so that our code will run again
	}

}

















