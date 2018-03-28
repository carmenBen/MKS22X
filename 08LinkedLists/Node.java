public class Node{
    private Node next = null;
    private Node prev = null;
    private int data;

    public Node(int val, Node nextNode, Node prevNode){
	next = nextNode;
	prev = prevNode;
	data = val;
    }

    
    public Node getNext(){
	return next;
    }

    public Node getPrev(){
	return prev;
    }

    public int getValue(){
	return data;
    }

    public void setNext(Node n){
	next = n;
    }

    public void setPrev(Node n){
	prev = n;;
    }

    public void setValue(int d){
	data = d;
    }

    public String toString(){
	return "" + data;
    }
}
