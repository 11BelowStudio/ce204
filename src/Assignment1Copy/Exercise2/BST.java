package Assignment1Copy.Exercise2;


import java.util.ArrayList;
import java.util.Collections;

public class BST {

    //Binary Search Tree

    //made a few changes to the indentation and location of the curly braces in the existing methods for readability purposes,
    //no changes were made to their actual funcitonality
    private BTNode<Integer> root;


    //DO NOT MODIFY (constructs empty binary search tree)
    public BST() {
        root = null;
    }

    //DO NOT MODIFY (declares whether or not there is a node with value i in the tree)
    public boolean find(Integer i) {
        BTNode<Integer> n = root;
        boolean found = false;

        while (n!=null && !found) {

            int comp = i.compareTo(n.data);
            if (comp==0) {
                found = true;
            } else if (comp<0) {
                n = n.left;
            }else {
                n = n.right;
            }
        }

        return found;
    }

    //DO NOT MODIFY (inserts a node with value i into the binary search tree)
    public boolean insert(Integer i) {

        BTNode<Integer> parent = root, child = root;
        boolean goneLeft = false;

        while (child!=null && i.compareTo(child.data)!=0) {
            parent = child;
            if (i.compareTo(child.data)<0) {
                child = child.left;
                goneLeft = true;
            } else {
                child = child.right;
                goneLeft = false;
            }
        }

        if (child!=null) {
            return false;  // number already present
        } else {
            BTNode<Integer> leaf = new BTNode<Integer>(i);
            if (parent==null) { // tree was empty
                root = leaf;
            } else if (goneLeft) {
                parent.left = leaf;
            }else {
                parent.right = leaf;
            }
            return true;
        }
    }

    /*
    Return:
        Number of non-leaf nodes (parent nodes) in tree
        0 if tree is empty
     */
    public int nonleaves(){


        if (root == null || (root.left == null && root.right == null)){
            return 0;//if the root node doesn't exist, or it is a leaf itself, there are 0 non-leaf nodes.
        }

        int parentCount = 0; //set to 0 to allow the loop to work without incident
        int currentIndex = 0;

        ArrayList<BTNode<Integer>> nodeArrayList = new ArrayList<>();

        nodeArrayList.add(root);

        BTNode<Integer> current;

        boolean isParent;


        while (currentIndex < nodeArrayList.size()){
            //obtains the next node to investigate
            current = nodeArrayList.get(currentIndex);
            isParent = false; //not a parent until proven otherwise
            if (current.left != null){
                //adds its left child to the nodeArrayList (if exists) and is now proven to be parent
                nodeArrayList.add(current.left);
                isParent = true;
            }
            if (current.right != null){
                //adds right child to nodeArrayList (if exists) and is now proven to be parent
                nodeArrayList.add(current.right);
                isParent = true;
            }
            if (isParent){
                //increase parentCount if this node was a parent
                parentCount++;
            }
            currentIndex++;
            //moves on to check the next index in the list
        }

        return parentCount; //will return the number of nodes that aren't parents

    }


    /*
    return:
        Depth of the tree
            Root: depth 1
        0 if tree is empty
     */
    public int depth(){
        int depth = 0;

        if (root == null){
            //no root = its empty
            return depth;
        }

        ArrayList<BTNode<Integer>> discoveredNodes = new ArrayList<>();
        discoveredNodes.add(root);

        while (discoveredNodes.size() > 0){
            //moves the contents of the list of currently discovered nodes to the list of nodes that need to be searched
            ArrayList<BTNode<Integer>> nodesToSearch = new ArrayList<>(discoveredNodes);
            //Collections.copy(nodesToSearch,discoveredNodes);
            discoveredNodes.clear(); //wipes this so the next layer of nodes can be put here

            for (BTNode<Integer> n: nodesToSearch){
                //starts putting the children of every node that needs to be searched through into nodesToSearch
                if (n.left != null){
                    discoveredNodes.add(n.left);
                }
                if (n.right != null){
                    discoveredNodes.add(n.right);
                }
            }

            depth++; //finished searching this layer, so increases depth by 1 before moving on to the next layer

        }
        /*
        TODO:
        go down the tree from the root node, and see how deep it goes, incrementing depth where appropriate
         */

        return depth;

    }

    /*
    Parameters:
        min
            Smallest value to look for in the tree
        max
            Largest value to look for in the tree

        inclusive search

     Return:
        Count of BTNodes in the range specified
        0 if tree is empty

     Throws:
        IllegalArgumentException (if max < min)
     */
    public int range(int min, int max){
        if (max < min){
            //max smaller than min: illegal arguments >:(
            throw new IllegalArgumentException("The value of max: " + max + " is smaller than the value of min: " + min);
        }
        if (root == null){
            //no root = its empty
            return 0;
        }

        //recursively looks through the tree and working out how many nodes are in the inclusive range
        return countInRange(root, min, max);
    }



    private int countInRange(BTNode<Integer> current, int min, int max){
        int countOfNodesInRange = 0;

        if (min <= current.data && current.data <= max){
            countOfNodesInRange++;
            //if this is in range, increase the count by 1

            //will check both child nodes (if they exist) for the amount of children that are in range
            if (current.left != null){
                countOfNodesInRange += countInRange(current.left,min,max);
            }
            if (current.right != null){
                countOfNodesInRange += countInRange(current.right,min,max);
            }
        } else if (min > current.data && current.right != null){
            /*will only check the right child nodes (if they exist)
            for something in range if this already too small (as anything to the left would also be too small)*/
            countOfNodesInRange += countInRange(current.right,min,max);
        } else if (current.data > max && current.left != null){
            /*ditto but only the left stuff is useful if this is too big*/
            countOfNodesInRange += countInRange(current.left,min,max);
        }

        return countOfNodesInRange;
    }

}

class BTNode<T> {

    //DO NOT ADD ANY ADDITIONAL INSTANCE VARIABLES
    T data;
    BTNode<T> left, right;

    //DO NOT MODIFY CONSTRUCTOR
    BTNode(T o) {
        data = o; left = right = null;
    }

}