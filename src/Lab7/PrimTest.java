package Lab7;

public class PrimTest {
    public static void main(String args[]) {

        Graph g = new Graph(6);
        g.addEdge('A','B',3);
        g.addEdge('C','B',6);
        g.addEdge('D','B',1);
        g.addEdge('A','E',2);
        g.addEdge('A','D',4);
        g.addEdge('E','D',5);
        g.addEdge('C','D',8);
        g.addEdge('C','F',2);

        // apply Prim's algorithm to it
        Graph mcst = g.prim();

        // print a list of the edges in the MCST
        System.out.println(mcst);
    }
}