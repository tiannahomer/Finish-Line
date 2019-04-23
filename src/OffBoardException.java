public class OffBoardException extends Exception
{
	
	public OffBoardException() 
	{
		super("Destination off board!");
	}

	public OffBoardException(String string) 
	{
		super(string);
	}
} // OffBoardException
