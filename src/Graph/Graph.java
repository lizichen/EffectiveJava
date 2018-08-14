package Graph;

import java.util.LinkedList;

public class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    //Constructor
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v,int w) {
        adj[v].add(w);
    }

    public int getNumberOfVertices(){
        return this.V;
    }

    public LinkedList<Integer>[] getAdjacencyList(){
        return this.adj;
    }

    /*
        [5]    [4]
       /  \   /  \
     [2]   [0]   [1]
       \         /
         \     /
          \   /
           [3]
     */
    public static Graph sampleGraph(){
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        return g;
    }
}
