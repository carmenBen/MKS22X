import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> locations;

    public FrontierPriorityQueue(){
	locations = new MyHeap<Location>(false);
    }

    public Location next(){
	return locations.remove();
    }

    public void add(Location n){
	locations.add(n);
    }

    public boolean hasNext(){
      return locations.size() != 0;
    }

}
