public class Stepper extends PlayerItem
{
	
	// Constructor
	public Stepper(char s) 
	{
		type = "stepper";
		symbol = s;
		isFinished = false;
	}
	
	// based on the direction supplied, this method calculates the
	// destination row & column IF the object were to be moved
	@Override //just to be safe
	int[] calcDestination(int direction) 
	{
		int[] newLocation = location.clone(); //makes exact copy of location
		switch (direction) 
		{
			case 1: // if direction is north
				newLocation[0]--;
				return newLocation;
			case 2: // if direction is south
				newLocation[0]++;
				return newLocation;
			case 3: // if direction is east
				newLocation[1]++;
				return newLocation;
			case 4: // if direction is west
				newLocation[1]--;
				return newLocation;
			default:
				return newLocation;
		}
		
	} //calcDestination
	
} // Stepper
