import java.util.*;

public class MyHeap<T extends Comparable<T>>{
    private T[] data;
    private int size;
    private int max = 1;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	size = 0;
	data = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean type){
	size = 0;
	if(type){
	    max = 1;
	}
	else{
	    max = -1;
	}
	data = (T[]) new Object[10];
    }

    public int size(){
	return size;
    }

    public T peak(){
	if(size >0){
	    return data[0];
	}
	return null;
    }

    public T remove(){
        T temp = data[0];
	data[0] = data[size -  1];
	data[size - 1] = null;
	size--;
	int current = 0;
	// pick child
	int child = (current *2) + 1;

	while((child < size && compare(data[current],data[child])) ||(child+1<size && compare(data[current],data[child+1]))){
	    if(child+1>=size){
		swap(current,child);
		current = child;
		return temp;
	    }
	    if(compare(data[child+1],data[child])){
		swap(current,child);
		current = child;
	    }
	    else{
		swap(current,child+1);
		current = child+1;
	    }
	    //System.out.println((current*2 + 1) + " " + size + data[current*2 + 2]);
	    child = (current*2) + 1;
	}
	return temp;
    }


    public void add(T s){
	if(data.length == size){
	    resize();
	}
	int current = size;
	int parent = (size - 1) / 2;
	data[size] = s;
	//    System.out.println("parent ="+data[parent]+" child= "+data[current]);
	while((parent >= 0) && compare(data[parent],data[current])){
	    swap(current,parent);
	    current = parent;
	    parent = (current - 1)/ 2;
	}
	size++;
	//    System.out.println(Arrays.toString(data));
    }

    public void swap(int a, int b){
	T temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	T[] newData =  (T[]) new Object[size*2];
	for(int i = 0;i < size;i++){
	    newData[i] = data[i];
	}
	data = newData;
    }

    public boolean compare(T b, T a){
	//    System.out.println(b+ " " + a+ " " + max);
	if((b.compareTo(a)*max)  < 0){
	    //  System.out.println("1");
	    return true;
	}
	//   System.out.println("3");
	return false;
    }

    public static void main(String[] args){
	MyHeap<String> test = new MyHeap<String>(false);
	test.add("z");
	test.add("a");
	test.add("c");
	test.add("d");
	test.add("b");
	test.add("k");
	System.out.println(test.peak());
	test.remove();
	System.out.println(test.peak());
	test.remove();
	System.out.println(test.peak());
	test.remove();
	System.out.println(test.peak());
	test.remove();
	System.out.println(test.peak());
    }

}
