import java.util.*;

public class FrontierQueue implements Frontier{
    private Queue<Location> locations;

    public FrontierQueue(){
	locations = new LinkedList<Location>();
    }

    public Location next(){
	return locations.remove();
    }

    public void add(Location n){
	locations.add(n);
    }

    public boolean hasNext(){
      return !locations.isEmpty();
    }

}
