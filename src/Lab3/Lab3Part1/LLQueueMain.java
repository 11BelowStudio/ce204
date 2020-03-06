package Lab3.Lab3Part1;

public class LLQueueMain {

    public static void main(String args[]) {
        LLQueue<Integer> lq = new LLQueue<>();

        System.out.println(lq);

        for (int i = 0; i < 5; i++) {
            lq.add(i);
            System.out.println(lq);
        }
    }

}
