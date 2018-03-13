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
	    if(pivot > arr[i]){
		i++;
		small++;
	    }
	    else{
		current = arr[i];
		arr[i] = arr[large];
		arr[large] = current;
		large--;
	    }
	}
	//shift everything down a spot and move pivot to correct position
	for(int j = 0;j < small;j++){
	    arr[j] = arr[j+1];
	}
	arr[small] = pivot;
	return small;
    }

    public static int quickSelect(int[] data, int k){
	boolean found = false;
	while(!found){
	    if(k - 1 == partition(data,0,data.length - 1)){
		found = true;
	    }
	}
	return data[k];
    }

    public static void main(String[] args){
	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	quickSelect( ary , 0 );// would return 0
	quickSelect( ary , 1 );//  would return 2
	quickSelect( ary , 2 );//  would return 5
	quickSelect( ary , 3 );//  would return 10
	quickSelect( ary , 4 );//  would return 15
	quickSelect( ary , 5 );//  would return 23
    }
}
