public class CollisionException extends Exception
{
	public CollisionException() 
	{
		super("Collision imminent!");
	}

	public CollisionException(String string) 
	{
		super(string);
	}
} // CollisionException
