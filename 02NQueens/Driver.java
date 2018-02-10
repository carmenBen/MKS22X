public class Driver{
  public static void main(String[] args){
    QueenBoard test = new QueenBoard(4);
    System.out.println(test);
    System.out.println(test.solve());
    System.out.println(test);
    QueenBoard testt = new QueenBoard(2);
    System.out.println(testt);
    System.out.println(testt.solve());
    System.out.println(testt);
  }
}
