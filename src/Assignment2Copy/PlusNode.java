package Assignment2Copy;

import java.util.Map;

public class PlusNode extends AdditiveNode {

    //l: left child, r: right child
    PlusNode(ExpTree l, ExpTree r) {
        super(l, r, '+');
        //defines this as an AdditiveNode with operator '+'
    }

    @Override
    //PARAMETERS - idValues: map of defined identifier/value pairs
    //returns the sum of the evaluation methods of the left child and right child (with idValues parameters)
    public int evaluation(Map<String, Integer> idValues) {
        return left.evaluation(idValues) + right.evaluation(idValues);
    }
}
