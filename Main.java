/**
@author Shyam Sudhakaran
Main Function for tic tac toe game
**/
public class Main 
{
	public static void main(String[] args) 
	{
		MiniMaxABAgent player1 = new MiniMaxABAgent(0);
		RandomAgent player2 = new RandomAgent(1);
		Game g = new Game(3);
		System.out.println(g.play(player1,player2));
	}
}