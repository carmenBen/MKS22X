import java.lang.*;
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
    return fibHelp(0,1,n);
  }

  private int fibHelp(int low, int total, int n){
    if(n == 0){
      return total;
    }
    return fibHelp(total, total + low, n-1);
  }

  //1.1c Square Root go in terms of percent diff
  public double sqrt(double n){
    if(n < 0){
	    throw new IllegalArgumentException();
    }
    if(n == 0){
      return 0;
    }
    return sqrtHelp(n, n/2);
  }

  private double sqrtHelp(double n, double guess){
    if(Math.abs(((guess*guess - n)/ n)) < 0.0000000001){
      return guess;
    }
    return sqrtHelp(n, (((n / guess) + guess) / 2));
  }
}
