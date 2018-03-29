public class Node{
    private Node next = null;
    private Node prev = null;
    private Integer data;

    public Node(Integer val, Node nextNode, Node prevNode){
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

    public Integer getValue(){
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
