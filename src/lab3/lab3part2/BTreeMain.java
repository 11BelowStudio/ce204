package lab3.lab3part2;

public class BTreeMain {

    public static void main(String args[]){

        BTree<Integer> t1 = new BTree<>(1,new BTree<>(),new BTree<>());

        System.out.println(t1);
        System.out.println(t1.numNodes());

        BTree<Integer> t3 = new BTree<>(3,new BTree<>(),new BTree<>());

        System.out.println(t3);
        System.out.println(t3.numNodes());

        BTree<Integer> t2 = new BTree<>(2,t1,t3);

        System.out.println(t2);

        System.out.println(t2.numNodes());


        BTree<Integer> t4 = new BTree<>(4,t2,new BTree<>());

        System.out.println(t4);

        System.out.println(t4.numNodes());





    }
}
