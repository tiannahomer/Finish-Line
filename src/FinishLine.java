import java.util.Scanner;

public class FinishLine
{
	public static void main ( String args[] )
	{
		
		Player player1, player2; // player1 and player2 objects
		
		
		Scanner keyboard = new Scanner(System.in);
		
		// ask user which board they want
		System.out.println("Do you want the standard board or customised board? ");
		System.out.println("1. Standard");
		System.out.println("2. Customised"); 
		int choice = (keyboard.nextInt()); 
		
		GameBoard board = null;
		if (choice == 1)
		{
			// create instance of GameBoard called board for standard gameBoard
			board = new GameBoard();
		}
		else if (choice == 2)
		{
			// asks and accepts from user the information for customised gameboard
			System.out.println("Enter how many rows you want for the game board (min 6, max 9 rows): ");
			int nRows = keyboard.nextInt();
			
			System.out.println("Enter how many columns you want for the game board (min 12, max 15 columns): ");
			int nCols = keyboard.nextInt();	
			
			System.out.println("Enter how many prizes you want for the game board (min 3, max 6 prizes): ");
			int nPrizes = keyboard.nextInt();
			
			System.out.println("Enter how many obstacles you want for the game board (min 3, max 9 obstacles): ");
			int nObstacles = keyboard.nextInt();
			
			if ( (nRows >= 6 && nRows <= 9) && (nCols >= 12 && nCols <=15) && 
					(nPrizes <= 6 && nPrizes >= 3) && (nObstacles >= 3 && nObstacles <= 9) )
			{
				// create instance of GameBoard called board for customised gameBoard
				board = new GameBoard(nRows, nCols, nObstacles, nPrizes);
			}
			else {
				System.out.println("Invalid choice entered. Please enter correct choice! The game has not created.");
				System.exit(-1);
			}
				
				
		}
		else {
			System.out.println("Invalid choice entered. Please enter correct choice! The game has not created.");
			System.exit(-1);
		}
				
		
		// get name of each player and create Player objects
		System.out.println ("Enter player 1 name: ");
		String name1 = keyboard.next();
		player1 = new Player(name1);
		player1.setName(name1);
		
		System.out.println ("Enter player 2 name: ");
		String name2 = keyboard.next();
		player2 = new Player(name2);
		player2.setName(name2);
		
		
		
		// call populateBoard() function
		GameBoard.populateBoard();
		board.placePlayerPieces(player1, player2);
		GameBoard.displayBoard();
		
		int numberOfSkip1 = 0;
		int numberOfSkip2 = 0;
		
		// loop that repeats while neither player has all of their pieces at the FINISH
		while(!(player1.isPieceFinished(1) && player1.isPieceFinished(2) && player1.isPieceFinished(3)) && 
			  !(player2.isPieceFinished(1) && player2.isPieceFinished(2) && player2.isPieceFinished(3))) {
			
			
			
			if(!player1.getLoseTurn()) {
				System.out.println("\n\nPlayer " + player1.getName() + ", your turn now!"); //lets player 1 know it's their turn
				board.runPlayerTurn(player1); // call runPlayerTurn for player 1
				GameBoard.displayBoard();
			}
			else {
				numberOfSkip1++;
			}
			
			if(!player2.getLoseTurn()) {
				System.out.println("\n\nPlayer " + player2.getName() + ", your turn now!"); //lets player 2 know it's their turn
				board.runPlayerTurn(player2); // call runPlayerTurn for player 2
				GameBoard.displayBoard();
			}
			else {
				numberOfSkip2++;
			}
			
			if(numberOfSkip1 == 1) {
				numberOfSkip1 = 0;
				player1.setLoseTurn(false);
			}
			
			if(numberOfSkip2 == 1) {
				numberOfSkip2 = 0;
				player2.setLoseTurn(false);
			}
			
			
			
			// display player status
			//int numOut = 0;
			System.out.println();
			System.out.println("\nPLAYER STATUS");
			System.out.println(player1.getName() + ": " + player1.getNumFinish() + " at Finish; " + (3 - player1.getNumFinish()) + " in play");
			System.out.println(player2.getName() + ": " + player2.getNumFinish() + " at Finish; " + (3 - player1.getNumFinish()) + " in play");
		}
		
		keyboard.close();
	} // main
	
} // FinishLine