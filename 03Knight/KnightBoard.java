public KnightBoard(int startingRows,int startingCols) {}
//non square is required!

public String toString() {}
/*see format for toString below
  blank boards use underscores 
  you get a blank board if you never called solve or 
  when there is no solution */

public boolean solve() {}
public int     countSolutions() {}

private boolean solveH(int row ,int col, int level) {}
// level is the # of the knight
