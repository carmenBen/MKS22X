public class KnightBoard{
    private int[][] board;
    private int counter;
    private int[] possibleMoves;

    public KnightBoard(int startingRows,int startingCols) {
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
	counter = 0;
        for(int r = 0;r < startingRows;r++){
	    for(int c = 0;c < startingCols;c++){
		board[r][c] = 0;
	    }
	}
	possibleMoves = new int[]{1,-2, 2,-1, 1,2, 2,1, -1,2, -2,1, -1,-2, -2,-1};
    }
    
    public String toString() {
	String total = "";
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
		if(board.length * board[0].length >= 10){
		    if(board[r][c] == 0){
			total += " __";
		    }
		    else if(board[r][c] < 10){
			total =total + " _" + board[r][c];
		    }
		    else{
			total = total + " " + board[r][c];
		    }
		}
		else{
		    if(board[r][c] == 0){
			total += " _";
		    }
		    else{
			total = total + " " + board[r][c];
		    }
		}
	    }
	    total += "\n";
	}
	return total;
    }
    
    public boolean solve(int row, int col) {
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
		if(board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
	    throw new IllegalArgumentException();
	}
	if(board.length == 1 ||board.length == 2|| board.length == 4|| board.length % 2 == 1 && board[0].length % 2 == 1|| board.length == 3 && (board[0].length == 4 || board[0].length == 6|| board[0].length ==  8)){
	    return false;
	}
	return true;
    }
    
    public int countSolutions(int row, int col) {
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board[0].length;c++){
		if(board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
	    throw new IllegalArgumentException();
	}
	return 0;
    }

    private boolean solveH(int row ,int col, int level) {
	if(level > row * col){
	    return true;
	}
	for(int i = 0; i < possibleMoves.length;i= i+2){
	    board[row][col] = level;
	    if(solveH(row+possibleMoves[i],col+possibleMoves[i+1],level+1)){
		return true;
	    }
	    board[row][col] = 0;
	}
	return false;
    }
    // level is the # of the knight

}
