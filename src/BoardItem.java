public class BoardItem
{
	// data members
	protected String type; // contains type of item
	protected char symbol; // contains character used to represent type of item
	
	
	// sets the type of item
	public void setType(String newType)
	{
		type = newType;
	} // setType
	
	
	// sets the symbol used to represent the creature on the board
	public void setSymbol(char newSymbol)
	{
		symbol = newSymbol;
	} // setSymbol
	
	
	// gets the type of item
	public String getType()
	{
		return type;
	} //getType
	
	
	// gets the symbol used to represent the creature on the board
	public char getSymbol()
	{
		return symbol;
	} // getSymbol
	
	
} // BoardItem