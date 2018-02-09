public class Driver{
    public static void main(String[] args){
	QueenBoard test = new QueenBoard(4);
	System.out.println(test);
	System.out.println(test.addQueen(0,0));
	System.out.println(test);
	System.out.println(test.addQueen(0,1));
	System.out.println(test);
	test.removeQueen(0,0);
	System.out.println(test);
    }
}
