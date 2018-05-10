public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToEnd,oldDistance;

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

    public void setOldDistance(int d){
	oldDistance = d;
    }
    
    public int getOldDistance(){
	return oldDistance;
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
