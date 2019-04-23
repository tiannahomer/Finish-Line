public class Bumper extends PlayerItem
{

	// Constructor
	public Bumper(char s) 
	{
		type = "bumper";
		symbol = s;
		isFinished = false;
	}
	
	// based on the direction supplied, this method calculates the
	// destination row & column IF the object were to be moved
	@Override //just to be safe lol
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
			case 5: // if direction is northeast
				newLocation[0]--;
				newLocation[1]++;
				return newLocation;
			case 6: // if direction is southeast
				newLocation[0]++;
				newLocation[1]++;
				return newLocation;
			case 7: // if direction is northwest
				newLocation[0]--;
				newLocation[1]--;
				return newLocation;
			case 8: // if direction is southwest
				newLocation[0]++;
				newLocation[1]--;
				return newLocation;
			default:
				return newLocation;
		}
	} // calcDestination
	
} // Bumper
