package Lab5;

import java.util.ArrayList;
import java.util.Random;

public class BSTMainLab5Ex2 {

    public static void main(String args[]) {

        Random rand = new Random();

        ArrayList<ArrayList<Integer>> resultsList = new ArrayList<>();

        double avgInsertions = 0;
        double avgDepth = 0;

        int numberOfTests = 50;

        for (int i = 0; i < numberOfTests; i++) {
            resultsList.add(randomTreeResults(rand));
            System.out.println(resultsList.get(i));
            avgInsertions += resultsList.get(i).get(0);
            avgDepth += resultsList.get(i).get(1);
        }

        avgInsertions /= numberOfTests;
        avgDepth /= numberOfTests;

        System.out.println("\n\nResults from " + numberOfTests + " tests:");
        System.out.println("Average insertions: " + avgInsertions);
        System.out.println("Average depth: " + avgDepth);


    }

    public static ArrayList<Integer> randomTreeResults(Random rand){

        BST randomTree = new BST();

        int insertedCount = 0;

        for (int i = 0; i < 1000; i++) {
            if (randomTree.insert(rand.nextInt(10000))){
                insertedCount++;
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        results.add(insertedCount);
        results.add(randomTree.getDepth());
        return results;
    }


}
