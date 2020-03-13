package Assignment2Copy;

import java.util.Map;

public class IDLeaf extends ValueLeaf {

    private String identifier;
    //the identifier given to this node


    //defines this IDLeaf as having the identifier passed as a parameter
    IDLeaf(String id){
        super();
        identifier = id;
        //defining default value based on the first character of identifier
        char temp = identifier.charAt(0);
        //A: ascii 65, value 25
        //Z: ascii 90, value 0
        value = (90 - temp);
        //getting value by subtracting ascii value of first character from 90
    }



    @Override
    //returns the identifier, followed by a space
    public String postOrder() {
        return identifier + " ";
    }

    @Override
    //parameters: the idValues map, containing defined identifiers and their values
    //returns: value of this node
        //default value if idValues is null
        //value from idValues if idValues is not null (0 if not present in idValues)
    public int evaluation(Map<String, Integer> idValues) {
        if (idValues == null){
            return value; //default, no idValues
        } else{
           if (idValues.containsKey(identifier)){
               return idValues.get(identifier); //could be obtained from idValues
           } else{
               System.out.println("no value defined for identifier " + identifier + "!"); //angery
               return 0; //could not be obtained from idValues
           }
        }
    }


    //returns the identifier string
    public String toString(){return identifier;}

    //public String getString(){
    //    return identifier;
    //}
}
