package lab4;


public class BST<T extends Comparable<T>> {

    private BTNode<T> root;



    public BST() {
        root = null;
    }

    public boolean find(T i) {

        BTNode<T> n = root;
        boolean found = false;

        while (n!=null && !found) {
            int comp = i.compareTo(n.data);
            if (comp==0) {
                found = true;
            }else if (comp<0) {
                n = n.left;
            }else {
                n = n.right;
            }
        }

        return found;
    }

    public boolean insert(T i) {

        BTNode<T> parent = root, child = root;
        boolean goneLeft = false;

        while (child!=null && i.compareTo(child.data)!=0) {
            parent = child;
            if (i.compareTo(child.data)<0) {
                child = child.left;
                goneLeft = true;
            }
            else {
                child = child.right;
                goneLeft = false;
            }
        }

        if (child!=null) {
            return false;  // number already present
        }else {
            BTNode<T> leaf = new BTNode<T>(i);
            if (parent==null) { // tree was empty
                root = leaf;
            }else if (goneLeft) {
                parent.left = leaf;
            }else {
                parent.right = leaf;
            }
            return true;
        }
    }

    public boolean delete(T i){

        //find node to yeet
        BTNode<T> parent = root;
        BTNode<T> child = root;
        boolean goneLeft = false;

        while (child!=null && i.compareTo(child.data)!=0) {
            parent = child;
            if (i.compareTo(child.data)<0) {
                child = child.left;
                goneLeft = true;
            }
            else {
                child = child.right;
                goneLeft = false;
            }
        }

        if (child!=null) {
            T newValue;
            if (child.left == null && child.right == null) {
                //if the child has no data, you can just remove it from the parent
                if (child == root){
                    root = null;
                } else {
                    replaceChildWith(parent, null, goneLeft);
                }
            } else if (child.left == null) {
                //if child has no left child, the right child of it can just replace it
                if (child == root) {
                    newValue = root.right.getLeftmostValue();
                    moveNodeValue(root,newValue);
                } else {
                    replaceChildWith(parent, child.right, goneLeft);
                }
            } else if (child.right == null) {
                //vice versa if no right child
                if (child == root){
                    newValue = root.left.getRightmostValue();
                    moveNodeValue(root,newValue);
                } else {
                    replaceChildWith(parent, child.left, goneLeft);
                }
            } else {
                //if it has both kids
                if (child == root){
                    //if it's the root, it'll work out if the leftmost child of right is deeper,
                    //or if rightmost child of left is deeper,
                    //and will replace the value of root with the value of the deepest one
                    if (root.leftmostOnRightIsDeeper()){
                        newValue = root.right.getLeftmostValue();
                    } else{
                        newValue = root.left.getRightmostValue();
                    }
                } else {
                    //otherwise
                    if (goneLeft) {
                        //if the child is the left value of its parent, it'll be replaced by its rightmost value
                        newValue = child.getRightmostValue();
                    } else {
                        //else it'll be replaced by its leftmost value
                        newValue = child.getLeftmostValue();
                    }
                }
                //actually moving the values
                moveNodeValue(child,newValue);
            }
            //it worked btw
            return true;
        }
        //bruh how do you remove stuff what dont exist
        return false;
    }

    private void replaceChildWith(BTNode<T> parentNode, BTNode<T> newChild, boolean goneLeft){
        //replaces the left/right parent node with the newchild, depending on goneLeft
        if (goneLeft){
            parentNode.left = newChild;
        } else{
            parentNode.right = newChild;
        }
    }

    private void moveNodeValue(BTNode<T> nodeToOverwrite, T newValue){
        delete(newValue); //yeets the existing copy of the new value from the tree
        nodeToOverwrite.data = newValue; //overwrites that node with the new value
    }

    public String toString(){ //same as toString method in slides for BTree class
        if (root == null){
            return ("bruh it empty");
        }
        return getString(root);
    }

    private static <T> String getString(BTNode<T> n) {
        if (n==null) {
            return ("");
        } else {
            String s1 = getString(n.left);
            String s2 = getString(n.right);
            //return s1+" "+n.data+" "+s2; //in-order
            //return n.data+""+s1+""+s2; //pre-order
            //return s1+""+s2+""+n.data; //post-order

            ///* //UNCOMMENT FOR GOOD FORMATTING

            StringBuffer sb = new StringBuffer();
            //sb.append(n.data); //UNCOMMENT FOR PRE-ORDER
            if (!s1.isEmpty()){
                //sb.append(" "); //UNCOMMENT FOR PRE-ORDER
                sb.append(s1);
                sb.append(" "); //UNCOMMENT FOR POST-ORDER/IN ORDER
            }
            sb.append(n.data); //UNCOMMENT FOR IN-ORDER
            if (!s2.isEmpty()){
                sb.append(" "); //UNCOMMENT FOR PRE-ORDER/IN ORDER
                sb.append(s2);
                //sb.append(" "); //UNCOMMENT FOR POST-ORDER
            }

            //sb.append(n.data); //UNCOMMENT FOR POST-ORDER

            return sb.toString(); //UNCOMMENT TO OUTPUT
            //*/
        }
    }
}

class BTNode<T> {

    T data;
    BTNode<T> left, right;

    BTNode(T o) {
        data = o;
        left = right = null;
    }

    T getLeftmostValue(){
        if (left != null){
            return left.getLeftmostValue();
        } else{
            return this.data;
        }
    }

    T getRightmostValue(){
        if (right != null){
            return right.getRightmostValue();
        } else{
            return this.data;
        }
    }

    boolean leftmostOnRightIsDeeper() {
        //returns true if the leftmost child of right is deeper than rightmost child on left
        return (right.leftmostDepth(0) > left.rightmostDepth(0));
    }

    private int leftmostDepth(int current){
        if (left != null){
            return left.leftmostDepth(current+1);
        } else{
            return current;
        }
    }

    private int rightmostDepth(int current){
        if (right != null){
            return right.rightmostDepth(current+1);
        } else{
            return current;
        }
    }




}