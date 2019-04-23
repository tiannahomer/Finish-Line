import java.util.Random;
import java.util.Scanner;

public class GameBoard 
{

	// data members
	static int numRows = 6; // no. of rows on gameBoard
	static int numCols = 18; // no. of cols on gameBoard
	static BoardItem[][] gameBoard = new BoardItem[numRows][numCols]; // 2-d array holding creature objects
	static int numObstacles; // no. of obstacles currently on the board
	static int numPrizes; // no. of prizes currently on the board
	
		
	// constructor for standard gameboard
	GameBoard ()
	{
		numRows = 6;
		numCols = 18;
		numObstacles = 6;
		numPrizes = 3;
		gameBoard = new BoardItem [numRows] [numCols];
	} // GameBoard()
	
	
		
	// constructor for customized gameboard
	public GameBoard (int nRows, int nCols, int nObstacles, int nPrizes)
	{
		numRows = nRows;
		numCols = nCols;
		numObstacles = nObstacles;
		numPrizes = nPrizes;
		gameBoard = new BoardItem [nRows][nCols];	
	} // GameBoard
	
	
	
	// populate gameBoard with prizes and obstacles	
	static void populateBoard()
	{
		//Prize prize1 = new Prize();
		//Obstacle obstacle1 = new Obstacle();
		
		// call addBoardGame method to place prize and obstacle on gameboard
		addBoardItem(new Prize());
		addBoardItem(new Obstacle());
			
	} //populateBoard
		
	
	
	// adds item to the game board
	static void addBoardItem(BoardItem item)
	{
		// randomly generate coordinates until an empty board cell is found
		Random randCoordinates = new Random();
		
		int rowPos;
		int colPos;
		
		// if item is an object of the Prize class 
		if(item instanceof Prize) 
		{				
			for (int i = 0; i < numPrizes; i++) 
			{
				do 
				{
					rowPos = randCoordinates.nextInt(numRows);
					colPos = randCoordinates.nextInt(numCols - 2) + 1;
				}
				while (gameBoard[rowPos][colPos] != null);
				
				// place item on board
				gameBoard[rowPos][colPos] = item;
	
			}
		}
		
		// if item is an object of the Obstacle class 
		if(item instanceof Obstacle) 
		{ 				
			for (int i = 0; i < numObstacles; i++) 
			{
				do 
				{
					rowPos = randCoordinates.nextInt(numRows);
					colPos = randCoordinates.nextInt(numCols - 2) + 1;
				}
				while (gameBoard[rowPos][colPos] != null); 
					
				// place item on board
				gameBoard[rowPos][colPos] = item;
						
				
			}
		}
		
		// if item is an object of the Stepper class
		if (item instanceof Stepper) 
		{
			do
			{
				rowPos = randCoordinates.nextInt(numRows);
			}
			while (gameBoard[rowPos][0] != null);
		
			// assign crisscrosser player piece to gameboard
			gameBoard[rowPos][0] = item; 
			((Stepper) item).setLocation(rowPos, 0);			
			
		}
		
		// if item is an object of the Bumper class
		if (item instanceof Bumper) 
		{
			do 
			{
				rowPos = randCoordinates.nextInt(numRows);
			}
			while (gameBoard[rowPos][0] != null);
		
			// assign bumper player piece to gameboard
			gameBoard[rowPos][0] = item; 
			((Bumper) item).setLocation(rowPos, 0);
				
		}
		
		// if item is an object of the Crisscrosser class
		if (item instanceof Crisscrosser) 
		{
			do 
			{
				rowPos = randCoordinates.nextInt(numRows);
			}
			while (gameBoard[rowPos][0] != null);
		
			// assign crisscrosser player piece to gameboard
			gameBoard[rowPos][0] = item;
			((Crisscrosser) item).setLocation(rowPos, 0);
		}	
									
} // addBoardItem
			
		
	// removes prize at position indicated by row and col
	boolean removePrize (int row, int col)
	{
		if (gameBoard[row][col] != null && gameBoard[row][col].getSymbol() == 'P') 
		{
			gameBoard[row][col].setSymbol(' '); // remove prize from gameBoard
			numPrizes--; //decrement the value of numPrizes
			return true;
		}
		return false;
	} //removePrize
	
	
	// displays the game board	
	static void displayBoard()
	{
		System.out.println("  | S | > | > | > | > | > | > | > | > | > | > | > | > | > | > | > | > | H ");
		System.out.println("---------------------------------------------------------------------------");
		for (int r = 0; r < numRows; r++)
		{
			System.out.print(r+1 + " | ");

			for (int c = 0; c < numCols; c++)
			{

				if (gameBoard[r][c] != null)
				{
					System.out.print(gameBoard[r][c].getSymbol() + " | ");
				}
				else 
				{
					System.out.print(" " + " | ");
				} // end if

			} // end for cols
				System.out.println();
				System.out.println("---------------------------------------------------------------------------");
			} // end for rows

		

			System.out.println("Prizes remaining on board: " + numPrizes);
	} // displayBoard
	
	
	public void placePlayerPieces(Player p1, Player p2)
	{
		//create 3 pieces for Player 1 using UPPERCASE symbols
		Stepper s1 = new Stepper('S');
		Crisscrosser c1 = new Crisscrosser('C');
		Bumper b1 = new Bumper('B');
		
		
		//insert code to add these pieces to player 1
		p1.setPieces(s1, c1, b1);
		
		//insert code to add each piece to the board.
		addBoardItem(s1);
		addBoardItem(c1);
		addBoardItem(b1);
		
		//create 3 pieces for Player 2 using lowercase symbols
		Stepper s2 = new Stepper('s');
		Crisscrosser c2 = new Crisscrosser('c');
		Bumper b2 = new Bumper('b');
		
		//insert code to add these pieces to player 2
		p2.setPieces(s2, c2, b2);
	
		//insert code to add each piece to the board.
		addBoardItem(s2);
		addBoardItem(c2);
		addBoardItem(b2);
	}//placePlayerPieces

	// displays a message with the appropriate command instructions
	// for moving the player piece indicated via the piece parameter,
	// where 1 = stepper, 2 = crisscrosser. 3 = bumper.
	public void displayMovementOptions(int piece) {
		

		switch (piece) {
		case 1:
			System.out.println("\n1. north");
			System.out.println("2. south");
			System.out.println("3. east");
			System.out.println("4. west");
			break;
		case 2:
			System.out.println("\n5. northeast");
			System.out.println("6. southeast");
			System.out.println("7. northwest");
			System.out.println("8. southwest");
			break;
		case 3:
			System.out.println("\n1. north");
			System.out.println("2. south");
			System.out.println("3. east");
			System.out.println("4. west");
			System.out.println("5. northeast");
			System.out.println("6. southeast");
			System.out.println("7. northwest");
			System.out.println("8. southwest");
			break;
		}
	}// displayMovementOptions
	
	boolean validateMove(int row, int col) throws OffBoardException, CollisionException
	{
		//If the destination is off the edge of the board,
		//throw an OffBoardException exception with the message "Re-enter or die!"
		if(row >= numRows || row < 0 || col >= numCols || col < 0) {
			throw new OffBoardException("Re-enter or die!");
		}
			
		
		//If the destination contains an Obstacle,
		//throw a CollisionException exception with the message “Obstacle at destination”.
		if(gameBoard[row][col] instanceof Obstacle)
			throw new CollisionException("Obstacle at destination");
		
		//If the destination contains a player piece,
		//throw a CollisionException exception with the message “Piece at destination”.
		if(gameBoard[row][col] instanceof PlayerItem)
			throw new CollisionException("Piece at destination");
		
		//Otherwise, this is a valid move.
		return true;
	}//validateMove
	
	public void runPlayerTurn(Player p)
	{
		//display instructions for selecting piece to move
		//instructions should only be displayed for pieces which are NOT FINISHED.
		//RECALL: 1 = stepper, 2 = crisscrosser. 3 = bumper.
		Scanner in = new Scanner(System.in);
		
		//the pieces for a turn of the game
		Stepper stepper = null;						
		Crisscrosser crisscrosser = null;
		Bumper bumper = null;
		
		int choice;
		int direction;
		Random rand = new Random();
		while(true) {
			// print the menu
			System.out.println("\n1. Stepper");
			System.out.println("2. Crisscrosser");
			System.out.println("3. Bumper");
			System.out.print("\nSelect a piece to move: ");
			choice = in.nextInt();
			in.nextLine();
			
			if(choice == 1 || choice == 2 || choice == 3) 
			{ // if input is valid
				switch (choice) 
				{	// to do the appropriate turn of the game
				case 1: // for stepper
					stepper = (Stepper) p.getPiece(choice); // get stepper reference from p
					displayMovementOptions(choice);			// display the appropriate movement options
					while(true) {
						System.out.print("\nEnter your direction: ");
						direction = in.nextInt();						// getting a direction
						try {
							int newPosition[] = stepper.calcDestination(direction); // create coordinates for a new position
							validateMove(newPosition[0], newPosition[1]);			// validate the new position
							
							// if validate is successful
							if(removePrize(newPosition[0], newPosition[1])) { // the first action is to check the new position has a prize
								gameBoard[stepper.getLocation()[0]][stepper.getLocation()[1]] = null; // if it is true, an object in the old position sets to null
								stepper.setLocation(newPosition[0], newPosition[1]);				  // this object sets its coordinates in the new position
								gameBoard[newPosition[0]][newPosition[1]] = stepper;				  // then do below action in the game board
								
								if(stepper.getLocation()[1] == numCols - 1) { // if piece reaches the end of game board
									stepper.setIsFinished(true);			  // set isFinish field to true
									p.updateNumFinish();					  // update the number finish
									return;									  // and exit 
								}
								
								// tell about it
								System.out.println("Huzzah! You have an extra turn.");
								displayBoard(); // display the board
								continue;       // then  give again to make a game turn
							} else if(gameBoard[newPosition[0]][newPosition[1]] == null) { // if a cell in the game board is null
								gameBoard[stepper.getLocation()[0]][stepper.getLocation()[1]] = null;  // if it is true, an object in the old position sets to null
								stepper.setLocation(newPosition[0], newPosition[1]);				   // this object sets its coordinates in the new position
								gameBoard[newPosition[0]][newPosition[1]] = stepper;				   // then do below action in the game board
								if(stepper.getLocation()[1] == numCols - 1) {		// if piece reaches the end of game board
									stepper.setIsFinished(true);					// set isFinish field to true
									p.updateNumFinish();							// update the number finish
									return;											// and exit 
								}
								return;
							}
						} catch (OffBoardException e) { // if validateMove(newPosition[0], newPosition[1]) throws OffBoardException exception
							System.out.println(e.getMessage()); // display the appropriate message
							continue;							// then  give again to make a game turn
							
							
						} catch (CollisionException e) { // if the next cell is an obstacle
							if(e.getMessage().equals("Obstacle at destination")) { 
								System.out.println(e.getMessage()); // display the appropriate message
								p.setLoseTurn(true);				// and player must skip the next game turn
								return;								
							}
							else {
								int newPosition[] = stepper.calcDestination(direction); // if the next cell is piece
								boolean isThereEmpty = false;	// a variable that determines in the start has whether an empty cell or not
								for (int i = 0; i < numRows; i++) { // searching the empty cell
									if(gameBoard[i][0] == null) {	// if an cell is empty
										isThereEmpty = true;		// sets the isThereEmpty to true
										break;
									}
								}
								if(isThereEmpty) { // if the start has some empty cells
									while(true) {
										int randRow = rand.nextInt(numRows); // choose some random empty cell
										if(gameBoard[randRow][0] == null) {  // if it is empty
											gameBoard[randRow][0] = gameBoard[newPosition[0]][newPosition[1]]; // move the piece that in the new position to some empty cell 
											gameBoard[newPosition[0]][newPosition[1]] = null; 
											if(stepper.getLocation()[1] == numCols - 1) { 
												stepper.setIsFinished(true);
												p.updateNumFinish();
												return;
											}
											return;
										}
									}
								}
								e = new CollisionException("Piece at destination"); // if the start has not any empty cells
								System.out.println(e.getMessage());					// display the appropriate message
							}
							
						}
					}
				case 2: // for crisscrosser
					crisscrosser = (Crisscrosser) p.getPiece(choice); 	// get stepper reference from p
					displayMovementOptions(choice);						// display the appropriate movement options
					while(true) {
						System.out.print("\nEnter your direction: ");
						direction = in.nextInt();						// getting a direction
						try {
							int newPosition[] = crisscrosser.calcDestination(direction); // create coordinates for a new position
							validateMove(newPosition[0], newPosition[1]);				 // validate the new position
							
							if(removePrize(newPosition[0], newPosition[1])) { // the first action is to check the new position has a price
								gameBoard[crisscrosser.getLocation()[0]][crisscrosser.getLocation()[1]] = null; // if it is true, an object in the old
								crisscrosser.setLocation(newPosition[0], newPosition[1]);						// this object sets its coordinates in the new position
								gameBoard[newPosition[0]][newPosition[1]] = crisscrosser;						// then do below action in the game board
								
								if(crisscrosser.getLocation()[1] == numCols - 1) {	// if piece reaches the end of game board
									crisscrosser.setIsFinished(true);				// sets isFinish field to true
									p.updateNumFinish();							// update the number finish
									return;											// and exit
								}
								
								System.out.println("Huzzah! You have an extra turn.");
								displayBoard();
								continue;
							} else if(gameBoard[newPosition[0]][newPosition[1]] == null) {	// if a cell in the game board is null
								gameBoard[crisscrosser.getLocation()[0]][crisscrosser.getLocation()[1]] = null; // if it is true, an object in the old position sets to null
								crisscrosser.setLocation(newPosition[0], newPosition[1]);						// this object sets its coordinates in the new position
								gameBoard[newPosition[0]][newPosition[1]] = crisscrosser;						// then do below action in the game board
								if(crisscrosser.getLocation()[1] == numCols - 1) {						// if piece reaches the end of game board
									crisscrosser.setIsFinished(true);									// sets isFinish field to true
									p.updateNumFinish();												// update the number finish
									return;																// and exit
								}
								return;
							}
						} catch (OffBoardException e) { // if validateMove(newPosition[0], newPosition[1]) throws OffBoardException exception
							System.out.println(e.getMessage()); // display the appropriate message
							continue;							// then  give again to make a game turn
							
							
						} catch (CollisionException e) {			// if the next cell is an obstacle
							if(e.getMessage().equals("Obstacle at destination")) {
								System.out.println(e.getMessage());	// display the appropriate message
								p.setLoseTurn(true);				// and player must skip the next game turn
								return;
							}
							else {
								int newPosition[] = crisscrosser.calcDestination(direction); // if the next cell is piece
								boolean isThereEmpty = false;				// a variable that determines in the start has whether an empty cell or not
								for (int i = 0; i < numRows; i++) {			// searching the empty cell
									if(gameBoard[i][0] == null) {			// if an cell is empty
										isThereEmpty = true;				// sets the isThereEmpty to true
										break;
									}
								}
								if(isThereEmpty) {	// if the start has some empty cells
									while(true) {
										int randRow = rand.nextInt(numRows); // choose some random empty cell
										if(gameBoard[randRow][0] == null) {	 // if it is empty
											gameBoard[randRow][0] = gameBoard[newPosition[0]][newPosition[1]]; // move the piece that in the new position to some empty cell
											gameBoard[newPosition[0]][newPosition[1]] = null;
											if(crisscrosser.getLocation()[1] == numCols - 1) {
												crisscrosser.setIsFinished(true);
												p.updateNumFinish();
												return;
											}
											return;
										}
									}
								}
								e = new CollisionException("Piece at destination"); // if the start has not any empty cells
								System.out.println(e.getMessage());					// display the appropriate message
							}
							
						}
					}
				case 3: // for bumper
					bumper = (Bumper) p.getPiece(choice); // get stepper reference from p
					displayMovementOptions(choice);		  // display the appropriate movement options
					while(true) {
						System.out.print("\nEnter your direction: ");
						direction = in.nextInt();        // getting a direction
						try {
							int newPosition[] = bumper.calcDestination(direction);  // create coordinates for a new position
							validateMove(newPosition[0], newPosition[1]);			// validate the new position
							
							// if validate is successful
							if(removePrize(newPosition[0], newPosition[1])) { // the first action is to check the new position has a price
								gameBoard[bumper.getLocation()[0]][bumper.getLocation()[1]] = null; // if it is true, an object in the old position sets to null
								bumper.setLocation(newPosition[0], newPosition[1]);					// this object sets its coordinates in the new position
								gameBoard[newPosition[0]][newPosition[1]] = bumper;					// then do below action in the game board
								
								if(bumper.getLocation()[1] == numCols - 1) { // if piece reaches the end of game board
									bumper.setIsFinished(true);				 // set isFinish field to true
									p.updateNumFinish();					 // update the number finish
									return;									 // and exit 
								}
								
								// tell about it
								System.out.println("Huzzah! You have an extra turn.");
								displayBoard();	// display the board
								continue;		// then  give again to make a game turn
							} else if(gameBoard[newPosition[0]][newPosition[1]] == null) {	// if a cell in the game board is null
								gameBoard[bumper.getLocation()[0]][bumper.getLocation()[1]] = null; // if it is true, an object in the old position sets to null
								bumper.setLocation(newPosition[0], newPosition[1]);					// this object sets its coordinates in the new position
								gameBoard[newPosition[0]][newPosition[1]] = bumper;					// then do below action in the game board
								
								if(bumper.getLocation()[1] == numCols - 1) {	// if piece reaches the end of game board
									bumper.setIsFinished(true);					// set isFinish field to true
									p.updateNumFinish();						// update the number finish
									return;										// and exit 
								}
								
								return;
							} 
						} catch (OffBoardException e) { // if validateMove(newPosition[0], newPosition[1]) throws OffBoardException exception
							System.out.println(e.getMessage()); // display the appropriate message
							continue;							// then  give again to make a game turn
							
							
						} catch (CollisionException e) { // if the next cell is an obstacle
							if(e.getMessage().equals("Obstacle at destination")) {
								System.out.println(e.getMessage()); // display the appropriate message
								p.setLoseTurn(true);				// and player must skip the next game turn
								return;
							}
							else {
								int newPosition[] = bumper.calcDestination(direction); // if the next cell is piece
								boolean isThereEmpty = false;		// a variable that determines in the start has whether an empty cell or not
								for (int i = 0; i < numRows; i++) { // searching the empty cell
									if(gameBoard[i][0] == null) {	// if an cell is empty
										isThereEmpty = true;		// sets the isThereEmpty to true
										break;
									}
								}
								if(isThereEmpty) { // if the start has some empty cells
									while(true) {
										int randRow = rand.nextInt(numRows);	// choose some random empty cell
										if(gameBoard[randRow][0] == null) {		// if it is empty
											gameBoard[randRow][0] = gameBoard[newPosition[0]][newPosition[1]]; // move the piece that in the new position to some empty cell
											gameBoard[bumper.getLocation()[0]][bumper.getLocation()[1]] = null;
											bumper.setLocation(newPosition[0], newPosition[1]);
											gameBoard[newPosition[0]][newPosition[1]] = bumper;
											
											if(bumper.getLocation()[1] == numCols - 1) {
												bumper.setIsFinished(true);
												p.updateNumFinish();
												return;
											}
											return;
										}
									}
								}
								e = new CollisionException("Piece at destination"); // if the start has not any empty cells
								System.out.println(e.getMessage());					// display the appropriate message
							}
							
						}
					}
				default:
					System.out.println("Incorrect input. Try again.");
					break;
				}
			}
			else
				continue;
		}
	}//runPlayerTurn
	
			
} // GameBoard
