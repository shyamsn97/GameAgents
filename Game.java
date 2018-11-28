import java.util.*;
/**
@author Shyam Sudhakaran
Game object
**/

public class Game
{
	Board board;
	Agent[] agents;
	int turn;

	public Game(int size) 
	{
		this.board = new Board(size);
		this.turn = 0;
	}

	public Agent getAgent(int marker) 
	{
		return this.agents[marker];
	}
	public String play(Agent player1, Agent player2)
	{
		int[] state = this.board.getState();
		ArrayList<Integer> moves = this.board.validMoves(state);
		int move = 0;
		int num_move = 0;
		this.board.printState();
		while(this.board.checkTermination(state) == -1*this.board.getSize())
		{	
			if (this.turn == 0) 
			{
				move = player1.play(state,this.board);
			}
			else 
			{
				move = player2.play(state,this.board);
			}
			this.board.update(move,this.turn);
			state = this.board.getState();
			this.turn = 1 - this.turn;
			num_move++;
			System.out.println("Move # " + num_move);
			this.board.printState();
		}
		int termination = this.board.checkTermination(state);
		this.board.reset();
		this.turn = 0;
		switch (termination)
		{
			case 0:
				return "Player X Wins!";
				

			case 1:
				return "Player O Wins!";

			case -1:
				return "Tie!";
		}
		return "";
	}

	
}