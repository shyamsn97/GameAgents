import java.util.*;
/**
@author Shyam Sudhakaran
MiniMax Agent with alpha beta pruning 
**/

public class MiniMaxABAgent extends Agent
{
	public MiniMaxABAgent(int marker)
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
		int alpha = -1000;
		int beta = 1000;

		for (int i = 0; i < moves.size(); i++) 
		{
			copystate = board.draw(moves.get(i),marker,state);
			score = minVal(copystate,board,1-marker,alpha,beta);
			if (score > best_score) 
			{
				best_score = score;
				best_move = i;	
			}
			if (score >= beta) 
			{
				return moves.get(best_move);
			}
			if (score > alpha) 
			{
				alpha = score;
			}
		}
		return moves.get(best_move);
	}

	public int minVal(int[] state, Board board, int marker, int alpha, int beta)
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
		int score = 100;
		int newscore = 0;

		for (int i = 0; i < moves.size(); i++) 
		{
			int[] copystate = board.draw(moves.get(i),marker,state);
			newscore = maxVal(copystate,board,1-marker,alpha,beta);
			if (newscore < score)
			{
				score = newscore;
			}
			if (newscore <= alpha) 
			{
				return score;
			}
			else if (newscore < beta)
			{
				beta = newscore;
			}
		}
		return score;	
	}

	public int maxVal(int[] state, Board board, int marker, int alpha, int beta)
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
			newscore = minVal(copystate,board,1-marker,alpha,beta);
			if (newscore > score)
			{
				score = newscore;
			}
			if (newscore >= beta) 
			{
				return score;
			}
			else if (newscore > alpha)
			{
				alpha = newscore;
			}
		}
		return score;		
	}
}
