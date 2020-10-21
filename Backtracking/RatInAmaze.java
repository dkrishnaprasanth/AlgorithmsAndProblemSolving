
public class Solution {
	
	
	static void ratInAMazeHelper(int maze[][],int rat[][],int n,int row,int col){
        if(row==n-1&&col==n-1){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(rat[i][j]+" ");
                }
            }
            System.out.println();
            return;
        }
        if(col>=0&&col<=n-1){
            if((col<n-1)&&maze[row][col+1]!=0&&rat[row][col+1]!=1){
                rat[row][col+1] = 1;
                ratInAMazeHelper(maze,rat,n,row,col+1);
                rat[row][col+1] = 0;
            }
            if((col>0)&&maze[row][col-1]!=0&&rat[row][col-1]!=1){
                rat[row][col-1] = 1;
                ratInAMazeHelper(maze,rat,n,row,col-1);
                rat[row][col-1] = 0;
            }   
        }
        if(row>=0&&row<=n-1){
            if((row<n-1)&&maze[row+1][col]!=0&&rat[row+1][col]!=1){
                rat[row+1][col] = 1;
                ratInAMazeHelper(maze,rat,n,row+1,col);
                rat[row+1][col] = 0;
            }  
            if((row>0)&&maze[row-1][col]!=0&&rat[row-1][col]!=1){
                rat[row-1][col] = 1;
                ratInAMazeHelper(maze,rat,n,row-1,col);
                rat[row-1][col] = 0;
            }
        }
    }
	public static void ratInAMaze(int maze[][]){
        int n = maze.length;
        int[][] rat = new int[n][n];
        rat[0][0] = 1;
        ratInAMazeHelper(maze,rat,n,0,0);
		
	}

	
	
}
