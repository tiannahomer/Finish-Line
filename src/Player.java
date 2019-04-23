public class Player 
{

	// data members
	protected String name; // contains the name of the player
	protected int numFinish; // contains no. of game pieces the player has until finish
	protected boolean loseTurn; // indicates whether or not player loses turn on next round
	protected Stepper stepper; // Stepper player piece
	protected Crisscrosser crisscrosser; // Crisscrosser player piece
	protected Bumper bumper; // Bumper player peice
		
	// constructor to initialise name, numFinish and loseTurn
	public Player (String n)
	{
		name = n;
		numFinish = 0;
		loseTurn = false;
	}
		
	
	// update numFinish by 1
	public void updateNumFinish()
	{
		numFinish ++;
	} //updateNumFinish
	
	
	// sets the player's name
	public void setName(String newName)
	{
		name = newName;
	} // setName
	
	
	// sets the numFinish
	public void setNumFinish(int newNumFinish)
	{
		numFinish = newNumFinish;
	} // setNumFinish
	
	
	// sets loseTurn
	public void setLoseTurn(boolean newLoseTurn)
	{
			loseTurn = newLoseTurn;
	} // setLoseTurn
	
	
	// get's the player's name
	public String getName()
	{
		return name;
	} // getName
	
	
	// gets the player's numFinish
	public int getNumFinish()
	{
		return numFinish;
	} // getNumFinish
	
	
	//get the loseTurn
	public boolean getLoseTurn()
	{
		return loseTurn;
	} // getLoseTurn
	
	// method used to instantiate the player’s pieces
	void setPieces(Stepper s, Crisscrosser c, Bumper b) 
	{
		stepper = s;
		crisscrosser = c;
		bumper = b;
	} // setPieces
	
	// method used to set the isFinished data member of player’s piece
	// (indicated by the parameter) to true
	void setPieceFinished(PlayerItem p) 
	{
		p.setIsFinished(true);
	} // setPieceFinished
			
	// returns whether or not the player’s piece (indicated by the
	// parameter) is home. Values for parameter are 1 (stepper), 2
	// (crisscrosser) or 3 (bumper)
	boolean isPieceFinished(int piece) 
	{
		switch (piece) 
		{
			case 1:
				return stepper.isFinished;
			case 2:
				return crisscrosser.isFinished;
			case 3:
				return bumper.isFinished;
			default:
				return false;
		}
	} // isPieceFinished
	
	// Returns a reference to the player’s piece (indicated by the
	// parameter). Values for parameter are 1 (stepper), 2 (crisscrosser)
	// or 3 (bumper).
    PlayerItem getPiece(int piece) 
    {
    	switch (piece) 
    	{
			case 1:
				return stepper;
			case 2:
				return crisscrosser;
			case 3:
				return bumper;
			default:
				return null;
		}
    } // getPiece
			
	
			
} // Player
