import java.io.*;

public class Driver{

    public static void main(String[]args){
        MazeSolver f;
        f = new MazeSolver("maze.txt");//true animates the maze.
        f.animate(true);
        System.out.println(f.solve(3));

        System.out.println(f);
    }
}
