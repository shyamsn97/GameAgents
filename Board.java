import java.util.*;
/**
@author Shyam Sudhakaran
Board object
**/
public class Board 
{
	
	private int size;
	private int[] state;

	public Board(int size) 
	{
		this.size = size;
		this.state = new int[size*size];
		Arrays.fill(this.state, -1*size);
	}

	public int[] getState() 
	{
		return this.state;
	}

	public ArrayList<Integer> validMoves(int[] state) 
	{
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		for (int i = 0; i < state.length; i++) 
		{
			if (state[i] == -1*this.size) 
			{
				arrlist.add(i);
			}
		}
		return arrlist;
	}

	public int getSize()
	{
		return this.size;
	}

	public void update(int move,int marker) 
	{
		this.state[move] = marker;
	}

	public int[] copyState(int[] state)
	{
		int[] copy_state = new int[state.length];
		for (int i = 0; i < state.length; i++) 
		{
			copy_state[i] = state[i];	
		}
		return copy_state;
	}
	public int[] draw(int move, int marker, int[] state) 
	{
		int[] copy_state = copyState(state);
		copy_state[move] = marker;
		return copy_state;
	}

	public void setState(int[] newstate) 
	{
		this.state = newstate;
	}

	public void reset()
	{
		this.state = new int[this.size*this.size];
	}

	public void printState() 
	{
		String row = "";
		String string = "";
		for(int i = 0; i < this.size*5; i++) 
		{
			row += "-";
		}
		row += "\n";
		string = row;
		String place = " ";		
		for (int j = 0; j < this.state.length; j += this.size) 
		{
			for (int i = 0; i < this.size; i++) 
			{	
				place = " ";
				if (this.state[i + j] == 0) 
				{
					place = "X";
				}
				else if (this.state[i + j] == 1) 
				{
					place = "O";
				}
				string += "| " + place + " |";
			}
			string = string + "\n" + row ;
		}
		System.out.println(string);
	}

	public int countSumRows(int[] state) 
	{
		int sum = 0;
		for (int j = 0; j < state.length; j += this.size) 
		{
			sum = 0;
			for (int i = 0; i < this.size; i++) 
			{
				sum += state[i + j];
			}
			if (sum == this.size || sum == 0) 
			{
				return sum;
			}
		}
		return -1*this.size;
	}

	public int countSumColumns(int[] state) 
	{
		int sum = 0;
		for (int j = 0; j < this.size; j++) 
		{
			sum = 0;
			for (int i = 0; i < state.length; i += this.size) 
			{
				sum += state[i + j];
			}
			if (sum == this.size || sum == 0) 
			{
				return sum;
			}
		}
		return -1*this.size;
	}

	public int checkTermination(int[] state) 
	{
		int rowsum = countSumRows(state);
		if (rowsum == this.size || rowsum == 0) 
		{
			return rowsum / this.size;
		}
		int columnsum = countSumColumns(state);
		if (columnsum == this.size || columnsum == 0) 
		{
			return columnsum / this.size;
		}
		int leftdiag = 0;
		for (int i = 0; i < state.length; i += (this.size + 1)) 
		{
			leftdiag += state[i];
		}
		if (leftdiag == this.size || leftdiag == 0) 
		{
			return leftdiag / this.size;
		}
		int rightdiag = 0;
		for (int i = (state.length - this.size); i > 0; i -= (this.size - 1)) 
		{
			rightdiag += state[i];
		}
		if (rightdiag == this.size || rightdiag == 0) 
		{

			return rightdiag / this.size;
		}
		if (validMoves(state).size() == 0)
		{
			return -1;
		}
		return -1*this.size;
	}
}


