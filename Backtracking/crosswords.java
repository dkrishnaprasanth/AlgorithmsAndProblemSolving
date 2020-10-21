

import java.util.Scanner;

public class Main {

	static void print(char[][] grid){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(grid[i][j]+"");
            }
            System.out.println();
        }
    }
    static boolean isvalidvertical(String s,char[][] grid,int row,int col){
        if((row+s.length())>10){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(grid[i+row][col] == '+'){
                return false;
            }
            if(grid[i+row][col]>='A'&&grid[i+row][col]<='Z'){
            	if(grid[i+row][col] != s.charAt(i)){
            		return false;
            	}
            }
        }
        return true;
    }
    static boolean isvalidhorizontal(String s,char[][] grid,int row,int col){
        if(col+s.length()>10){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(grid[row][i+col] == '+'){
                return false;
            }
            if(grid[row][i+col]>='A'&&grid[row][i+col]<='Z'){
            	if(grid[row][i+col] != s.charAt(i)){
            		return false;
            	}
            }
        }
        return true;
    }
    static void setvertical(String s,char[][] grid,int row,int col,boolean[] helper){
        for(int i=0;i<s.length();i++){
            if(grid[i+row][col] == '-'){
                grid[i+row][col] = s.charAt(i);
                helper[i] = true;
            }
            else if(grid[i+row][col] == s.charAt(i)){
                helper[i] = false;
            }
        }
    }
    static void resetvertical(String s,char[][] grid,int row,int col,boolean[] helper){
        for(int i=0;i<s.length();i++){
            if(helper[i] == true){
                grid[i+row][col] = '-';
            }
        }
    }
    static void sethorizontal(String s,char[][] grid,int row,int col,boolean[] helper){
        for(int i=0;i<s.length();i++){
            if(grid[row][i+col] == '-'){
                grid[row][i+col] = s.charAt(i);
                helper[i] = true;
            }
            else if(grid[row][i+col] == s.charAt(i)){
                helper[i] = false;
            }
        }
    }
    static void resethorizontal(String s,char[][] grid,int row,int col,boolean[] helper){
        for(int i=0;i<s.length();i++){
            if(helper[i] == true){
                grid[row][i+col] = '-';
            }
        }
    }
    static void crossword(char[][] grid, String[] words,int index){
        if(index == words.length){
            print(grid);
            System.exit(0);
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(grid[i][j] == '-'||grid[i][j] == words[index].charAt(0)){
                    if(isvalidvertical(words[index],grid,i,j)){
                        boolean[] helper = new boolean[words[index].length()];
                        setvertical(words[index],grid,i,j,helper);
                        crossword(grid,words,index+1);
                        resetvertical(words[index],grid,i,j,helper);
                    }
                    if(isvalidhorizontal(words[index],grid,i,j)){
                        boolean[] helper = new boolean[words[index].length()];
                        sethorizontal(words[index],grid,i,j,helper);
                        crossword(grid,words,index+1);
                        resethorizontal(words[index],grid,i,j,helper);
                    }
                }
            }
        }
    }
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] grid = new char[10][10];
        for(int i=0;i<10;i++){
            String s = in.nextLine();
            for(int j=0;j<10;j++){
                grid[i][j] = (char)s.charAt(j);
            }
        }
        String[] words = in.nextLine().split(";");
        crossword(grid,words,0);
        in.close();
	}

}
