
public class Solution {
        static boolean ispossible(int[][] board , int n, int row,int col){
            for(int i=row-1;i>=0;i--){
                if(board[i][col] == 1){
                    return false;
                }
            }
            for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
                if(board[i][j] == 1){
                    return false;
                }
            }
            for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
                if(board[i][j] == 1){
                    return false;
                }
            }
            return true;
        }
		static void NQueenHelper(int[][] board , int n,int row){
            if(row == n){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        System.out.print(board[i][j]+" ");
                    }
                }
                System.out.println();
                return;
            }
            for(int i=0;i<n;i++){
                if(ispossible(board,n,row,i)){
                    board[row][i] = 1;
                    NQueenHelper(board,n,row+1);
                    board[row][i] = 0;
                }
            }
        }
public static void placeNQueens(int n){
    int[][] board = new int[n][n];
    NQueenHelper(board , n ,0);
	}
	
}
