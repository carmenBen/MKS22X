import java.util.*;

public class Stacks<T>{
    private ArrayList<T> data;

    public Stacks(){
      data = new ArrayList<T>();
    }

  public void pop(){
    if(data.size() != 0){
      data.remove(data.size() - 1);
    }
  }

  public void push(T n){
    data.add(n);
  }

  public T peak(){
    if(data.size() != 0){
      return data.get(data.size() - 1);
    }
    return  null;
  }

  /*  public static void main(String[] args){
    Stacks<String> test = new Stacks<String>();
    test.push("ch");
    test.push("hh");
    System.out.println(test.peak());
    test.pop();
    System.out.println(test.peak());
    test.pop();
    }*/
}
