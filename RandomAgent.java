import java.util.*;
/**
@author Shyam Sudhakaran
Random Agent
**/

public class RandomAgent extends Agent 
{
	public RandomAgent(int marker) 
	{
		super(marker);
	}

	public int play(int[] state, Board board)
	{	
		Random rand = new Random();
		ArrayList<Integer> moves = board.validMoves(state);
		return moves.get(rand.nextInt(moves.size()));
	}

}