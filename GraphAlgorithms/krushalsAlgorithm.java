import java.util.*;

public class Solution {

    static class Edge implements Comparable<Edge> {
        int vertex1, vertex2, weight;
        
        Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    
    static int parentVertex(int[] parent, int vertex) {
        
        while (parent[vertex] != vertex) {
            vertex = parent[vertex];
        }
        
        return vertex;
    }
    
    static Edge[] KurskalsAlgo(Edge[] edgeList, int V, int E) {
        
        int[] parent = new int[V];
        
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        
        int count = 0, i = 0;
        Edge[] Mst = new Edge[V - 1];
        
        while(count < (V - 1)) {
            Edge currentEdge = edgeList[i];
            
            int parentOfVertex1 = parentVertex(parent, currentEdge.vertex1);
            int parentOfVertex2 = parentVertex(parent, currentEdge.vertex2);
            
            if (parentOfVertex1 != parentOfVertex2) {
                Mst[count] = currentEdge;
                count++;
                parent[parentOfVertex2] = parentOfVertex1;
            }
            i++;
        }
        
        return Mst;
    }
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();
        
        Edge[] edgeList = new Edge[E];
        
        for (int i = 0; i < E; i++) {
            edgeList[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
        }
        
        Arrays.sort(edgeList);
        
        Edge[] output = KurskalsAlgo(edgeList, V, E);
        
        for (int i = 0; i < output.length; i++) {
            System.out.println(Math.min(output[i].vertex1, output[i].vertex2) + " " + Math.max(output[i].vertex1, output[i].vertex2) + " " + output[i].weight);
        }
	}
}