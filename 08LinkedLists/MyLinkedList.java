public class MyLinkedList{
    Node first;
    Node last;
    int length;

    public MyLinkedList(){
	length = 0;
	first = null;
	last = null;
    }

    public boolean add(int value){
	Node val = new Node(value,null,null);
	if(length != 0){
	    last.setNext(val);
	    val.setPrev(last);
	}
	if(length == 0){
	    first = val;
	}
	last = val;
	length++;
	return true;
    }
    
    public int size(){
	return length;
    }

    public String toString(){
	if(length > 1 ){
	    String total = "["+first.getValue() + ",";
	    Node current = first.getNext();
	    for(int i = 1;i < length-1;i++){
		total += current.getValue() + ",";
		current = current.getNext();
	    }
	    return total+last.getValue()+"]";
	}
	else if(length == 1){
	    return "[" + first.getValue() + "]";
	}
	else{
	    return "[]";
	}
    }

    public int get(int index){
	return getNode(index).getValue();
    }

    private Node getNode(int n){
	return null;
    }

    public int set(int index,int newValue){
	Node current = 	getNode(index);
	int old = current.getValue();
	current.setValue(newValue);
	return old;
    }

}
