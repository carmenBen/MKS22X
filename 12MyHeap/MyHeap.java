import java.util.*;

public class MyHeap{
  private String[] data;
  private int size;
  private int max = 1;

  public MyHeap(){
    size = 0;
    data = new String[10];
  }

  public MyHeap(boolean type){
    size = 0;
    if(type){
      max = 1;
    }
    else{
      max = -1;
    }
    data = new String[10];
  }

  public int size(){
    return size;
  }

  public String peak(){
    if(size >0){
      return data[0];
    }
    return "";
  }

  public String remove(){
    String temp = data[0];
    data[0] = data[size -  1];
    data[size - 1] = null;
    size--;
    int current = 0;
    // pick child
    int child = (current *2) + 1;

    while((child < size && compare(data[current],data[child])) ||(child+1<size && compare(data[current],data[child+1]))){
      if(compare(data[current],data[child])){
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


  public void add(String s){
    if(data.length == size){
      resize();
    }
    int current = size;
    int parent = (size - 1) / 2;
    data[size] = s;
      System.out.println("parent ="+data[parent]+" child= "+data[current]);
    while((parent >= 0) && compare(data[parent],data[current])){
      swap(current,parent);
      current = parent;
      parent = (current - 1)/ 2;
    }
    size++;
    System.out.println(Arrays.toString(data));
  }

  public void swap(int a, int b){
    String temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public void resize(){
    String[] newData =  new String[size*2];
    for(int i = 0;i < size;i++){
      newData[i] = data[i];
    }
    data = newData;
  }

  public boolean compare(String b, String a){
    System.out.println(b+ " " + a+ " " + max);
    if((b.compareTo(a)*max)  == -1){
      System.out.println("1");
      return true;
    }
    System.out.println("3");
    return false;
  }

  public static void main(String[] args){
    MyHeap test = new MyHeap(true);
    test.add("aaaaa");
    test.add("a");
    test.add("aaa");
    test.add("aaaa");
    test.add("aa");
    test.add("aaaaaa");
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
