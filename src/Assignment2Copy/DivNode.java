package Assignment2Copy;

import java.util.Map;

public class DivNode extends MultiplicativeNode {

    //MultiplicativeNode with the operator '/', left and right equal l and r
    DivNode(ExpTree l, ExpTree r) {
        super(l, r, '/');
    }

    //PARAMETERS: idValues - the map of defined identifier/value pairs
    //RETURNS: the integer value of left divided by the value of right (obtained via evaluation(idValues))
    public int evaluation(Map<String, Integer> idValues){
        int rightValue = right.evaluation(idValues);
        if (rightValue == 0){
            //angery if someone attempts dividing by 0.
            throw new ArithmeticException("no dividing by 0 >:(");
        }
        return left.evaluation(idValues)/right.evaluation(idValues);
    }
}
