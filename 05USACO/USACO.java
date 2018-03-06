import java.util.*;
import java.io.*;

public class USACO{
    public static int bronze(String filename){
	int[][] data;
	ArrayList<String> lines = new ArrayList<String> ();
	int[] rcen = new int[4];
	try{
	    File info = new File(filename);
	    Scanner inf = new Scanner(info);
	    for(int i = 0;i < 4;i++){
		rcen[i] = inf.nextInt();
	    }
	    while(inf.hasNextLine()){
		lines.add(inf.nextLine());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	System.out.println(rcen[0]);/*
				      data = new int[lines.size()][lines.get(0).length()];
	for(int r = 0;r<lines.size();r++){
	    for(int c= 0;c<lines.get(0).length();c++){
	        int current = lines.get(r).charAt(c);
		data[r][c] = current;
	    }
	    }*/
	return 0;
    }
    //public static int silver(String filename);

    public static void main(String[] args){
        bronze("text.txt");
    }
}
