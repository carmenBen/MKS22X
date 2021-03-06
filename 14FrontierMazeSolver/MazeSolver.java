public class MazeSolver{
  private Maze maze;
  private Frontier frontier;
    private boolean animate;

    public void setAStar(boolean n){
	maze.type(!n);
    }

    public void animate(boolean n){
	animate = n;
    }

  public MazeSolver(String mazeText){
    maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
    //2: PriorityQueue
    //3: A*
  public boolean solve(int mode){
      if(mode == 3){
	  setAStar(true);
      }
      else{
	  setAStar(false);
      }
    //initialize your frontier
    if(mode == 0){
	    frontier = new FrontierQueue();
    }
    else if(mode ==1){
      frontier = new FrontierStack(); 
    }
    else if(mode ==2 || mode == 3){
	frontier = new FrontierPriorityQueue();
    }
    frontier.add(maze.getStart());
    maze.setSpot(maze.getStart(),'@');
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    while(frontier.hasNext()){
      Location node = frontier.next();
      //System.out.println(node.getX());
      maze.setSpot(node,'.');
      Location[] neighbors = maze.getNeighbors(node);
      for(int i = 0;i < neighbors.length;i++){
        if(neighbors[i].equals(maze.getEnd())){
          Location current = neighbors[i];
          while(!(current.getX() == maze.getStart().getX() && current.getY() == maze.getStart().getY())){
            //System.out.println("" + current.getX()+ " " + current.getY());
            maze.setSpot(current,'@');
            current = current.getPrev();
          }
          maze.setSpot(maze.getStart(),'@');
          return true;
        }
        frontier.add(neighbors[i]);
      }
      if(animate){
	  System.out.println(this);
      }
    }
    return false;
  }

  public String toString(){
    return maze.toStringColor();
  }
}
