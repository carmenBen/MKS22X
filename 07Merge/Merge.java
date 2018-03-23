public class Merge{
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
        newMsort(data,temp,0,data.length-1);
    }
    
    private static void msort(int[] data,int[] temp, int lo, int hi){
	if(lo >= hi){
	    return;
	}
	for(int i = lo;i <=hi;i++){
	    temp[i] = data[i];
	}
	int mid =(lo+hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,hi);
    }
        
    private static void newMsort(int[] data,int[] temp, int lo, int hi){
	if((hi - lo) < 20){
	    newInsertionsort(data,lo,hi);
	    return;
	}
	for(int i = lo;i <=hi;i++){
	    temp[i] = data[i];
	}
	int mid =(lo+hi)/2;
	newMsort(temp,data,lo,mid);
	newMsort(temp,data,mid+1,hi);
	merge(data,temp,lo,hi);
    }

    public static void merge(int[] data,int[] temp,int lo,int hi){
	int mid =(lo + hi)/2;
	int f = 0;
	int s = 1;
	for(int i =lo;i <= hi;i++){
	    if(mid+s <= hi&&(lo+f>mid||temp[lo+f] > temp[mid+s])){
		data[i] = temp[mid+s];
		s++;
	    }
	    else{
		data[i] = temp[lo+f];
		f++;
	    }
	}
    }

    public static void insertionsort(int[] data, int lo, int hi){
	for(int i = lo+1;i <= hi;i++){
	    for(int j = lo;j < i;j++){
		if(data[i] < data[j]){
		    int temp = data[i];
		    for(int k = i;k > j;k--){
			data[k] = data[k - 1];
		    }
		    data[j] = temp;
		}
	    }
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
    /*
    public static void main(String[] args){
	int[]ary = { 2, 10, 15, 23, 0,  5,77,4,2,7,767,2}; //sorted :  {0,2,5,10,15,23}
	//mergesort(ary);
	//newInsertionsort(ary,1,5);
	System.out.println(java.util.Arrays.toString(ary));
	}*/
}
