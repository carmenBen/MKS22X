import java.util.*;

public class RunningMedian{
    private MyHeap<Double> max;
    private MyHeap<Double> min;
    private Double median;
    
    public RunningMedian(){
	max = new MyHeap<Double>();
	min = new MyHeap<Double>(false);
    }

    public int size(){
	return max.size() + min.size();
    }

    public Double getMedian(){
	if(max.size() == 0 && min.size() == 0){
	    throw new NoSuchElementException();
	}
	if((max.size() - min.size()) == 1){
	    //System.out.println("1");
	    median = max.peak();
	}
	else if((min.size() - max.size()) == 1){
	    //System.out.println("2");
	    median = min.peak();
	}
	else{
	    //System.out.println("3");
	    median = (max.peak() + min.peak()) / 2;
	}
	return median;
    }

    public void add(Double val){
	// add
	if(max.size() == 0 && min.size() == 0){
	    max.add(val);
	    median = val;
	    return;
	}
	if(val > median){
	    min.add(val);
	}
	else{
	    max.add(val);
	}
	//check and swap
	if((max.size() - min.size()) >1){
	    min.add(max.remove());
	}
	else if((min.size() - max.size()) > 1){
	    max.add(min.remove());
	}	
    }

    /*    public static void main(String[] args){
	RunningMedian test = new RunningMedian();
	//System.out.println(test.getMedian());
	test.add(1.0);
	System.out.println(test.getMedian());
	test.add(3.0);
	System.out.println(test.getMedian());
	test.add(5.0);
	System.out.println(test.getMedian());
	test.add(9.0);
	System.out.println(test.getMedian());
	System.out.println(test.size());
	}*/
}
