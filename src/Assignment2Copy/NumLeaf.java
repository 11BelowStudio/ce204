package Assignment2Copy;

import java.util.Map;

public class NumLeaf extends ValueLeaf {


    //a ValueLeaf with value equal to 'val'
    NumLeaf(int val){
        super(val);
    }

    //returns the string representation of 'value' followed by a space
    public String postOrder(){
        return value + " ";
    }

    @Override
    //parameters; map of the defined identifier/value combos
    //returns; the 'value' of this node
    public int evaluation(Map<String, Integer> idValues) {
        return value;
    }


    @Override
    //returns the string representation of value
    public String toString() {
        return value + "";
    }


}
