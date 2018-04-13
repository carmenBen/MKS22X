import java.util.*;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
  Node first;
  Node last;
  int length;

  private class MyLinkedListIterator implements Iterator<T>{
    Node node;
    T current;

    public MyLinkedListIterator(Node info){
	    node = info;
    }

    public void remove(){
	    throw new UnsupportedOperationException();
    }

    public T next(){
	    if(hasNext()){
        current = node.getValue();
        node = node.getNext();
        return current;
	    }
	    else{
        throw new NoSuchElementException();
	    }
    }

    public boolean hasNext(){
	    return node != null;
    }
  }

  
  private class Node{
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
  
  public MyLinkedListImproved(){
    length = 0;
    first = null;
    last = null;
  }
  public Node getLast(){
    return last;
  }

  public Iterator<T> iterator(){
    return new MyLinkedListIterator(first);
  }
  
  public boolean add(T value){
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

  public void extend(MyLinkedListImproved<T> O){
    if(this.size() <= 0 && O.size() != 0){
      first = O.getNode(0);
      last = O.getLast();
      length =O.size();
      O.clear();
    }
    else if(O.size() != 0){
      last.setNext(O.getNode(0));
      O.getNode(0).setPrev(last);
      last = O.getLast();
      length += O.size();
      O.clear();
    }
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

  public T get(int index){
    if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();      
    }
    return getNode(index).getValue();
  }

  public Node getNode(int n){
    int i = 0;
    Node current = first;
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
    Node current = getNode(index);
    T old = current.getValue();
    current.setValue(newValue);
    return old;
  }

  public int indexOf(T value){
    Node node = first;
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
	    Node node = new Node(value,null,null);
	    first = node;
	    last = node;
    }
    else if(index != 0 && index != length){
	    Node current = getNode(index);
	    Node node = new Node(value,current,current.getPrev());
	    current.getPrev().setNext(node);
	    current.setPrev(node);
    }
    else if(index == length){
	    Node node = new Node(value,null,last);
	    last.setNext(node);
	    last = node;
    }
    else{
	    Node node = new Node(value,first,null);
	    first.setPrev(node);
	    first = node;
    }
    length++;
  }
 	

  public boolean remove(T value){
    int index = indexOf(value);
    if(length == 1 || length == 0){
      clear();
      return true;
    }
    else if(index != 0 && index != length -1){
	    Node node = getNode(index);
	    node.getPrev().setNext(node.getNext());
	    node.getNext().setPrev(node.getPrev());
    }
    else if(index == length - 1){
	    last.getPrev().setNext(null);
	    last = last.getPrev();
    }
    else{
	    first =first.getNext();
	    first.setPrev(null);
    }
    length--;
    return true;
  }

  public T remove(int index){//exceptions!
    if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();      
    }
    Node node;
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
    
  public int max(){
    if(length == 0){
	    return -1;
    }
    Node node = first;
    int maxIndex = 0;
    int i = 0;
    T max = node.getValue();
    while(node != null){
	    if(node.getValue().compareTo(max) > 0){
        maxIndex = i;
        max = node.getValue();
	    }
	    i++;
	    node = node.getNext();
    }
    return maxIndex;
  }

  public int min(){
    if(length == 0){
	    return -1;
    }
    Node node = first;
    int minIndex = 0;
    int i = 0;
    T min = node.getValue();
    while(node != null){
	    if(node.getValue().compareTo(min) < 0){
        minIndex = i;
        min = node.getValue();
	    }
	    i++;
	    node = node.getNext();
    }
    return minIndex;
  }
    

  public static void main(String[] args){
    MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
    a.add(Integer.valueOf(0));
    a.add(Integer.valueOf(5));
    a.add(Integer.valueOf(2));
    for(Integer n : a){
	    System.out.println(n);
    }
    System.out.println(a);

    MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
    b.add(Integer.valueOf(0));
    b.add(Integer.valueOf(5));
    b.add(Integer.valueOf(2));
    System.out.println(b);
    a.extend(b);
    System.out.println(a);
    System.out.println(b);
  }
}
