import java.io.*;

public class Driver{

    public static void main(String[]args){
        MazeSolver f;
        f = new MazeSolver("data1.dat");//true animates the maze.
        
        f.animate(true);
        System.out.println(f.solve(0));

        System.out.println(f);
    }
}
