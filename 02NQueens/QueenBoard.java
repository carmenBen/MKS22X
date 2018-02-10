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

    
  private boolean addQueen(int r, int c){
    if(board[r][c] == 0){
	    for(int i = 0;i < board[0].length; i++){
        board[r][i] +=1;
	    }
      for(int i = 1;i+c < board[0].length && i+r < board.length;i++){
        board[r+i][c+i] +=1;
      }
      for(int i = 1;c>=i&&r>=i;i++){
        board[r-i][c-i] +=1;
      }
      for(int i = 1;i+c < board[0].length && r>=i;i++){
        board[r-i][c+i] +=1;
      }
      for(int i = 1;c>=i&&r+i < board.length;i++){
        board[r+i][c-i] +=1;
      }
	    for(int i = 0; i < board[0].length; i++){
        board[i][c] +=1;
	    }
	    board[r][c] = -1;
	    return true;
    }
    return false;
  }
	
  private boolean removeQueen(int r, int c){
    if(board[r][c] != -1){
	    return false;
    }
    else{
	    for(int i = 0;i < board[0].length; i++){
        board[r][i] -=1;
	    }
      for(int i = 1;i+c < board[0].length && i+r < board.length;i++){
        board[r+i][c+i] -=1;
      }
      for(int i = 1;c>=i&&r>=i;i++){
        board[r-i][c-i] -=1;
      }
      for(int i = 1;i+c < board[0].length && r>=i;i++){
        board[r-i][c+i] -=1;
      }
      for(int i = 1;c>=i&&r+i < board.length;i++){
        board[r+i][c-i] -=1;
      }
	    for(int i = 0; i < board[0].length; i++){
        board[i][c] -=1;
	    }
      board[r][c] = 0;
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
        /*        else if(board[r][c] != 0){
          total += "a ";
          }*/
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
    return solveHelp(0);
  }

  public boolean solveHelp(int col){
    if(col >= board[0].length){
      return true;
    }
    for(int r = 0;r < board.length;r++){
      if(addQueen(r,col)){
        if(solveHelp(col + 1)){
          return true;
        }
        removeQueen(r,col);
      }
    }
    return false;
  }
  
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
