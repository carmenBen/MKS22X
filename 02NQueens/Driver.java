public class Driver{
  public static void main(String[] args){
    QueenBoard test = new QueenBoard(5);
    System.out.println(test);
    System.out.println(test.countSolutions());
    System.out.println(test);
    System.out.println(test.solve());
    System.out.println(test);
  }
}
