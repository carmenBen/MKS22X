public class MyLinkedListImproved<T>{
  Node<T> first;
  Node<T> last;
  int length;

  public MyLinkedListImproved(){
    length = 0;
    first = null;
    last = null;
  }

  public boolean add(T value){
    Node<T> val = new Node(value,null,null);
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
	    Node<T> current = first.getNext();
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

  public T get(int index){
    if(index >= length || index < 0){
      throw new IndexOutOfBoundsException();      
    }
    return getNode(index).getValue();
  }

  private Node<T> getNode(int n){
    int i = 0;
    Node<T> current = first;
    while(i <= n && current != null){
	    if(i==n){
        return current;
	    }
	    i++;
	    current = current.getNext();
    }
    return null;
  }

  public T set(int index,T newValue){
    if(index >= length || index < 0){
      throw new IndexOutOfBoundsException();      
    }
    Node<T> current = getNode(index);
    T old = current.getValue();
    current.setValue(newValue);
    return old;
  }

  public int indexOf(T value){
    Node<T> node = first;
    int count = 0;
    while(node != null){
	    if(node.getValue().equals(value)){
		return count;
	    }
	    count++;
	    node = node.getNext();
    }
    return -1;
  }

    public void add(int index, T value){//exceptions!
	if(index > length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}
        if(length == 0){
	    Node<T> node = new Node(value,null,null);
	    first = node;
	    last = node;
	}
	else if(index != 0 && index != length){
	    Node<T> current = getNode(index);
	    Node<T> node = new Node(value,current,current.getPrev());
	    current.getPrev().setNext(node);
	    current.setPrev(node);
	}
	else if(index == length){
	    Node<T> node = new Node(value,null,last);
	    last.setNext(node);
	    last = node;
	}
	else{
	    Node<T> node = new Node(value,first,null);
	    first.setPrev(node);
	    first = node;
	}
    length++;
  }
 	

  public boolean remove(T value){
    int index = indexOf(value);
    if(index != 0 && index != length -1){
	    Node<T> node = getNode(index);
	    node.getPrev().setNext(node.getNext());
	    node.getNext().setPrev(node.getPrev());
    }
    else if(index == length - 1){
	    last.getPrev().setNext(null);
	    last = last.getPrev();
    }
    else{
	    first.getNext().setPrev(null);
	    first =first.getNext();
    }
    length--;
    return true;
  }

  public T remove(int index){//exceptions!
    if(index >= length || index < 0){
      throw new IndexOutOfBoundsException();      
    }
    Node<T> node;
    if(index != 0 && index != length -1){
	    node = getNode(index);
	    node.getPrev().setNext(node.getNext());
	    node.getNext().setPrev(node.getPrev());
    }
    else if(index == length - 1){
	    node = getNode(index);
	    last.getPrev().setNext(null);
	    last = last.getPrev();
    }
    else{
	node = getNode(index);
	    first.getNext().setPrev(null);
	    first =first.getNext();
    }
    length--;
    return node.getValue();
  }

    
  public void clear(){
    first = null;
    last = null;
    length = 0;
  }


    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	a.add(Integer.valueOf(0));
	a.add(Integer.valueOf(1));
	a.add(Integer.valueOf(2));
	System.out.println(a);
    }
}
