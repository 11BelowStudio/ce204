package Lab3.Lab3Part1;

public interface Queue<T> {
    public void add(T o);
    public void removeFront();
    public T front();
    public boolean isEmpty();
}

class QueueException extends RuntimeException {
    QueueException(String s) {
        super("Tried to apply " + s + " to empty queue");
    }
}