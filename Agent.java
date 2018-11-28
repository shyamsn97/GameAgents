import java.util.*;
/**
@author Shyam Sudhakaran
Agent object
**/
class Agent 
{
	int marker;
	public Agent(int marker)
	{
		this.marker = marker;
	}
	public void printMarker()
	{
		System.out.println(this.marker);
	}

	public int play(int[] state, Board board)
	{	
		return 0;
	}
}