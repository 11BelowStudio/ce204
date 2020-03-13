package Assignment2Copy;

public abstract class OpNode extends ExpTree {

    private char operator; //the symbol form of the operator

    //PARAMETERS;
    //l; ExpTree, left child. r; ExpTree, right child, op; char, operator. p; int, precedence
    OpNode(ExpTree l, ExpTree r, char op, int p){
        super(l,r,p); //actually defining left, right, and precedence
        operator = op;//defining operator
    }

    @Override //returns post-order unformatted string representation of this node and children (followed by space)
    public String postOrder() {
        return left.postOrder() + right.postOrder() +operator + " ";
    }

    //literally just toString but with brackets around it
    public String getString(){
        return "("+ toString() + ")";
    }

    //returns in-order formatted string representation of this node and its children
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (this.precedence > left.precedence){
            sb.append(left.getString());
            //left will potentially be in brackets if it's lower precedence
        } else{
            sb.append(left.toString());
            //no brackets on left if higher precedence
        }
        sb.append(operator); //showing this operator
        /*
        if (this.precedence <= right.precedence){
            sb.append(right.getString());
            //right is in brackets if higher precedence
        } else{
            if (right.precedence == 2) {
                sb.append(right.getString());
            }/* else{
                sb.append(right.toString());
            //}
        }*/
        sb.append(right.getString()); //right always going to be in brackets if possible
        return sb.toString();

        /*if (this.precedence == left.precedence && this.precedence == right.precedence) {
            return left.toString() + operator + right.getString();
        } else */ /* if (this.precedence > left.precedence && this.precedence > right.precedence){
                return left.getString() + operator + right.getString();
            } else if (this.precedence < right.precedence){
                return left.getString() + operator + right.toString();
            }
            //will attempt to put both children in brackets if they are both lower precedence than this
        } else if (this.precedence < right.precedence){
            return left.toString() + operator + right.toString();
        }
        /*else if (this.precedence < left.precedence && !(this.precedence >= right.precedence)){
            return left.toString() + operator + right.getString();
        }  */ /*
        return left.toString() + operator + right.getString();
        //will only attempt to put right child in brackets otherwise
        */
    }
}
