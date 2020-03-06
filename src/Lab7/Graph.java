package Lab7;

import java.util.Arrays;

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
        return doesEdgeExist(adjLists[getPosInt(v1)], v2) || doesEdgeExist(adjLists[getPosInt(v2)], v1);
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
        ListCell edge = findEdge(adjLists[getPosInt(v1)],v2);
        if (edge!=null){
            edgeWeight = edge.getWeight();
        }
        return edgeWeight;

    }

    // this method must be pasted inside the graph class since it uses the private variables
// of that class

    public Graph prim() {

        char[] nearestNeighbour = new char[numNodes];
        int[] distance = new int[numNodes];

        // initilaise the mcst to be a new graph with numNodes nodes and no edges

        Graph mcst = new Graph(numNodes);

        // select 'A' as start node and update array entries for 'A':
        //    nearest neighbour should be 'A' and distance should be 0
        // initialise all other entries in distance array to -1

        nearestNeighbour[0] = 'A';
        distance[0] = 0;

        for (int i = 1; i < numNodes; i++) {
            distance[i] = -1;
        }

        // traverse adjLists[0] to find 'A''s neighbours and update array entries for each:
        //    nearest neighbour should be 'A'
        //    distance should be weight of edge as found in the list
        ListCell current;
        if ((current = adjLists[0]) != null) {
            setDefaultNeighboursAndDistances('A',nearestNeighbour,distance,current);
            /*
            while ((current = current.next) != null) {
                findNeighboursAndDistances('A',nearestNeighbour,distance,current);
            }*/
        }


        // loop numNodes-1 times
        int i;
        for (i = 0; i<numNodes-1; i++) {
            int pos = 0;
            char v1, v2;
            // find position of smallest positive entry in distance array and store it in pos
            // (if there are no positive entries the graph cannot have been connected so
            //          print a warning message and return a graph with no edges)
            int smallest = Integer.MAX_VALUE;
            boolean foundPos = false;

            /*for (int d: distance) {
                if (d > 0 && d < smallestPos) {
                    smallestPos = d;
                    foundPos = true;
                }
            }*/

            for (int j = 0; j < distance.length; j++) {
                if (distance[j] > 0 && distance[j] < smallest) {
                    smallest = distance[j];
                    pos = j;
                    foundPos = true;
                }
            }

            if (!foundPos) {
                System.out.println("bruh there are no positive entries wtf do you expect me to do here >:(");
                return new Graph(numNodes);
            }


            // store nearestNeighbour[pos] entry in v1
            // store the vertex whose array index corresponds to pos in v2

            v1 = nearestNeighbour[pos];
            v2 = getPosChar(pos);


            // add edge (v1,v2) to MCST

            mcst.addEdge(v1,v2,smallest);

            // update array entries for v2
            //    nearest neighbour should be v2 and distance should be 0

            nearestNeighbour[pos] = v2;
            distance[pos] = 0;

            // traverse appropriate adjLists entry to find v2's neighbours
            //                      and update array entries for these where necessary:
            //  i.e. if distance entry is -1 or greater than weight of list entry
            //        set nearestNeighbour to v2 and distance to weight of list entry

            if ((current = adjLists[pos]) != null) {
                updateNeighboursAndDistances(v2, nearestNeighbour, distance, current);
            }
        }


        System.out.println(mcst.getSumOfWeights());
        //return the mcst
        return mcst;
    }

    private void updateNeighboursAndDistances(char source, char[] neighbours, int[] distances, ListCell currentCell) {
        int currentCellPos = getPosInt(currentCell.getVertex());
        int currentSmallest = distances[currentCellPos];
        if (currentSmallest == -1 || currentSmallest > currentCell.getWeight()) {
            setNeighbourAndDistance(source,currentCellPos,neighbours,distances,currentCell);
        }
        if (currentCell.nextExists()) {
            updateNeighboursAndDistances(source,neighbours,distances,currentCell.getNext());
        }
    }

    private void setNeighbourAndDistance(char source, int currentCellPos, char[] neighbours, int[] distances, ListCell currentCell) {
        //int currentCellPos = getPosInt(currentCell.getVertex());
        neighbours[currentCellPos] = source;
        distances[currentCellPos] = currentCell.getWeight();
        /*if (currentCell.nextExists()) {
            setNeighboursAndDistances(source, neighbours, distances, currentCell.getNext());
        }*/
    }

    private void setDefaultNeighboursAndDistances(char source, char[] neighbours, int[] distances, ListCell currentCell) {
        setNeighbourAndDistance(source, getPosInt(currentCell.getVertex()), neighbours, distances, currentCell);
        if (currentCell.nextExists()) {
            setDefaultNeighboursAndDistances(source, neighbours, distances, currentCell.getNext());
        }
    }

    private char getPosChar(int pos) {
        return (char) ('A'+pos);
    }

    private int getSumOfWeights(){
        int totalWeights = 0;
        for (ListCell l: adjLists) {
            totalWeights += l.getSumOfWeights();
        }
        totalWeights /= 2; //each edge is contained twice within the entire adjacency list
        return totalWeights;
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

    public char getVertex() {
        return this.vertex;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getSumOfWeights(){
        int sum = this.weight;
        //System.out.println(sum +"," + vertex);
        if (nextExists()){
            sum += next.getSumOfWeights();
        }
        return sum;
    }


    public ListCell getNext() {
        if (nextExists()) {
            return this.next;
        } else {
            return null;
        }
    }

    public boolean nextExists() {
        if (next == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean sameVertex(char otherVertex) {
        return (vertex == otherVertex);
    }

    private boolean printable(char startNode) {
        return (startNode < vertex);
    }

    private boolean futurePrintable(char startNode) {
        ListCell futureNode = this;
        while (futureNode != null) {
            if (!futureNode.printable(startNode)) {
                return false;
            } else {
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



