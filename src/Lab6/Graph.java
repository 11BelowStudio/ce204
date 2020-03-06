package Lab6;

public class Graph {

    private int numNodes;

    // vertices will be called A,B,...

    // adjacency list representation used
    // adjLists[0] will hold a reference to the first cell in a linked list containing
    //       details of the edges from A to all of its neighbours,
    // adjLists[1] will hold details of edges from B to its neighbours etc.

    private ListCell[] adjLists;

    // constructor to create a graph with n vertices and no edges
    public Graph(int n) {
        int i;
        numNodes = n;
        adjLists = new ListCell[n];
        for (i = 0; i<n; i++)
            adjLists[i] = null;
    }

    // try to add an edge (v1,v2) with weight w) - return true if succesful, false otherwise
    public boolean addEdge(char v1, char v2, int w) {
        // convert the vertex names into array positions
        int pos1 = getPosInt(v1);
        int pos2 = getPosInt(v2);

        // check if either of pos1 and pos2 is outside the array index range
        if (pos1 < 0 || pos2 < 0 || pos1 >= adjLists.length || pos2 >= adjLists.length){
            // if so, print an error message and return false
            System.out.println("bruh your positions are out of range");
            return false;
        } else if (v1==v2) {
            // vertices must be distinct - print a warning message and return false
            System.out.println("bruh you can't make an edge out of the same vertex twice");
            return false;
        } else if (neighbours(v1,v2)) {
            // edge is already present - print a warning error message and return false
            System.out.println("bruh this edge exists already smh my head");
            return false;
        } else { // add a new cell with values (v2,w) to the front of the list adjLists[pos1]
            adjLists[pos1] = new ListCell(v2, w, adjLists[pos1]);
            // also add a new cell with values (v1,w) to the front of the list adjLists[pos2] - need similar line to above
            adjLists[pos2] = new ListCell(v1,w,adjLists[pos2]);
            // added succesfully
            return true;
        }
    }

    private int getPosInt(char v) {
        return (int) v-'A';
    }

    public String toString() {
        // should return a string containing all of the edges in the graph with their weights
        // e.g. "(A,B,2), (A,C,3), (B,D,4), (B,A,2), (C,A,3), (D,B,4)"
        // code below is supplied just to allow file to compile
        //return "hello world";

        StringBuilder sb = new StringBuilder();
        boolean canPrefix = false; //can't prefix the first one with a comma
        for (int i = 0; i < adjLists.length; i++) {
            char currentVertex = (char) ('A' + i);
            ListCell current = adjLists[i];
            if (current != null) {
                sb.append(current.listCellPrinter(currentVertex,canPrefix));
                canPrefix = true;
            }
        }
        return sb.toString();
        // to convert the array position into a vertex name simply use something like
        // char vertex = 'A'+pos;
    }

    public boolean neighbours(char v1, char v2) {
        // should return true if there's an edge from v1 to v2
        // should return false if there's no such edge
        // need to search the linked list ajdLists[v1-'A'] to see if contains a node whose vertex variable is equal to v2
        // code below is supplied just to allow file to compile
        //return false;
        return doesEdgeExist(adjLists[v1 - 'A'], v2) || doesEdgeExist(adjLists[v2 - 'A'], v1);
    }

    private boolean doesEdgeExist(ListCell checkThis, char searchFor){
        return (findEdge(checkThis,searchFor) != null);
        //returns true if findEdge found the edge, false otherwise
        //essentially a wrapper for the findEdge function that returns boolean instead
    }

    private ListCell findEdge(ListCell checkThis, char searchFor){
        //continues searching until it reaches a null ListCell
        while (checkThis != null){
            if (checkThis.sameVertex(searchFor)){
                return checkThis;//returns true if the searched for vertex is found
            } else{
                checkThis = checkThis.getNext();
                //checks next ListCell if no match found
            }
        }
        return null;
        //null if it couldn't be found
    }

    public int edgeWeight(char v1, char v2) {
        // should return the weight of the edge from v1 to v2, or a default value (e.g. -1) if there's no such edge
        // again need to search the linked list adjLists[v1-'A'] but this time if a node whose vertex is v2 is found have to return its weight
        // code below is supplied just to allow file to compile
        int edgeWeight = -1;
        ListCell edge = findEdge(adjLists[v1-'A'],v2);
        if (edge!=null){
            edgeWeight = edge.getWeight();
        }
        return edgeWeight;

    }
}

// linked list - each cell contains a vertex name, a weight and a reference to the next item in the list
class ListCell {
    char vertex;
    int weight;
    ListCell next;

    ListCell(char v, int w, ListCell nxt) {
        vertex = v;
        weight = w;
        next = nxt;
    }

    public char getVertex(){
        return this.vertex;
    }

    public int getWeight(){
        return this.weight;
    }

    public ListCell getNext(){
        if (nextExists()){
            return this.next;
        } else{
            return null;
        }
    }

    public boolean nextExists(){
        if (next == null){
            return false;
        } else{
            return true;
        }
    }

    public boolean sameVertex(char otherVertex){
        return (vertex == otherVertex);
    }

    private boolean printable(char startNode){
        return (startNode < vertex);
    }

    private boolean futurePrintable(char startNode){
        ListCell futureNode = this;
        while (futureNode != null){
            if (!futureNode.printable(startNode)){
                return false;
            } else{
                futureNode = futureNode.next;
            }
        }
        return true;
    }


    public String listCellPrinter(char startNode, boolean canPrefixComma) {
        StringBuilder sb = new StringBuilder();
        //boolean printThis = printable(startNode);
        /*
        if (canPrefixComma && printThis){
            sb.append(", ");
            canPrefixComma = false;
        }*/
        if (printable(startNode)) {
            if (canPrefixComma) {
                sb.append(", ");
                canPrefixComma = false;
            }
            sb.append("(");
            sb.append(startNode);
            sb.append(",");
            sb.append(vertex);
            sb.append(",");
            sb.append(weight);
            sb.append(")");
            canPrefixComma = true;
        }
        if (nextExists()) {
            sb.append(next.listCellPrinter(startNode, canPrefixComma));
        }
        return sb.toString();
    }
}

