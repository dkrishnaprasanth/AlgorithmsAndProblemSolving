import java.util.Scanner;

public class Solution {
    
    static int findMinVertex(int[] weight, boolean[] visited) {
        int minVertex = -1;
        
        for (int i = 0; i < weight.length; i++) {
            if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
                minVertex = i;
            }
        }
        
        return minVertex;
    }
    
    static void DijkstraAlgo(int[][] adjMatrix, int V) {
        
        int[] parent = new int[V];
        int[] weight = new int[V];
        boolean[] visited = new boolean[V];
        
        parent[0] = -1;
        weight[0] = 0;
        
        for (int i = 1; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < V - 1; i++) {
            int minVertex = findMinVertex(weight, visited);
            visited[minVertex] = true;
            
            for (int j = 0; j < V; j++) {
                if (!visited[j] && adjMatrix[minVertex][j] > 0) {
                    if (weight[minVertex] + adjMatrix[minVertex][j] < weight[j]) {
                        weight[j] = weight[minVertex] + adjMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }
        
        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + weight[i]);
        }
        
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();
        int[][] adjMatrix = new int[V][V];
        
        for (int i = 0; i < E; i++) {
            int src = in.nextInt(), des = in.nextInt(), weight = in.nextInt();
            
            adjMatrix[src][des] = weight;
            adjMatrix[des][src] = weight;
        }
        
        int c = in.nextInt();
        DijkstraAlgo(adjMatrix, V);
		
	}
}