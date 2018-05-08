public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToEnd;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public void setDistance(int d){
	distanceToEnd = d;
    }
    
    public int getDistance(){
	return distanceToEnd;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location other){
	return getDistance() - other.getDistance();
    }
}
