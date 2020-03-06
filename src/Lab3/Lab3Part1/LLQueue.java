package Lab3.Lab3Part1;
import java.util.*;

public class LLQueue<T> implements Queue<T> {

    private LinkedList<T> ll;

    public LLQueue() {
        ll = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public void add(T x) {
        ll.addLast(x);
    }

    public T front() {
        if (ll.isEmpty()) {
            throw new QueueException("front");
        }
        return ll.getFirst();
    }

    public void removeFront() {
        if (ll.isEmpty()) {
            throw new QueueException("removeFront");
        }
        ll.removeFirst();
    }

    @Override
    public String toString(){

        if (ll.isEmpty()){
            return ("<empty>");
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        ListIterator<T> llIter = ll.listIterator();
        while (llIter.hasNext()){
            sb.append(llIter.next());
            if (llIter.hasNext()){
                sb.append(",");
            }
        }
        sb.append(">");

        return sb.toString();

    }
}
