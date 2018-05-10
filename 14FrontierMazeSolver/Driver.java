import java.io.*;

public class Driver{

    public static void main(String[]args){
        MazeSolver f;
        f = new MazeSolver("maze.txt");//true animates the maze.
        f.setType(false);
        f.animate(true);
        System.out.println(f.solve(2));

        System.out.println(f);
    }
}
