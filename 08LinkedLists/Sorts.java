import java.util.*;
public class Sorts{

    public static void radixSort(MyLinkedListImproved<Integer> data){
        String max = "" +  data.get(data.max());
	int maxi = max.length();
	ArrayList<MyLinkedListImproved<Integer>> buckets = new ArrayList<MyLinkedListImproved<Integer>>();
  for(int i = 0;i <10;i++){
    buckets.add(new MyLinkedListImproved<Integer>());
  }
	for(int i = 0;i < maxi;i++){
	    for(Integer n:data){
        String check = "" + n;
        int l = 0;
        if(check.length() - i - 1 >= 0){
          l = check.charAt(check.length()-i-1) - '0';
        }
        buckets.get(l).add(n);
        data.remove(n);
	    }
	    for(int j = 0;j < 10;j++){
        data.extend(buckets.get(j));
	    }
	}
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	a.add(Integer.valueOf(1));
	a.add(Integer.valueOf(533));
	a.add(Integer.valueOf(12));
	a.add(Integer.valueOf(1));
	a.add(Integer.valueOf(533));
	a.add(Integer.valueOf(12));
  a.add(Integer.valueOf(44));
	a.add(Integer.valueOf(238));
	a.add(Integer.valueOf(999));
        radixSort(a);
        System.out.println(a);
    }

}
