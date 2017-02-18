package NYUProgTeam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Topological Sort
 *
 * Feb 17, 2017. NYU ProgTeam
 */

 public class OrderingTasks {

    private int V;
    private LinkedList<Integer> adj[];

    public OrderingTasks(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj[v].add(w); }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void topologicalSort()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
        OrderingTasks g;
        Scanner sc=new Scanner(System.in);

        int firstTwoNumber = 2;
        int numberOfNodes = 0;
        int numberOfTasks = 0;
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(firstTwoNumber == 2){
                numberOfNodes = n;
                firstTwoNumber--;
            }else if(firstTwoNumber == 1){
                numberOfTasks = n;
                firstTwoNumber--;
                g = new OrderingTasks(numberOfTasks);
            }
            else{

            }
            System.out.println(n);
        }
    }
}
