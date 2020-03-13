package Assignment2Copy;


public class AndNode extends AssignmentNode {

    //pretty much just an average AssignmentNode, l is left child, r is right child
    AndNode(ExpTree l, ExpTree r) {
        super(l, r);
    }


    //returns toString format of left child, an ' and ', and the toString formatted right child
    @Override
    public String toString() {
        return left.toString() + " and " + right.toString();
    }


}
