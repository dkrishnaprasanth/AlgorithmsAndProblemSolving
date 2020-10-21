import java.util.*;

public class Solution {

    static class ListVertex {
        int vertex;
        int weight;
        
        ListVertex(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        } 
    }
    
    static int minVertex(int[] parent, int[] weight, boolean[] visited) {
        
        int minVertex = -1;
        for (int i = 0; i < parent.length; i++) {
            if (!visited[i] && (minVertex == -1 || (weight[minVertex] > weight[i]))) {
                minVertex = i;
            }
        }
        
        return minVertex;
    }
    
    static void PrimsAlgo(ArrayList<ArrayList<ListVertex>> list, int V) {
        
        int[] parent = new int[V];
        int[] weight = new int[V];
        boolean[] visited = new boolean[V];
        
        parent[0] = -1;
        weight[0] = 0;
        
        for (int i = 1; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < V; i++) {
            int Vertex = minVertex(parent, weight, visited);
            visited[Vertex] = true;
            
            for (int j = 0; j < list.get(Vertex).size(); j++) {
                if (!visited[list.get(Vertex).get(j).vertex] && list.get(Vertex).get(j).weight < weight[list.get(Vertex).get(j).vertex]) {
                    weight[list.get(Vertex).get(j).vertex] = list.get(Vertex).get(j).weight;
                    parent[list.get(Vertex).get(j).vertex] = Vertex;
                }
            }
        }
        
        for (int i = 1; i < V; i++) {
            System.out.println(Math.min(i, parent[i]) + " " + Math.max(i, parent[i]) + " " + weight[i]);
        }
        
        
    }
    
    static void PrimsAlgo(int[][] adjMatrix, int V) {
        
        int[] parent = new int[V];
        int[] weight = new int[V];
        boolean[] visited = new boolean[V];
        
        parent[0] = -1;
        weight[0] = 0;
        
        for (int i = 1; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < V; i++) {
            int Vertex = minVertex(parent, weight, visited);
            visited[Vertex] = true;
            
            for (int j = 0; j < V; j++) {
                if (!visited[j] && adjMatrix[Vertex][j] > 0) {
                    if (weight[j] > adjMatrix[Vertex][j]) {
                        weight[j] = adjMatrix[Vertex][j];
                        parent[j] = Vertex;
                    }
                }
            }
        }
        
        for (int i = 1; i < V; i++) {
            System.out.println(Math.min(i, parent[i]) + " " + Math.max(i, parent[i]) + " " + weight[i]);
        }
        
        
    }
    
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();
        
        ArrayList<ArrayList<ListVertex>> list = new ArrayList<>();
        int[][] adjMatrix = new int[V][V];
        
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<ListVertex>());
        }
        
        for (int i = 0; i < E; i++) {
            int src = in.nextInt(), des = in.nextInt(), weight = in.nextInt();
            list.get(src).add(new ListVertex(des, weight));
            list.get(des).add(new ListVertex(src, weight));
            adjMatrix[src][des] = weight;
            adjMatrix[des][src] = weight;
        }
        
        //PrimsAlgo(list, V);
        PrimsAlgo(adjMatrix, V);
	}
}
