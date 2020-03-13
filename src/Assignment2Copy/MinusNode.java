package Assignment2Copy;

import java.util.Map;

public class MinusNode extends AdditiveNode {

    //AdditiveNode with left child l, right child r, and operator char '-'
    MinusNode(ExpTree l, ExpTree r) {
        super(l, r, '-');
    }

    @Override
    //PARAMETERS; map of the defined identifier/value pairs
    //RETURNS; difference between left evaluation and right evaluation (with idValues as parameters)
    public int evaluation(Map<String, Integer> idValues) {
        return left.evaluation(idValues) - right.evaluation(idValues);
    }
}
