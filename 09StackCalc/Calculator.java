public class Calculator{
  public static double eval(String text){
    String[] tokens = text.split(" ");
    Stacks numbers = new Stacks();
    for(int i = 0;i < tokens.length;i++){
      String current = tokens[i];
      if(current.equals("+")|| current.equals("-")||  current.equals("*")|| current.equals("/")|| current.equals("%")){
        String answer = "" + compute(numbers.pop(),numbers.pop(),current);
        numbers.push(answer);
      }
      else{
        numbers.push(current);
      }
    }
      return numbers.pop();
  }

  public static double compute(double y, double x, String op){
    if(op.equals("+")){
      return x + y;
    }
    else if(op.equals("-")){
      return x - y;
    }
      else if(op.equals("*")){
      return x*  y;
    }
      else if(op.equals("/")){
      return x/ y;
    }
    else{
      return x%  y;
    }
  }

    /*  public static void main(String[] args){
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }*/
}
