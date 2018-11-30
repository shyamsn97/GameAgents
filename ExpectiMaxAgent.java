import java.util.*;
/**
@author Shyam Sudhakaran
ExpectiMax Agent
**/

public class ExpectiMaxAgent extends Agent
{
	public ExpectiMaxAgent(int marker)
	{
		super(marker);
	}

	public int play(int[] state, Board board)
	{	
		ArrayList<Integer> moves = board.validMoves(state);
		int best_score = -100;
		int best_move = 0;
		int score = 0;
		int marker = this.marker;
		int[] copystate = new int[state.length];

		for (int i = 0; i < moves.size(); i++) 
		{
			copystate = board.draw(moves.get(i),marker,state);
			score = expectiVal(copystate,board,1-marker);
			if (score > best_score) 
			{
				best_score = score;
				best_move = i;	
			}
		}
		return moves.get(best_move);
	}

	public int expectiVal(int[] state, Board board, int marker)
	{
		int termination = board.checkTermination(state);
		if (termination == this.marker) 
		{
			return 10;
		}
		else if (termination == (1 - this.marker)) 
		{
			return -10;
		}
		else if (termination == -1)
		{
			return 0;
		}
		ArrayList<Integer> moves = board.validMoves(state);
		int score = 0;
		double weight = 1 / (double)(moves.size());
		for (int i = 0; i < moves.size(); i++) 
		{
			int[] copystate = board.draw(moves.get(i),marker,state);
			score += weight*maxVal(copystate,board,1-marker);
		}
		return (int) score;	
	}

	public int maxVal(int[] state, Board board, int marker)
	{
		int termination = board.checkTermination(state);
		if (termination == this.marker) 
		{
			return 10;
		}
		else if (termination == (1 - this.marker)) 
		{
			return -10;
		}
		else if (termination == -1)
		{
			return 0;
		}
		ArrayList<Integer> moves = board.validMoves(state);
		int score = -100;
		int newscore = 0;		
		for (int i = 0; i < moves.size(); i++) 
		{
			int[] copystate = board.draw(moves.get(i),marker,state);
			newscore = expectiVal(copystate,board,1-marker);
			if (newscore > score)
			{
				score = newscore;
			}
		}
		return score;		
	}
}




