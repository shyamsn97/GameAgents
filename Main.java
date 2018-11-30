/**
@author Shyam Sudhakaran
Main Function for tic tac toe game
**/
public class Main 
{
	public static void main(String[] args) 
	{
		ExpectiMaxAgent player1 = new ExpectiMaxAgent(0);
		MiniMaxABAgent player2 = new MiniMaxABAgent(1);
		Game g = new Game(3);
		System.out.println(g.play(player1,player2));
	}
}