import java.lang.*;
import java.util.*;

public class MyDeque<T>{
  private T[] data;
  private int front;
  private int back;
  private int size;

    
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (T[]) new Object[10];
    size = 0;
    back = -1;
    front = -1;
  }


  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    if(initialCapacity < 0){
	    throw new IllegalArgumentException();
    }
    data = (T[])new Object[initialCapacity];
    size = 0;
    back = -1;
    front = -1;
  }

  public int size(){
    return size;
  }


  public void addFirst(T obj){
    if(obj.equals(null)){
	    throw new NullPointerException();
    }
    if(size == 0){
      front = 0;
      back = 0;
      data[front] = obj;
      size++;
    }
    else{
      //resize if needed
      if(size >= data.length){
        resize();
      }
      if(front >= 0){
        data[front-1] = obj;
        front--;
        size++;
      }
      else{
        data[data.length - 1] = obj;
        front = data.length - 1;;
        size++;
      }
    }
  }

  public void addLast(T thing){
    if(thing.equals(null)){
	    throw new NullPointerException();
    }
    //resize if needed
    if(size == 0){
      size++;
      front = 0;
      back = 0;
      data[back] = thing;
    }
    else{
      if(size >= data.length){
        resize();
      }
      if(back < data.length){
        data[back+1] = thing;
        back++;
        size++;
      }
      else{
        data[0] = thing;
        back = 0;
        size++;
      }
    }
  }

  public T removeFirst(){
    if(size == 0){
	    throw new NoSuchElementException();
    }
    T current = data[front];
    data[front] = null;
    front++;
    size--;
    if(front >= data.length){
      front = 0;
    }
    return current;
  }

  public T removeLast(){
    if(size == 0){
	    throw new NoSuchElementException();
    }
    T current = data[back];
    data[back] = null;
    back--;
    if(back < 0){
      back = data.length - 1;
    }
    size--;
    return current;
  }

  public T getLast(){
    if(size == 0){
	    throw new NoSuchElementException();
    }
    return data[back];
  }

    
  public T getFirst(){
    if(size == 0){
	    throw new NoSuchElementException();
    }
    return data[front];
  }

  @SuppressWarnings("unchecked")
  public void resize(){
    T[] newData = (T[])new Object[size*2];
    if(front > back){
      int n = 0;
      for(int i = 0;i <= size;i++){
          newData[i] = data[i];
          n = i;
      }
      back = n -1;
      int j = newData.length - 1;
      for( int i = data.length - 1; i >= front; i--){
        newData[j] = data[i];
        j--;
      }
      front = j+1;
    }
    else{
      int n =newData.length - 1;
      for(int i = back; i >= 0; i--){
        newData[n] = data[i];
        n--;
      }
    }
    data = newData;
  }
  /*
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
    MyDeque test = new MyDeque(10);
    test.addFirst(10);
    System.out.println(test.getFirst());

    System.out.println(test.getLast());
    
    test.addLast(15);
    System.out.println(test.getFirst());

    System.out.println(test.getLast());
    
    test.removeLast();
    System.out.println(test.getFirst());

    System.out.println(test.getLast());
    }*/
}
