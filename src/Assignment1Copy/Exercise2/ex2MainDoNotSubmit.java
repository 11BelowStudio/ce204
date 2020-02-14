package Assignment1Copy.Exercise2;

public class ex2MainDoNotSubmit {

    public static void main(String args[]){
        BST testTree = new BST();

        System.out.println(testTree.nonleaves());
        System.out.println(testTree.depth());

        testTree.insert(4);
        System.out.println(testTree.nonleaves());
        System.out.println(testTree.depth());
        testTree.insert(2);
        System.out.println(testTree.nonleaves());
        System.out.println(testTree.depth());
        testTree.insert(6);
        testTree.insert(1);
        testTree.insert(3);
        testTree.insert(5);
        testTree.insert(7);
        testTree.insert(8);

        System.out.println(testTree.nonleaves());
        System.out.println(testTree.depth());

        System.out.println(testTree.range(2,5));

        try{
            testTree.range(3,2);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }


        BST tree2 = new BST();
        System.out.println(tree2.range(0,1));
        tree2.insert(0);
        tree2.insert(4);
        tree2.insert(1);
        tree2.insert(3);
        tree2.insert(2);

        System.out.println(tree2.range(1,4));

    }
}
