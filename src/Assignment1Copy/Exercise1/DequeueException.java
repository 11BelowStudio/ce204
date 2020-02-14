package Assignment1Copy.Exercise1;

class DequeueException extends RuntimeException {
    //repurposed version of StackException from lab 2, but for the Dequeue class instead
    public DequeueException(String s) {
        super("tried to apply operation '" + s + "' to empty Deque");
    }
}