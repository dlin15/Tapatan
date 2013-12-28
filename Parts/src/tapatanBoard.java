import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class tapatanBoard {
	
	// 0 1 2
	// 3 4 5
	// 6 7 8
	int[] board;
	
	// true is player 1
	// false is player 2
	boolean turn;
	
	// Maps from location to all adjacent locations
	private HashMap<Integer,int[]> adjacentPositions;
	
	// Set of combinations that represents winning positions
	private HashSet<Integer> winningSets;
	
	// 1  2   4
	// 8  16  32
	// 64 128 256
	private HashMap<Integer, Integer> winMap;
	
	// Position sums for each player
	private int p1,p2;
	
	
	public tapatanBoard(){
		turn = true;
		board = new int[9];
		p1 = 0;
		p2 = 0;
		adjacentPositionSetUp();
		winningSetsSetUp();
		winMapSetUp();
	}
	
	// Moves the current player's piece from the given source to destination positions.
	// Assumed destination must be valid because of adjacent positions
	// Param: source postision, destination location
	public void move(int source, int destination){
		board[source] = 0;
		if(turn){
			p1 -= winMap.get(source);
		}else{
			p2 -= winMap.get(source);
		}
		place(destination);
	}
	
	// Places the current player's piece on the board at the given position.
	// Param: destination location
	public void place(int destination){
		// Player 1's turn
		if(turn){
			p1 += winMap.get(destination);
			board[destination] = 1;
			if(winningSets.contains(p1)){
				//player one wins
			}
		// Player 2's turn
		}else{
			p2 += winMap.get(destination);
			board[destination] = 2;
			if(winningSets.contains(p2)){
				//player two wins
			}
		}
		// Switch players
		turn = !turn;
	}
	
	// Lists the adjecent positions to the current position
	// Param: postion on the board
	// Return: List of adjacent positions on the board
	public List<Integer> adjacentPositions(int position){
		int[] adjacent = adjacentPositions.get(position);
		// create list
		List<Integer> valid = new ArrayList<Integer>();
		for(int i:adjacent){
			// only add empty postions
			if(board[i] == 0){
				valid.add(i);
			}
		}
		return valid;
	}
	
	// Create winMap
	private void winMapSetUp(){
		winMap = new HashMap<Integer,Integer>();
		winMap.put(0,1);
		winMap.put(1,2);
		winMap.put(2,4);
		winMap.put(3,8);
		winMap.put(4,16);
		winMap.put(5,32);
		winMap.put(6,64);
		winMap.put(7,128);
		winMap.put(8,256);
	}
	
	// Create winningSets
	// winningSets represents the values where a player wins
	private void winningSetsSetUp(){
		winningSets = new HashSet<Integer>();
		winningSets.add(7);
		winningSets.add(56);
		winningSets.add(73);
		winningSets.add(84);
		winningSets.add(146);
		winningSets.add(273);
		winningSets.add(292);
		winningSets.add(448);
	}
	
	// Create the set of adjacent postions
	private void adjacentPositionSetUp(){
		adjacentPositions = new HashMap<Integer, int[]>();
		adjacentPositions.put(0, new int[]{1,3,4});
		adjacentPositions.put(1, new int[]{0,2,4});
		adjacentPositions.put(2, new int[]{1,4,5});
		adjacentPositions.put(3, new int[]{0,4,6});
		adjacentPositions.put(4, new int[]{0,1,2,3,5,6,7,8});
		adjacentPositions.put(5, new int[]{2,4,8});
		adjacentPositions.put(6, new int[]{3,4,7});
		adjacentPositions.put(7, new int[]{4,6,8});
		adjacentPositions.put(8, new int[]{4,5,7});
	}
	
}
