import java.util.*;

public class FrontierStack{
    private Stack<Location> locations;

    public FrontierStack(){
	locations = new Stack<Location>();
    }
    
    public Location next(){
	return locations.pop();
    }

    public void add(Location n){
	locations.push(n);
    }

    public boolean hasNext(){
	return !locations.empty();
    }

}
