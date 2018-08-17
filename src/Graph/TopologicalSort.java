package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    Graph g;
    int V;
    LinkedList<Integer>[] adj; // Adjacency List

    public TopologicalSort(Graph g){
        this.g = g;
        this.V = g.getNumberOfVertices();
        this.adj = g.getAdjacencyList();
    }

    public void topologicalSort() {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[this.V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive recursiveHelper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < this.V; i++)
            if (visited[i] == false)
                topologicalSortRecursiveUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    // A recursive function used by topologicalSort
    public void topologicalSortRecursiveUtil(int v, boolean visited[], Stack stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = this.adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortRecursiveUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    //TODO: add iterative function
    public void topologicalSortIterativeUtil(int v, boolean visited[], Queue queue){

    }


    //test
    public static void main(String[] args) {
        Graph g = Graph.sampleGraph();
        TopologicalSort ts = new TopologicalSort(g);
        ts.topologicalSort();
    }
}
