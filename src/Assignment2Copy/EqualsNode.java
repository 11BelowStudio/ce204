package Assignment2Copy;

import java.util.Map;

public class EqualsNode extends AssignmentNode {

    private String equalsIdentifier;
    //stores the identifier

    //PARAMETERS: l: the identifier for this value, r: the expression which gives the value of the identifier
    EqualsNode(String l, ExpTree r) {
        super(null, r);
        //left child not used, right child is the expression which gives the value of r
        equalsIdentifier = l;
    }


    //PARAMETERS: Map containing the existing IDs/assigned values
    //RETURNS: that map, but updated with the identifier/value of this assignment
    public Map<String,Integer> buildIDValueMap(Map<String, Integer> idValues){
        idValues.put(equalsIdentifier,right.evaluation());
        return idValues;
    }

    @Override
    //returns string representation of the identifier, an equals, and the toString representation of the right child
    public String toString() {
        return equalsIdentifier + " = " + right.toString();
    }


}
