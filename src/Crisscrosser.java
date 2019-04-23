public class Crisscrosser extends PlayerItem
{
	
	// Constructor
	public Crisscrosser(char s) 
	{
		type = "crisscrosser";
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
			case 8: //if direction is southwest
				newLocation[0]++;
				newLocation[1]--;
				return newLocation;
			default:
				return newLocation;
		}
	} // calcDestination
	
	
} //Crisscrosser
