import java.util.*;
import java.io.*;

public class USACO{
    public static int bronze(String filename){
	//read file in
	int[][] data;
	ArrayList<String> lines = new ArrayList<String> ();
	int[] rcen = new int[4];
	try{
	    File info = new File(filename);
	    Scanner inf = new Scanner(info);
	    for(int i = 0;i < 4;i++){
		rcen[i] = inf.nextInt();
	    }
	    data = new int[rcen[0]][rcen[1]];
	    String[] current = new String[rcen[1]];
	    inf.nextLine();
	    for(int r = 0;r < rcen[0];r++){
		current = inf.nextLine().split(" ");
		for(int c = 0;c < rcen[1];c++){
		    data[r][c] = Integer.parseInt(current[c]);
		}
	    }
	    while(inf.hasNextLine()){
		lines.add(inf.nextLine());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}

	//follow instructions in file
	for(int i = 0;i < lines.size();i++){
	    String[] current = new String[3];
	    current = lines.get(i).split(" ");
	    int highest = 0;
	    for(int r = current[0];r < current[0] + 3;r++){
		for(int c = current[1];c< current[1] + 3;c++){
		    if(data[r][c] > highest){
			highest = data[r][c];
		    }
		}
	    }
	    while(current[2] > -1){
		for(int r = current[0];r < current[0] + 3;r++){
		    for(int c = current[1];c< current[1] + 3;c++){
			if(
			   }
		    }
		}
	    }
	    //change depth

		    //calculate volume and return
	
	return 0;
    }
    //public static int silver(String filename);

    public static void main(String[] args){
        bronze("text.txt");
    }
}
