package Assignment2Copy;

import java.util.Map;

public class TimesNode extends MultiplicativeNode{

    //left child l, right child r
    TimesNode(ExpTree l, ExpTree r) {
        super(l, r, '*');
    }
    //MultiplicativeNode with the already mentioned children and operator char '*'

    //returns the product of the left evaluation and the right evaluation
    //parameters; map of defined identifiers and their defined values
    public int evaluation(Map<String, Integer> idValues){
        return left.evaluation(idValues) * right.evaluation(idValues);
    }
}
