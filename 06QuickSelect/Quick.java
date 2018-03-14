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

    public static int quickSelect(int[] data, int k){
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

    public static void quickSort(int[] data){
	/*int[] data = new int[ary.length];
	for(int i = 0;i < ary.length;i++){
	    data[i] = quickSelect(ary, i);
	}
	for(int i = 0;i < ary.length;i++){
	    ary[i] = data[i];
	}*/
	int start = 0;
	int end = data.length - 1;
	int i  = partition(data,start,end);
	for(int j = 0; j < data.length;j++){
	    if(i < data.length/2){
		start = i + 1;
		i = partition(data,start,end);
	    }
	    else if(i > data.length/ 2){
		end = i -1;
		i = partition(data,start,end);
	    }
	}
    }


    public static void main(String[] args){
	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	System.out.println(quickSelect( ary , 0 ));// would return 0
	System.out.println(quickSelect( ary , 1 ));//  would return 2
	System.out.println(quickSelect( ary , 2 ));//  would return 5
	System.out.println(quickSelect( ary , 3 ));//  would return 10
	System.out.println(quickSelect( ary , 4 ));//  would return 15
	System.out.println(quickSelect( ary , 5 ));//  would return 23
	quickSort(ary);
	System.out.println(java.util.Arrays.toString(ary));
    }
}
