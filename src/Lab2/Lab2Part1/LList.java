package Lab2.Lab2Part1;


class ListCell<T> {
    T data;
    ListCell<T> next;

    public ListCell(T x, ListCell<T> c) {
        data = x;
        next = c;
    }
}

class ListException extends RuntimeException {
    public ListException(String s) {
        super(s);
    }
}

public class LList<T>{

    private ListCell<T> front;

    public LList() {
        front = null;
    }

    public void addToFront(T x) {
        front = new ListCell<T>(x, front);
    }

    public void addToBack(T x) {
        if (front==null) {
            front = new ListCell<T>(x, front);
        } else {
            ListCell<T> c = front;
            while (c.next != null) {
                c = c.next;
            }
            c.next = new ListCell<T>(x, null);
        }
    }

    public T elementAt(int n) {
        ListCell<T> c = front;
        for (int i = 0; i<n; i++) {
            if (c == null) {
                throw new ListException("no element at position " + n);
            }
            c = c.next;
        }
        if (c == null) {
            throw new ListException("no element at position " + n);
        }
        return c.data;
    }

    public int length() {
        ListCell<T> c = front;
        int result = 0;
        while (c != null) {
            result++;
            c = c.next;
        }
        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<");
        ListCell<T> c = front;
        while (c != null) {
            sb.append(c.data);
            if (c.next != null){
                sb.append(",");//only appends a comma if there's something after this element
            }
            c = c.next;
        }
        return(sb+">");
    }


    public int find(T x){
        if (front == null){
            return -1;
            //can't find it if there's nothing in the list bruh
        }
        int pos = 0;
        ListCell<T> current = front;
        //starts searching through the list if there's stuff to search through
        while(current.next != null){
            //starts searching through everything that has something after it
            if (current.data.equals(x)){
                return pos;
            } else{
                current = current.next;
                pos++;
                //moves on to next one and increases pos if it's not there
            }
        }
        //checks the final element, before giving up if the final element doesn't have it
        if (current.data.equals(x)) {
            return pos;
        } else{
            return -1;
        }

    }

    public boolean removeAll(T x){
        //return false if x is not in list
        //remove true if x is in list (and remove all x)
        boolean foundIt = false;
        //x isn't found until it is found
        boolean canProceed = false;
        //can't proceed unless it can proceed
        while (!canProceed && front != null){
            //go on until front either is null, or it can proceed
            if (front.data.equals(x)){
                front = front.next;
                foundIt = true;
                //yeet front if it holds x (and x has been found)
            } else{
                canProceed = true;
                //can stop looping
            }
        }

        if (front == null){
            return foundIt;
            //returns whether or not x has been found if the entire list has been yeeted
        }

        ListCell<T> previous = front;
        ListCell<T> current = front.next;

        while (current != null){
            //go on until current is null (until end of the list)
            if (current.data.equals(x)){
                previous.next = current.next;
                current = current.next;
                foundIt = true;
                //yeet current if it holds x (and notes that x has been found)
            } else{
                previous = current;
                current = current.next;
                //can move to the next one if current doesn't contain x
            }
        }

        return foundIt;

    }
}