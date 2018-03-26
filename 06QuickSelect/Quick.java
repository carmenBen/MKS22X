import java.util.Random;
import java.util.*;
public class Quick{
  public static int partition(int[] arr, int start,int end){
    Random rand = new Random();
    int pi = rand.nextInt(end - start + 1) +start;
    int current = arr[pi];
    int pivot = current;	
    arr[pi] = arr[start];
    arr[start] = current;
    int small = start;
    int large = end;
    int i = 1;
    while(large != small){
	    if(pivot > arr[start + i]){
        i++;
        small++;
	    }
	    else{
        current = arr[start + i];
        arr[start + i] = arr[large];
        arr[large] = current;
        large--;
	    }
    }
    //shift everything down a spot and move pivot to correct position
    for(int j = start;j < small;j++){
	    arr[j] = arr[j+1];
    }
    arr[small] = pivot;
    return small;
  }

  public static int[] DFPartition(int[] data,int start,int end){
    Random rand = new Random();
    int pi = rand.nextInt(end - start + 1) +start;
    int lt = start;
    int gt = end;
    int i = start+1;
    int current = data[pi];
    data[pi] = data[start];
    data[start] = current;
    while(i <= gt){
	    if(data[i] == data[lt]){
        i++;
	    }
	    else if (data[i] < data[lt]){
        current = data[i];
        data[i] = data[lt];
        data[lt] = current;
        i++;
        lt++;
	    }
	    else{
        current = data[i];
        data[i] = data[gt];
        data[gt] = current;
        gt--;
	    }
    }
    int[] ans = new int[]{lt,gt};
    return ans;
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length - 1;
    int i  = partition(data,start,end);
    for(int j = 0; j < data.length;j++){
	    if(i == k){
        return data[k];
	    }
	    else if(i < k){
        start = i + 1;
        i = partition(data,start,end);
	    }
	    else{
        end = i -1;
        i = partition(data,start,end);
	    }
    }
    return -1;
  }

  public static int newQuickSelect(int[] data, int k){
    int start = 0;
    int end = data.length - 1;
    int[] info  = DFPartition(data,start,end);
    for(int j = 0; j < data.length;j++){
	    if(info[0] == k){
        return data[k];
	    }
	    else if(info[0] < k){
        start = info[0] + 1;
        info = DFPartition(data,start,end);
	    }
	    else{
        end = info[0] -1;
        info = DFPartition(data,start,end);
	    }
    }
    return -1;
  }

  public static void oldQuickSort(int[] data){
    oldQuickSortHelp(data,0,data.length -1);
  }

  private static void oldQuickSortHelp(int[] data, int start, int end){
    if(end - start + 1 > 1){
	    int index = partition(data, start, end);
	    quickSortHelp(data,start,index);
	    quickSortHelp(data,index+1,end);
    }
  }

  public static void quicksort(int[] data){
    quickSortHelp(data,0,data.length -1);
  }

  private static void quickSortHelp(int[] data, int start, int end){
    if(end - start>0 && end - start <= 10 ){
      newInsertionsort(data,start,end);
    }
    else if(end - start > 10){
	    int[]  info = DFPartition(data, start, end);
	    quickSortHelp(data,start,info[0]-1);
	    quickSortHelp(data,info[1],end);
    }
  }

    
  public static void newInsertionsort(int[] data, int lo, int hi){
    for(int i = lo+1;i <= hi;i++){
	    int pivot = data[i];
	    int j = i-1;
	    while(j >= lo && data[j] > pivot){
        data[j+1] = data[j];
        j--;
	    }
	    data[j+1] = pivot;
    }
  }

  public static void main(String[] args){
    int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
    /*	System.out.println(newQuickSelect( ary , 0 ));// would return 0
        System.out.println(newQuickSelect( ary , 1 ));//  would return 2
        System.out.println(newQuickSelect( ary , 2 ));//  would return 5
        System.out.println(newQuickSelect( ary , 3 ));//  would return 10
        System.out.println(newQuickSelect( ary , 4 ));//  would return 15
        System.out.println(newQuickSelect( ary , 5 ));//  would return 23
        quickSort(ary);*/
    quicksort(ary);
    System.out.println(java.util.Arrays.toString(ary));
  }
}
