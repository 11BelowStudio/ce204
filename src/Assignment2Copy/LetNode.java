package Assignment2Copy;

import java.util.HashMap;
import java.util.Map;

public class LetNode extends AssignmentNode {

    //an expTree with children l and r
    LetNode(ExpTree l, ExpTree r){
        super(l,r);
    }

    @Override
    //outputs the postOrder representation of the right node
    public String postOrder() {
        return right.postOrder();
    }

    @Override
    //constructs a map of defined identifier-value pairs, fills it with defined values
    //returns the result of calling the evaluation method of right child with this idValues map
    public int evaluation() {
        Map<String, Integer> idValues = new HashMap<>();
        idValues = ((AssignmentNode)left).buildIDValueMap(idValues);
        return right.evaluation(idValues);
    }

    @Override
    //only here to allow the program to compile, not expected to be used in runtime
    //parameters: idValues map, containing pairs of identifiers and values for them
    //returns the result of calling the evaluation method of the right child (with this parameter)
    public int evaluation(Map<String, Integer> idValues) {
        return right.evaluation(idValues);
    }

    @Override
    //returns a string formatted 'let (definitions) in (equation)'
    public String toString() {
        return "let " + left.toString() + " in " + right.toString();
    }
}
