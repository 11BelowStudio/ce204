package Assignment2Copy;

abstract class AdditiveNode extends OpNode{

    //essentially an OpNode with precedence 0, lef child l, right child r, and operator op
    AdditiveNode(ExpTree l, ExpTree r, char op){
        super(l,r, op,0);
    }
}
