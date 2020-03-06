package Lab3.Lab3Part1;

public class ArrayQueueMain {

    public static void main(String args[]){
        ArrayQueue q1 = new ArrayQueue<Integer>();

        q1.add(1);
        System.out.println(q1.front());
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);

        System.out.println("");

        for (int i = 0; i < 6; i++) {
            try {
                System.out.println(q1.front());
                q1.removeFront();
            } catch (QueueException qe){
                System.out.println(qe);
            }
        }


        for (int i = 0; i < 10; i++){
            q1.add(i);
        }

        System.out.println("");

        for (int i = 0; i < 10; i++){
            try {
                System.out.println(q1.front());
                q1.removeFront();
            } catch (QueueException qe){
                System.out.println(qe);
            }
        }
    }
}
