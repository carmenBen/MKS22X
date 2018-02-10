public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for(int r = 0;r < size;r++){
	    for(int c = 0;c < size;c++){
        board[r][c] = 0;
	    }
    }
  }

    
  public boolean addQueen(int r, int c){
    if(board[r][c] == 0){
	    board[r][c] = -1;
	    for(int i = c+1; i < board[0].length; i++){
        board[r][i] +=1;
        board[r + i][i] +=1;
	    }
	    for(int i = r+1; i < board[0].length; i++){
        board[i][c] +=1;
	    }
	    return true;
    }
    return false;
  }
	
  public boolean removeQueen(int r, int c){
    if(board[r][c] != -1){
	    return false;
    }
    else{
	    board[r][c] = 0;
	    for(int i = c; i < board[0].length; i++){
        board[r][i] -=1;
        board[r + i][i] -=1;
	    }
	    for(int i = r; i < board[0].length; i++){
        board[i][c] -=1;
	    }
	    return true;
    }
  }

  /**
   *@return The output string formatted as follows:
   *All numbers that represent queens are replaced with 'Q' 
   *all others are displayed as underscores '_'
   *There are spaces between each symbol:  
   *Q _ _ _
   *_ _ Q _
   * etc.
   */
  public String toString(){
    String total = "";
    for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
        if(board[r][c] == -1){
          total += "Q ";
        }
        else{
          total += "_ ";
        }
	    }
	    total += "\n";
    }
    return total;
  }


  
  /**
   *@return false when the board is not solveable and leaves the board filled with zeros; 

   *        true when the board is solveable, and leaves the board in a solved state

   *@throws IllegalStateException when the board starts with any non-zero value

   */
  public boolean solve(){
    for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
        if(board[r][c] != 0){
          throw new IllegalStateException();
        }
	    }
    }	
    return true;
  }

  //  public boolean solveHelp(int col
  
  /**
   *@return the number of solutions found, and leaves the board filled with only 0's
   *@throws IllegalStateException when the board starts with any non-zero value
   */
  public int countSolutions(){
    for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
        if(board[r][c] != 0){
          throw new IllegalStateException();
        }
	    }
    }
    return 0;
  }
  

}
