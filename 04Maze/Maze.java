import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default
    private int count;
    private int[] possibleMoves;

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.

    */

    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	count = 0;
        //COMPLETE CONSTRUCTOR	
	ArrayList<String> lines = new ArrayList<String> ();
	File info = new File(filename);
	Scanner inf = new Scanner(info);
	while(inf.hasNextLine()){
	    lines.add(inf.nextLine());
	}
	
	maze = new char[lines.size()][lines.get(0).length()];
	int e = 0;
	int s = 0;
	for(int r = 0;r<lines.size();r++){
	    for(int c= 0;c<lines.get(0).length();c++){
		char current = lines.get(r).charAt(c);
		if(current == 'E'){
		    e++;
		}
		else if(current == 'S'){
		    s++;
		}
		maze[r][c] = current;
	    }
	}
	if(e != 1 || s != 1){
	    throw new IllegalStateException();
	}

	possibleMoves = new int[]{1,0,
				  0,-1,
				  -1,0,
				  0,1};
    }

    public String toString(){
	String test = "";
	for(int r = 0;r<maze.length;r++){
	    for(int c= 0;c<maze[0].length;c++){
		test+= maze[r][c];
	    }
	    test += "\n";
	}
	return test;
    }

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
	int sCol = 0;
	int sRow = 0;
	//find the location of the S. 
	for(int r = 0;r<maze.length;r++){
	    for(int c= 0;c<maze[0].length;c++){
		if(maze[r][c] == 'S'){
		    sCol = c;
		    sRow = r;
		}
	    }
	}

	//erase the S
	//and start solving at the location of the s.
	maze[sRow][sCol] = ' ';
	
	//return solve(???,???);
	return solve(sRow,sCol,false,-1,-1);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'

      Note: This is not required based on the algorithm, it is just nice visually to see.
      All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col,boolean backingUp,int pRow, int pCol){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE
	if(maze[row][col] == 'E'){
	    return count;
	}
	else if(maze[row][col] == ' '){
	    maze[row][col] = '@';
	    count++;
	}
	for(int i = 0;i+1 < possibleMoves.length;i= i+2){
	    if(maze[row + possibleMoves[i]][col + possibleMoves[i+1]] == ' ' || maze[row + possibleMoves[i]][col + possibleMoves[i+1]] == 'E'){
		return solve(row + possibleMoves[i], col + possibleMoves[i+1],false,i,i+1);
	    }
	}
	count --;
	maze[row][col] = '.';
	if(!backingUp){
	    return solve(row + (-1* possibleMoves[pRow]), col + (-1* possibleMoves[pCol]),true,pRow,pCol);	
	}
	for(int i = 0;i+1 < possibleMoves.length;i= i+2){
	    if(maze[row + possibleMoves[i]][col + possibleMoves[i+1]] == '@'){
		return solve(row + possibleMoves[i], col + possibleMoves[i+1],true,i,i+1);
	    }
	}
	return -1; //so it compiles
    }


}
