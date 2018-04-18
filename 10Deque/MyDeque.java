import java.lang.*;
import java.util.*;

public class MyDeque<T>{
    private T[] data;
    private int front;
    private int back;
    private int size;

    
    public MyDeque(){
	@SuppressWarnings("unchecked") data = (T[]) new Object[10];
	size = 0;
	back = -1;
	front = 10;
    }

    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = new Object[initialCapacity];
	size = 0;
	back = -1;
	front = initialCapacity;
    }

    public int size(){
	return size;
    }


    public void addFirst(T thing){
	if(thing.equal(null)){
	    throw new NullPointerException();
	}
	//resize if needed
	if(size >= data){
	    data.resize();
	}
	data[front-1] = thing;
	front--;
	size++;
    }

    public void addLast(T thing){
	if(thing.equal(null)){
	    throw new NullPointerException();
	}
	//resize if needed
	if(size >= data){
	    data.resize();
	}
	data[last+1] = thing;
	last++;
	size++;
    }

    public T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T current = data[front];
	data[front] = null;
	front++;
	size--;
	return current;
    }

    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T current = data[last];
	data[last] = null;
	last--;
	size--;
	return current;
    }

    public T getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
        return data[last];
    }

    
    public T getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return data[first];
    }

    public void resize(){
	T[] newData = new T[size*2];
	for(int i = 0;i < size;i++){
	    if(i <= back){
		newData[i] = data[i];
	    }
	    else{
		newData[size + i] = data[i];
	    }
	}
	data = newData;
	front = data.length + front;
    }

}
