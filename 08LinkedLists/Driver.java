public class Driver{
    public static void main(String[] args){
	MyLinkedList test = new MyLinkedList();
	System.out.println(test);
	test.add(3);
	test.add(5);
	test.add(5);
	System.out.println(test);
	Integer n = new Integer(5);
        test.remove(n);
	System.out.println(test);
	/*	System.out.println(test.get(1));
	System.out.println(test.set(1,10));
	System.out.println(test.get(1));
	System.out.println(test.size());*/
    }
}
