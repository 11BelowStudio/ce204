package Assignment2Copy;

import java.util.Map;

public class ModNode extends MultiplicativeNode {

    //MultiplicativeNode with children l and r, and operator character '%'
    ModNode(ExpTree l, ExpTree r) {
        super(l, r, '%');
    }

    @Override
    //PARAMETERS: idValues - the map of the defined identifier->value pairs
    //RETURNS: modulo of the value returned by left evaluation over the value returned by right evaluation
    public int evaluation(Map<String, Integer> idValues) {
        return left.evaluation(idValues) % right.evaluation(idValues);
    }
}
