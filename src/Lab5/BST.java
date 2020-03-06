package Lab5;

public class BST{ // non-generic version

    private BTNode<Integer> root;

    private int depth;

    public BST() {
        root = null;
        depth = 0;
    }

    public boolean find(Integer i) {
        BTNode<Integer> n = root;
        boolean found = false;

        while (n!=null && !found) {
            int comp = i.compareTo(n.data);
            if (comp==0) {
                found = true;
            } else if (comp<0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }

        return found;
    }

    public boolean insert(Integer i) {
        BTNode<Integer> parent = root, child = root;
        boolean goneLeft = false;

        int insertedDepth = 1;

        while (child!=null && i.compareTo(child.data)!=0) {
            parent = child;
            if (i.compareTo(child.data)<0) {
                child = child.left;
                goneLeft = true;
                insertedDepth++;
            } else {
                child = child.right;
                goneLeft = false;
                insertedDepth++;
            }
        }

        if (child!=null) {
            return false;  // number already present
        } else {
            BTNode<Integer> leaf = new BTNode<Integer>(i);
            if (parent==null) { // tree was empty
                root = leaf;
            }else if (goneLeft) {
                parent.left = leaf;
            }else {
                parent.right = leaf;
            }
            //System.out.println("Node with value "+ i + " inserted at depth " + insertedDepth);
            if (insertedDepth > depth){
                depth = insertedDepth;
            }
            return true;
        }
    }

    public int getDepth(){return depth;}




    //and now the toString() thing that Mike showed me

    public String toString(){
        if (root == null){
            return "tree's empty bruh";
        } else {
            StringBuilder treeSB = toString(new StringBuilder(), true, new StringBuilder(), root);
            treeSB.append("\n Total depth: ");
            treeSB.append(depth);
            return treeSB.toString();
            //return this.toString(new StringBuilder(), true, new StringBuilder(), root).toString();
        }
    }

    private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb, BTNode node){
//        if (node == null){
//            return new StringBuilder();
//        }
        if(node.right != null){
            toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb, node.right);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.data.toString()).append("\n");
        if(node.left!=null){
            toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb, node.left);
        }
        return sb;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public int numEvens(){
        if (isEmpty()){
            return 0;
        } else{
            return BST.evens(root);
        }
    }

    private static int evens(BTNode n){
        int evenCount = 0;
        if (((Integer)n.data % 2) == 0){
            evenCount+= 1;
        }
        if (n.left != null){
            evenCount += evens(n.left);
        }
        if (n.right != null){
            evenCount += evens(n.right);
        }

        return evenCount;
    }


    public boolean delete(int i){

        //find node to yeet
        BTNode<Integer> parent = root;
        BTNode<Integer> child = root;
        boolean goneLeft = false;

        while (child!=null && i != (child.data)) {
            parent = child;
            if (i < (child.data)) {
                child = child.left;
                goneLeft = true;
            }
            else {
                child = child.right;
                goneLeft = false;
            }
        }

        if (child!=null) {
            int newValue;
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
            depth = getNewDepth(0,root);
            return true;
        }
        //bruh how do you remove stuff what dont exist
        return false;
    }

    private void replaceChildWith(BTNode parentNode, BTNode newChild, boolean goneLeft){
        //replaces the left/right parent node with the newchild, depending on goneLeft
        if (goneLeft){
            parentNode.left = newChild;
        } else{
            parentNode.right = newChild;
        }
    }

    private void moveNodeValue(BTNode nodeToOverwrite, int newValue){
        delete(newValue); //yeets the existing copy of the new value from the tree
        nodeToOverwrite.data = newValue; //overwrites that node with the new value
    }

    private int getNewDepth(int currentDepth, BTNode currentNode){
        if (currentNode == null){
            return currentDepth;
        } else{
            currentDepth++;
            if (currentNode.left == null){
                if (currentNode.right == null){
                    return currentDepth; //return depth of this node if it has no children
                } else{
                    return getNewDepth(currentDepth,currentNode.right);
                    //return depth of right child if it only has right child
                }
            } else if(currentNode.right == null){
                return getNewDepth(currentDepth,currentNode.left);
                //return depth of left child if it only hsa left child
            } else {
                //return depth of deepest child if it has multiple children
                int leftDepth = getNewDepth(currentDepth,currentNode.left);
                int rightDepth = getNewDepth(currentDepth,currentNode.right);
                return Math.max(leftDepth, rightDepth);
            }
        }
    }
}

class BTNode<T> {
    T data;
    BTNode<T> left, right;

    BTNode(T o) {
        data = o; left = right = null;
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