package lab2.lab2part2;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> myStack = new ArrayStack<Integer>();
        System.out.println("Stack contents: " + myStack);
        try {
            System.out.println("top is "+myStack.top());
        } catch (StackException e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
        myStack.push(5);
        System.out.println("Stack contents: " + myStack);
        try {
            System.out.println("top is "+myStack.top());
        } catch (StackException e) {
            System.out.println("EXCEPTION: " + e.toString());
        }

        try {
            System.out.println(myStack);
            myStack.pop();
            System.out.println(myStack);
            myStack.pop();
        } catch (StackException e) {
            System.out.println("EXCEPTION: " + e.toString());
        }

        System.out.println("Stack contents: " + myStack);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println("Stack contents: " + myStack);
        System.out.println("");

        while(!myStack.isEmpty()){
            try {
                System.out.println("top is "+myStack.top());
                myStack.pop();
                System.out.println("Stack contents: " + myStack);
            } catch (StackException e) {
                System.out.println("EXCEPTION: " + e.toString());
            }
        }



    }
}