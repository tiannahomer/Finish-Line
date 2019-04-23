public abstract class PlayerItem extends BoardItem
{
	int[] location;			// array used to hold the row and column location of the object
	boolean isFinished;		// used to indicate whether the object has reached FINISH or not
	
	// Constructor which initializes location array to the appropriate size.
	public PlayerItem() 
	{
		location = new int[2];
	}
	
	// used to store the current location of the object in the location variable
	void setLocation(int r, int c) 
	{
		location[0] = r;
		location[1] = c;
	}
	
	// returns the location of the object.
	int[] getLocation() 
	{
		return location;
	}
	
	// returns whether or not the object has reached FINISH.
	boolean getIsFinished() 
	{
		return isFinished;
	}
	
	// uses status to update the isFinished data member
	void setIsFinished(boolean status) 
	{
		isFinished = status;
	}
	
	// abstract method to be defined by sub-classes
	abstract int[] calcDestination(int direction);
}
