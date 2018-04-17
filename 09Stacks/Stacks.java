import java.util.*;

public class Stacks{
    private ArrayList<String> data;

    public Stacks(){
      data = new ArrayList<String>();
    }

  public double pop(){
    if(data.size() != 0){
      return Double.parseDouble(data.remove(data.size() - 1));
    }
    return 0.0;
  }

  public void push(String n){
    data.add(n);
    //System.out.println(n);
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
