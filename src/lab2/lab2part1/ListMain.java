package lab2.lab2part1;

public class ListMain {


    public static <T> void printIntersection(LList<T> llistA, LList<T> llistB){

        LList<T> returnList = new LList<T>();

        for (int i = 0; i<llistA.length(); i++) {
            try {
                T current = llistA.elementAt(i); //obtains an element from llistA

                if(llistB.find(current) != -1){ //checks if it's also present in llistB
                    if (returnList.find(current) == -1){ //checks if it's not already in returnList
                        returnList.addToBack(current);
                        //adds current to the back of returnList if it's not already in returnList
                    }
                }
            } catch (ListException e) {
                System.out.println("ERROR: " + e);
            }
        }
        System.out.println(returnList);

    }

    /*
    In the ListMain class write a new static generic method that takes as arguments two lists of the same type
        and removes from the second list all objects that are present in the first list.
        This should be similar to the method from exercise 3 but you'll need to use removeAll instead of find.
     */
    public static <T> void removeIntersection(LList<T> argumentList, LList<T> yeetList){


        for (int i = 0; i<argumentList.length(); i++) {
            try {
                //T current = argumentList.elementAt(i); //obtains an element from argumentList

                yeetList.removeAll(argumentList.elementAt(i));
                //attempts to remove all instances of the current element of argumentList from yeetList
            } catch (ListException e) {
                System.out.println("ERROR: " + e);
            }
        }

    }



    public static void main(String args[]) {
        LList<Integer> myList = new LList<Integer>(); // <>
        System.out.println(myList);
        System.out.println("length = " + myList.length());
        myList.addToFront(5);     // <5>
        myList.addToFront(4);     // <4,5>
        myList.addToFront(3);     // <3,4,5>
        System.out.println(myList);
        myList.addToBack(8);      // <3,4,5,8>
        myList.addToBack(9);      // <3,4,5,8,9>
        myList.addToBack(42); //<3,4,5,8,9,42>
        System.out.println(myList);
        System.out.println("length = " + myList.length());
        System.out.println(myList.find(3));
        System.out.println(myList.find(42));
        System.out.println(myList.find(63));
        System.out.println("");

        for (int i = 0; i<7; i++) {
            try {
                System.out.println(myList.elementAt(i));
            } catch (ListException e) {
                System.out.println("ERROR: " + e);
            }
        }

        System.out.println("");

        for (int i = 0; i<myList.length(); i++) {
            try {
                System.out.println(myList.elementAt(i));
            } catch (ListException e) {
                System.out.println("ERROR: " + e);
            }
        }

        LList<String> mySList = new LList<String>();
        mySList.addToFront("hello");
        mySList.addToBack("goodbye");
        System.out.println(mySList); //<hello,goodbye>
        System.out.println(mySList.find("goodbye"));
        System.out.println(mySList.find("the invisible man"));

        System.out.println("\n");


        LList<Integer> myList2 = new LList<Integer>();
        myList2.addToBack(42);
        myList2.addToBack(74);
        myList2.addToBack(5);
        myList2.addToBack(42);
        myList2.addToBack(42);
        myList2.addToBack(631);
        System.out.println(myList2);
        System.out.println(myList);

        printIntersection(myList,myList2);

        System.out.println("");
        System.out.println(myList2.removeAll(32));
        System.out.println(myList2);
        System.out.println(myList2.removeAll(74));
        System.out.println(myList2);
        System.out.println(myList2.removeAll(42));
        System.out.println(myList2);
        System.out.println(myList2.removeAll(5));
        System.out.println(myList2);
        System.out.println(myList2.removeAll(631));
        System.out.println(myList2);
        System.out.println(myList2.removeAll(32));
        System.out.println(myList2);

        System.out.println("\n\n");

        //adds everything back to myList2 so removeIntersection can be tested
        myList2.addToBack(42);
        myList2.addToBack(74);
        myList2.addToBack(5);
        myList2.addToBack(42);
        myList2.addToBack(42);
        myList2.addToBack(631);
        System.out.println(myList2);
        System.out.println(myList);

        ListMain.removeIntersection(myList,myList2);
        System.out.println(myList2);
    }
}