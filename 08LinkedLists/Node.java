public class Node<T>{
    private Node next = null;
    private Node prev = null;
    private T data;

    public Node(T val, Node nextNode, Node prevNode){
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

    public T getValue(){
	return data;
    }

    public void setNext(Node n){
	next = n;
    }

    public void setPrev(Node n){
	prev = n;;
    }

    public void setValue(T d){
	data = d;
    }

    public String toString(){
	return "" + data;
    }
}
