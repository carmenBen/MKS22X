import java.util.*;
import java.io.*;

public class USACO{
    public static int bronze(String filename){
	//read file in
	int[][] data;
	ArrayList<String> lines = new ArrayList<String> ();
	int[] rcen = new int[4];
	data = new int[0][0];
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
	    for(int r = Integer.parseInt(current[0])-1;r < Integer.parseInt(current[0])+ 2;r++){
		for(int c = Integer.parseInt(current[1])-1;c< Integer.parseInt(current[1])+2;c++){
		    if(data[r][c] > highest){
			highest = data[r][c];
		    }
		}
	    }
	    while(Integer.parseInt(current[2]) > 0 ){
		for(int r = Integer.parseInt(current[0])-1;r < Integer.parseInt(current[0])+2;r++){
		    for(int c = Integer.parseInt(current[1])-1;c< Integer.parseInt(current[1])+2;c++){
			if(data[r][c] == highest){
			    data[r][c]--;
			}
		    }
		}
		highest--;
		current[2] = (Integer.parseInt(current[2]) - 1) +"";
	    }
	    
	}
	//change depth
	for(int r = 0;r< rcen[0];r++){
	    for(int c = 0;c< rcen[1];c++){
		data[r][c] -= rcen[2];
	    }
	}
        
	
	//calculate volume and return
	int depth = 0;
	for(int r = 0;r < rcen[0];r++){
	    for(int c = 0;c< rcen[1];c++){
		if(data[r][c] < 0){
		    depth+= -1*data[r][c];
		}
	    }
	}
	return depth*72*72;
    }
    //public static int silver(String filename);

    public static void main(String[] args){
	System.out.println(bronze("text.txt"));
    }
}
