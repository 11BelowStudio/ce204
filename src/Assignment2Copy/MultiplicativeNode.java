package Assignment2Copy;

abstract class MultiplicativeNode extends OpNode {

    //an OpNode with precedence 1,left child l, right child r, and operator op
    MultiplicativeNode(ExpTree l, ExpTree r, char op){
        super(l, r, op, 1);
    }
}
