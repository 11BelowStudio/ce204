package Assignment2Copy;


abstract class ValueLeaf extends ExpTree {

    int value; //the integer value of this node

    ValueLeaf(){
        super(-1); //precedence and (lack of) children defined in super constructor
        //precedence is -1 for leaves; raw value, so no precedence tbh
    }

    //essentially the same as above, but defines the value of this node to 'val'
    ValueLeaf(int val){
        this();
        value = val;
    }

}
