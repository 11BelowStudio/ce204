package Assignment1Copy.Exercise1;

public class DequeueMain {



    public static void main(String args[]){

        System.out.println("aight so quick disclaimer: when I say 'Deque' here, I'm referring to the 'Dequeue' class I made");

        System.out.println("\nCreating empty Integer Deque, outputting contents");
        Dequeue<Integer> testDequeInt = new Dequeue<>();
        System.out.println(testDequeInt);

        System.out.println("\nAttempting to access (and remove) the nonexistent items at left/right. Exceptions will be thrown.");
        try{
            System.out.println("Attempting to access left");
            testDequeInt.left();
        } catch (DequeueException e){
            System.out.println(e);
        }
        try{
            System.out.println("Attempting to access right");
            testDequeInt.right();
        } catch (DequeueException e){
            System.out.println(e);
        }
        try{
            System.out.println("Attempting to remove left");
            testDequeInt.removeLeft();
        } catch (DequeueException e){
            System.out.println(e);
        }
        try{
            System.out.println("Attempting to remove right");
            testDequeInt.removeRight();
        } catch (DequeueException e){
            System.out.println(e);
        }


        System.out.println("\nAdding 1, then 2, then 3 to the left of the Deqeue, outputting leftmost, rightmost, and then the contents, after adding each one");
        System.out.println("Adding 1 to the left");
        testDequeInt.addLeft(1);
        System.out.println("Leftmost: " + testDequeInt.left());
        System.out.println("Rightmost: " + testDequeInt.right());
        System.out.println("Contents: "+ testDequeInt);
        System.out.println("Adding 2 to the left");
        testDequeInt.addLeft(2);
        System.out.println("Leftmost: " + testDequeInt.left());
        System.out.println("Rightmost: " + testDequeInt.right());
        System.out.println("Contents: "+ testDequeInt);
        System.out.println("Adding 3 to the left");
        testDequeInt.addLeft(3);
        System.out.println("Leftmost: " + testDequeInt.left());
        System.out.println("Rightmost: " + testDequeInt.right());
        System.out.println("Contents: "+ testDequeInt);

        System.out.println("\nExpected contents are <3,2,1>");

        System.out.println("\nCalling isEmpty(), should return false: " + testDequeInt.isEmpty());

        System.out.println("\nNow attempting to remove all 3 of those, by using removeLeft, outputting at each stage");
        try{
            System.out.println("First removeLeft call");
            testDequeInt.removeLeft();
            System.out.println("Leftmost: " + testDequeInt.left());
            System.out.println("Rightmost: " + testDequeInt.right());
            System.out.println("Contents: "+ testDequeInt);
            System.out.println("Second removeLeft call");
            testDequeInt.removeLeft();
            System.out.println("Leftmost: " + testDequeInt.left());
            System.out.println("Rightmost: " + testDequeInt.right());
            System.out.println("Contents: "+ testDequeInt);
            System.out.println("Third removeLeft call");
            testDequeInt.removeLeft();
            System.out.println("Contents: "+ testDequeInt);
        } catch (DequeueException e){
            System.out.println("IF YOU CAN SEE THIS LINE, SOMETHING BAD HAPPENED: " + e);
        }
        try{
            System.out.println("This fourth call, on the empty deque, will throw an exception");
            testDequeInt.removeLeft();
            System.out.println("* IF YOU CAN SEE THIS LINE, THE EXCEPTION THAT SHOULD HAVE BEEN THROWN WASN'T THROWN * ");
            System.out.println(testDequeInt);
        } catch (DequeueException e){
            System.out.println("You should be seeing this line: " + e);
        }

        System.out.println("\nCalling isEmpty(), should return true: " + testDequeInt.isEmpty());

        System.out.println("\nSame as the above stuff where everything was added/removed to the left, but for the right instead");

        System.out.println("\nAdding 1, then 2, then 3 to the right of the Deqeue, outputting rightmost, and then the contents, after adding each one");
        System.out.println("Adding 1 to the right");
        testDequeInt.addRight(1);
        System.out.println("Leftmost: " + testDequeInt.left());
        System.out.println("Rightmost: " + testDequeInt.right());
        System.out.println("Contents: "+ testDequeInt);
        System.out.println("Adding 2 to the right");
        testDequeInt.addRight(2);
        System.out.println("Leftmost: " + testDequeInt.left());
        System.out.println("Rightmost: " + testDequeInt.right());
        System.out.println("Contents: "+ testDequeInt);
        System.out.println("Adding 3 to the right");
        testDequeInt.addRight(3);
        System.out.println("Leftmost: " + testDequeInt.left());
        System.out.println("Rightmost: " + testDequeInt.right());
        System.out.println("Contents: "+ testDequeInt);

        System.out.println("\nExpected contents are <1,2,3>");

        System.out.println("\nCalling isEmpty(), should return false: " + testDequeInt.isEmpty());

        System.out.println("\nNow attempting to remove all 3 of those, by using removeRight, outputting at each stage");
        try{
            System.out.println("First removeRight call");
            testDequeInt.removeRight();
            System.out.println("Leftmost: " + testDequeInt.left());
            System.out.println("Rightmost: " + testDequeInt.right());
            System.out.println("Contents: "+ testDequeInt);
            System.out.println("Second removeRight call");
            testDequeInt.removeRight();
            System.out.println("Leftmost: " + testDequeInt.left());
            System.out.println("Rightmost: " + testDequeInt.right());
            System.out.println("Contents: "+ testDequeInt);
            System.out.println("Third removeRight call");
            testDequeInt.removeRight();
            System.out.println("Contents: "+ testDequeInt);
        } catch (DequeueException e){
            System.out.println("IF YOU CAN SEE THIS, SOMETHING BAD HAPPENED: " + e);
        }
        try{
            System.out.println("This fourth call, on the empty deque, will throw an exception");
            testDequeInt.removeRight();
            System.out.println("* IF YOU CAN SEE THIS LINE, THE EXCEPTION THAT SHOULD HAVE BEEN THROWN WASN'T THROWN * ");
            System.out.println(testDequeInt);
        } catch (DequeueException e){
            System.out.println("You should see this line: " + e);
        }

        System.out.println("\nCalling isEmpty(), should return true: " + testDequeInt.isEmpty());

        System.out.println("\n\nNow testing with Strings.");

        System.out.println("\nCreating new empty String deque, outputting contents");

        Dequeue<String> stringDequeue = new Dequeue<>();
        System.out.println(stringDequeue);

        System.out.println("\nAdding 'a' to the left, 'b' to the right, 'c' to the left, then 'd' to the right, outputting at each stage");

        System.out.println("Adding 'a' to left");
        stringDequeue.addLeft("a");
        System.out.println("Leftmost: " + stringDequeue.left());
        System.out.println("Rightmost: " + stringDequeue.right());
        System.out.println("Contents: "+ stringDequeue);
        System.out.println("Adding 'b' to right");
        stringDequeue.addRight("b");
        System.out.println("Leftmost: " + stringDequeue.left());
        System.out.println("Rightmost: " + stringDequeue.right());
        System.out.println("Contents: "+ stringDequeue);
        System.out.println("Adding 'c' to left");
        stringDequeue.addLeft("c");
        System.out.println("Leftmost: " + stringDequeue.left());
        System.out.println("Rightmost: " + stringDequeue.right());
        System.out.println("Contents: "+ stringDequeue);
        System.out.println("Adding 'd' to right");
        stringDequeue.addRight("d");
        System.out.println("Leftmost: " + stringDequeue.left());
        System.out.println("Rightmost: " + stringDequeue.right());
        System.out.println("Contents: "+ stringDequeue);

        System.out.println("\nExpected contents are <c,a,b,d>");

        System.out.println("\nCalling isEmpty(), should return false: " + stringDequeue.isEmpty());

        System.out.println("\nNow removing left, then right, then left, then right. Expected order of removal is c,d,a,b.");

        try{
            System.out.println("Removing left");
            stringDequeue.removeLeft();
            System.out.println("Leftmost: " + stringDequeue.left());
            System.out.println("Rightmost: " + stringDequeue.right());
            System.out.println("Contents: "+ stringDequeue);
            System.out.println("Removing right");
            stringDequeue.removeRight();
            System.out.println("Leftmost: " + stringDequeue.left());
            System.out.println("Rightmost: " + stringDequeue.right());
            System.out.println("Contents: "+ stringDequeue);
            System.out.println("Removing left");
            stringDequeue.removeLeft();
            System.out.println("Leftmost: " + stringDequeue.left());
            System.out.println("Rightmost: " + stringDequeue.right());
            System.out.println("Contents: "+ stringDequeue);
            System.out.println("Removing right");
            stringDequeue.removeRight();
            System.out.println("Contents: "+ stringDequeue);
        } catch (DequeueException e){
            System.out.println("oh noes: " + e);
        }

        System.out.println("\nCalling isEmpty(), should return true: " + stringDequeue.isEmpty());

        //probably enough testing I guess?
    }
}
