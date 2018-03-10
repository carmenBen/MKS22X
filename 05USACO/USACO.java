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


  public static int silver(String filename){
    //read file in
    char[][] data;
    int stepsTaken = 0;
    int[] abcd = new int[4];
    int[] rcd = new int[3];
    data = new char[0][0];
    try{
	    File info = new File(filename);
	    Scanner inf = new Scanner(info);
	    for(int i = 0;i < 3;i++){
        rcd[i] = inf.nextInt();
	    }
	    data = new char[rcd[0]][rcd[1]];
	    String[] current = new String[rcd[1]];
	    inf.nextLine();
	    for(int r = 0;r < rcd[0];r++){
        current = inf.nextLine().split("");
        for(int c = 0;c < rcd[1];c++){
          data[r][c] = current[c].charAt(0);
        }
	    }
	    for(int i = 0;i < 4;i++){
        abcd[i] = inf.nextInt() - 1;
	    }
	    int[][] b1 = new int[rcd[0]][rcd[1]];
	    int[][] b2 = new int[rcd[0]][rcd[1]];
	    for(int r = 0;r < rcd[0];r++){
        for(int c = 0;c < rcd[1];c++){
          b1[r][c] = 0;
          b2[r][c] = 0;
        }
	    }
      b1[abcd[0]][abcd[1]] = 1;
	    int answer = 0;
	    for(int i = 0; i < rcd[2];i++){
        for(int r = 0;r < rcd[0];r++){
          for(int c = 0;c < rcd[1];c++){
            //check if theres a tree there
            if(data[r][c] != '*' && i % 2 == 0){
              //if it was possible before then not anymore
              if(b1[r][c] != 0){
                b2[r][c] = 0;
              }
              else{//updated board with sum of previous surrounding moves
                int updatedNum = 0;
                if(r + 1 < rcd[0]){
                  updatedNum += b1[r+1][c];
                }
                if(r-1 >= 0){
                  updatedNum += b1[r-1][c];
                }
                if(c+1 < rcd[1]){
                  updatedNum += b1[r][c+1];
                }
                if(c - 1 >= 0){
                  updatedNum += b1[r][c-1];
                }
                b2[r][c] = updatedNum;
              }
            }
            else if(data[r][c] != '*'){
              if(b2[r][c] != 0){
                b1[r][c] = 0;
              }
              else{//updated board with sum of previous surrounding moves
                int updatedNum = 0;
                if(r + 1 < rcd[0]){
                  updatedNum += b2[r+1][c];
                }
                if(r-1 >= 0){
                  updatedNum += b2[r-1][c];
                }
                if(c+1 < rcd[1]){
                  updatedNum += b2[r][c+1];
                }
                if(c - 1 >= 0){
                  updatedNum += b2[r][c-1];
                }
                b1[r][c] = updatedNum;
              }
            }
          }
        }
      }
    
      if(rcd[2] % 2 ==1){
        answer = b2[abcd[2]][abcd[3]];
      }
      else{
        answer = b1[abcd[2]][abcd[3]];
      }
      return answer;
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      System.exit(1);
    }
    /*String test = "";
      for(int r = 0;r<data.length;r++){
      for(int c= 0;c<data[0].length;c++){
      test+= data[r][c];
      }
      test += "\n";
      }
      System.out.println(test);*/
    return 0;
  }

  public static void main(String[] args){
    //System.out.println(bronze("text.txt"));
    System.out.println(silver("text.txt"));
  }
}
