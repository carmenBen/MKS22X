public class Recursion{
    //1.1a factorial
    public int fact(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n <= 1){
	    return 1;
	}
	return fact(n - 1) * n;
    }

    //1.1b Fibonacci
    public int fib(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	if(n == 1){
	    return 1;
	}
	return fib(n - 1) + fib(n - 2);
    }

    public int fibHelp(int o, int p, int t){
	return 0;
    }

    //1.1c Square Root go in terms of percent diff
    public double sqrt(double n){
	return 0.0;
    }

    public static void main(String[] args){

    }
}
