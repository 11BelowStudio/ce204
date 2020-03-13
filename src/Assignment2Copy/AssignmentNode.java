package Assignment2Copy;

import java.util.Map;

public abstract class AssignmentNode extends ExpTree {


    //sets left and right children to whatever l and r are
    AssignmentNode(ExpTree l, ExpTree r){
        super(l,r);
    }

    @Override
    //these are not returned by postOrder, but only defining this here to allow the thing to compile
    public String postOrder() { return null; }

    @Override
    //not evaluated, but returns 0 so this won't cause compilation to break
    public int evaluation(Map<String, Integer> idValues) {
        return 0;
    }

    //PARAMETERS; map containing the defined identifier/value pairs
    //RETURNS; end product of calling this method on its children (which will be AssignmentNodes) using the parameter idValues
    public Map<String,Integer> buildIDValueMap(Map<String, Integer> idValues){
        idValues = ((AssignmentNode)left).buildIDValueMap(idValues);
        idValues = ((AssignmentNode)right).buildIDValueMap(idValues);
        return idValues;
    }
}
