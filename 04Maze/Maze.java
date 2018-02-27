import java.util.*;
import java.io.*;

public class Maze{
  public static void main(String[] args) throws FileNotFoundException{

    File info = new File("Maze1.txt");
    Scanner inf = new Scanner(info);
    String text = "";
    while(inf.hasNextLine()){
      text += inf.nextLine();
    }
    char[] chars = new char[text.length()];
    for(int i = 0;i < text.length();i++){
        chars[i] = text.charAt(i);
    }
    System.out.println(Arrays.toString(chars));
  }

}
