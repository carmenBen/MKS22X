public class Sorts{

    public static void radixSort(MyLinkedListImproved<Integer> data){
        String max = "" +  data.get(data.max());
	int maxi = max.length();
	System.out.println(maxi);
	MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved<Integer>[10];
	for(int i = 0;i < maxi;i++){
	    for(Integer n:data){
		int l = n%(10*(i+1));
		buckets[l].add(n);
		data.remove(n);
	    }
	    for(int j = 0;j < 10;j++){
		data.extend(buckets[j]);
	    }
	}
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	a.add(Integer.valueOf(0));
	a.add(Integer.valueOf(533));
	a.add(Integer.valueOf(12));
        radixSort(a);
    }

}
