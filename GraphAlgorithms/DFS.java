import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    
    
    static void DFS(int[][] adjMatrix, int V, int startVertex, boolean[] visited) {
        
        if (visited[startVertex]) {
            return;
        }
        visited[startVertex] = true;
        System.out.print(startVertex + " ");
        for (int i = startVertex; i < V; i++) {
            if (!visited[i] && adjMatrix[startVertex][i] == 1) {
                DFS(adjMatrix, V, startVertex, visited);
            }
        }
        
    }
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		int[][] adjMatrix = new int[V][V];
        
        for (int i = 0; i < E; i++) {
            int src = s.nextInt(), des = s.nextInt();
            adjMatrix[src][des] = 1;
            adjMatrix[des][src] = 1;
        }
        
        boolean[] visited = new boolean[V];
        
        DFS(adjMatrix, V, 0, visited);
	}
}