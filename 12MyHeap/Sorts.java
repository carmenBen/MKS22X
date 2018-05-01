import java.util.*;

public class Sorts{
  public static void heapSort(Object[] data){
    for(int i = data.length - 1;i>= 0;i--){
      int child = ((i*2)+1);
      (MyHeap<Object>)  data;
      if(child < data.length){
        data.pushDown(i,child);
      }
    }
  }

  public static void main(String[] args){
    Integer[] test = new Integer[5];
    test[0] = 5;
    test[1] = 1;
    test[2] = 3;
    test[3] = 2;
    test[4] = 4;
    System.out.println(Arrays.toString(test));
    heapSort(test);
    System.out.println(Arrays.toString(test));
  }
}
