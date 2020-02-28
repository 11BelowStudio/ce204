package lab6;

public class GraphMain {
    public static void main(String args[]){
        Graph g = new Graph(5);
        g.addEdge('A','B',1);
        g.addEdge('B','C',2);
        g.addEdge('C','D',3);
        g.addEdge('D','A',4);
        g.addEdge('E','A',10);
        g.addEdge('B','C',4);
        g.addEdge('D','E',6);
        //g.addEdge('D','F',12);


        System.out.println(g.edgeWeight('C','D'));
        System.out.println(g.edgeWeight('E','A'));
        System.out.println(g.edgeWeight('B','E'));

        System.out.println(g);


    }
}
