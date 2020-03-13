package Assignment2Copy;

import java.util.Map;

public abstract class ExpTree {

    protected ExpTree left; //left child
    protected ExpTree right; //right child

    int precedence; //precedence of this in the order of operations: higher = higher precedence

    //children will be defined as 'l' and 'r'
    protected ExpTree(ExpTree l, ExpTree r){
        this.left = l;
        this.right = r;
        precedence = -10; //default precedence of -10.
    }

    //defining left and right as the passed l and r parameters, and precedence as 'p'
    protected ExpTree(ExpTree l, ExpTree r, int p){
        this(l,r); //defining the left and right children
        precedence = p; //defining precedence
    }

    //precedence will be defined as 'p'
    protected ExpTree(int p){
        this(null,null, p);
        //defining left and right as null
    }

    //will return the post-order string representation of this node
    public abstract String postOrder();

    //will return whatever the value stored by this expTree evaluates to
    //PARAMETERS: idValues - the map of defined identifier/value combos
    public abstract int evaluation(Map<String, Integer> idValues);

    //no-argument evaluation call redirects to the idValues evaluation but with a null map
    public int evaluation(){
        return evaluation(null);
    }

    //overridden by OpNode to return its toString in brackets, but just returns toString for everything else
    protected String getString(){
        return toString();
    }

    //returns String representation of this node, overridden by subclasses
    public abstract String toString();

}
