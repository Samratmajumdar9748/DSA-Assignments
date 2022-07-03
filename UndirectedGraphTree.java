import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class UndirectedGraphTree {

    private int vertexCount;
    private static LinkedList<Integer> adj[];

    UndirectedGraphTree(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        if (!isValidIndex(v) || !isValidIndex(w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isValidIndex(int i) {
        // Write code here
        if (i <vertexCount && i>=0 )
            return true;
        else
            return false;

    }

    private boolean isCyclic(int v, boolean visited[], int parent) {
        // Write code here
        //Visit the node
        visited[v]= true;

        Iterator<Integer> it= adj[v].iterator();

        // Recur for all its neighbours and Visit them(DFS)

        while (it.hasNext()){

            int neighbour= it.next();
            //Proceed only if the neighbour is a valid vertex
            if (isValidIndex(neighbour)){
                //If not visited, recur for all its neighbours and check for visited
                if (!visited[neighbour]){

                    if (isCyclic(neighbour,visited,v))
                        return true;
                }
                // if a neighbour is visited and its not the parent node --> it has been reached from a different path
                // then return false
                else if ( neighbour!=parent ){
                    return true;
                }

            }
            else  // the neighbour is not reachable from the vertex so returning true for disconnected.
                return true;


        }
        return false;

    }

    public boolean isTree() {
        // Write Code here

        // set initial visited to false
        boolean visited[] = new boolean[vertexCount];
        for (int i=0; i<vertexCount; i++){
            visited[i]=false;
        }

        //check if cyclic
        if (isCyclic(0,visited,-1)){
            return false;
        }

        // check if all the nodes were visited or not
        for (boolean i:visited) {
            if (!i)
                return false;
        }

        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Get the number of nodes from the input.
        int noOfNodes =  sc.nextInt();
        // Get the number of edges from the input.
        int noOfEdges = sc.nextInt();



        UndirectedGraphTree graph = new UndirectedGraphTree(noOfNodes);
        // Adding edges to the graph
        for (int i = 0; i <noOfEdges; ++i) {
            graph.addEdge(sc.nextInt(),sc.nextInt());
        }
        if (noOfEdges!= noOfNodes-1){
            System.out.println("No");
            return;
        }
        if (graph.isTree()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
