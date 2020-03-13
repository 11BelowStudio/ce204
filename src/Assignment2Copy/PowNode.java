package Assignment2Copy;

import java.util.Map;

public class PowNode extends OpNode {


    //OpNode with precedence 2, and is used for power operations
    PowNode(ExpTree l, ExpTree r) {
        super(l, r, '^',2);
    }

    @Override
    //PARAMETERS; idValues: map of any defined values for identifiers
    //RETURNS: value of left child raised to the power of the right child's value

    //throws an arithmetic exception if negative powers are used
    public int evaluation(Map<String, Integer> idValues) {
        int rightValue = right.evaluation(idValues);
        if (rightValue < 0){
            throw new ArithmeticException("no using negative powers >:(");
        }
        return (int)Math.pow(left.evaluation(idValues),rightValue);
    }

}
