package Lab1;

import java.util.NoSuchElementException;

public class LList {

    private ListCell front;


    public LList() {
        front = null;
    }

    public void addToFront(char x) {
        front = new ListCell(x, front);
    }

    public void addToBack(char x) {

        if (front==null) {
            front = new ListCell(x, front);
        } else {
            ListCell c = front;
            while (c.next != null) {
                c = c.next;
            }
            c.next = new ListCell(x, null);
        }
    }

    public char elementAt(int n) {
        ListCell c = front;
        if (n<0) {
            throw new ListException("elementAt called with negative argument");
        }
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

    public String toString() {
        StringBuffer sb = new StringBuffer("<");
        ListCell c = front;
        while (c != null) {

            sb.append(c.data);
            c = c.next;
        }
        return(sb+">");
    }

    public int length(){
        if (front == null){
            return 0; //no length if there's nothing there
        }
        int length = 1;
        ListCell current = front;
        //there's definitely at least 1 element in the list if it's got this far
        while (current.next != null){
            length++; //adds 1 if there's an element after the current one
            current = current.next; //next one is now current one
        }
        return length; //returns the final count
    }

    public int occs(char c){
        if (front == null){
            return 0; //can't count stuff if there's nothing to count bruh
        }
        int count = 0;
        ListCell current = front;
        //count is 0 and starts counting from the front
        while (current.next != null){
            //this checks everything apart form the last element
            if (current.data == c){
                count++;
                //increases count if the cell's data matches the character that is being searched for
            }
            current = current.next; //moves to the next cell
        }
        //checks the final cell to see if it matches
        if (current.data == c){
            count++;
        }
        return count; //returns the final count of how many times the thing was encountered
    }

    public void removeFront(){
        if (front == null){
            throw new ListException("this list is empty bruh how tf can stuff be removed from the front of an empty list");
        }
        front = front.next;
        //updates front to refer to the second thing instead, omitting the previous front
    }

    public void removeBack(){
        if (front == null){
            throw new ListException("this list is empty bruh how tf can stuff be removed from the back of an empty list");
        } else if (front.next == null){
            //casually yeets front if front's the only thing in the list
            front = null;
            return;
        }
        ListCell penultimate = front;
        ListCell rear = front.next;
        while (rear.next != null){
            //keeps going until rear is the final element
            penultimate = rear;
            rear = rear.next;
        }
        //when there's nothing after rear, penultimate.next is set to null, yeeting rear.
        penultimate.next = null;
    }

    public boolean remove(char c){
        if (front == null) {
            //cant remove stuff what doesn't exist
            return false;
        } else if(front.data == c){
            //yeet front if that contains c
            front = front.next;
            return true;
        }
        ListCell previous = front;
        ListCell current = front.next;
        while(current != null){
            //whilst the current cell exists
            if (current.data == c){
                if (current.next != null){
                    //if there's something after current, previous.next refers to the thing after current instead.
                    previous.next = current.next;
                } else{
                    //otherwise previous refers to nothing
                    previous.next = null;
                }
                return true;
                //returns true because c got yeeted
            }
            //moves to next cells
            previous = current;
            current = current.next;
        }
        return false;
        //false returned if c was not found
    }

    public LListIterator iterator(){
        return this.new MyIterator();
    }


    class MyIterator implements LListIterator{

        ListCell before;
        ListCell placeMarker;
        ListCell after;
        boolean canRemove;

        MyIterator(){
            before = null;
            placeMarker = null;
            after = front;
            canRemove = false;
        }

        @Override
        public boolean hasNext() {
            return (after != null);
            //return true if after isn't null
            //return false if after is null
        }

        @Override
        public char next() {
            if (after == null){
                throw new NoSuchElementException("bruh there's nothing else left in this list");
            }
            canRemove = true;
            //call to next will allow stuff to be removed
            if (placeMarker != null) {
                //only update 'before' if there's something to update it to
                before = placeMarker;
            }
            placeMarker = after;
            after = after.next;
            //moves everything forward by 1 basically
            return placeMarker.data;
        }

        @Override
        public void remove() {
            if (!canRemove){
                throw new IllegalStateException("bruh you need to call next before trying to remove something else");
            } else if (placeMarker == null){
                throw new IllegalStateException("bruh there's nothing to remove here");
            }
            //changes the thing before placemarker to refer to the thing after placemarker (if it exists)

            if (placeMarker == front){
                //changes 'front' to refer to the thing after placemarker if placemarker holds the first thing on the list
                front = after;
            } else{
                //otherwise, the thing before placemarker will refer to the thing that's currently after it
                before.next = after;
            }
            canRemove = false;
            //can't remove stuff immediately after removing something else
        }
    }


    // main method to test the class - expected list contents shown as comments

    public static void main(String args[]) {

        LList myList = new LList(); // <>
        System.out.println(myList);
        try {
            myList.removeFront();
        } catch (ListException e) {
            System.out.println("ERROR: " + e);
        }
        try {
            myList.removeBack();
        } catch (ListException e) {
            System.out.println("ERROR: " + e);
        }
        System.out.println(myList.remove('c'));
        System.out.println(myList.length());
        myList.addToFront('c');     // <c>
        myList.addToFront('b');     // <bc>
        myList.addToFront('a');     // <abc>
        System.out.println(myList);
        myList.addToBack('d');      // <abcd>
        myList.addToBack('e');      // <abcde>
        System.out.println(myList);
        System.out.println(myList.length()); //5
        System.out.println(myList.occs('a')); //1
        myList.addToBack('a');
        System.out.println(myList.occs('a')); //2
        System.out.println(myList); //<abcdea>

        try {
            myList.removeFront();
        } catch (ListException e) {
            System.out.println("ERROR: " + e);
        }
        System.out.println(myList); //<bcdea>
        try {
            myList.removeBack();
        } catch (ListException e) {
            System.out.println("ERROR: " + e);
        }
        System.out.println(myList);//<bcde>
        System.out.println(myList.remove('c')); //true
        System.out.println(myList); //<bde>
        System.out.println("\n");

        for (int i = -1; i<7; i++) {
            try {
                System.out.println(myList.elementAt(i));
            } catch (ListException e) {
                System.out.println("ERROR: " + e);
            }
        }

        System.out.println("\n");
        System.out.println(myList);
        myList.addToBack('f');
        myList.addToBack('g');
        myList.addToBack('h');
        myList.addToBack('i');
        System.out.println(myList);
        //<bdefghi>

        LListIterator iterator = myList.iterator();

        //should remove one element of the list at a time, by removing the front element
        while (iterator.hasNext()) {
            try {
                iterator.next();
                iterator.remove();
                System.out.println(myList);
            } catch(IllegalStateException e){
                System.out.println("oh noes: " + e);
            } catch (NoSuchElementException e2){
                System.out.println("this is bad: " + e2);
            }
        }


        try {
            iterator.next();
        } catch(NoSuchElementException e){
            System.out.println("uh oh: " + e);
        }
        try {
            iterator.remove();
        } catch (IllegalStateException e){
            System.out.println("oh dear: " + e);
        }

        System.out.println("\n");
        myList.addToBack('1');
        myList.addToBack('2');
        myList.addToBack('3');
        myList.addToBack('4');
        myList.addToBack('5');
        System.out.println(myList);
        //<12345>
        iterator = myList.iterator();
        try {
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.remove();
        } catch(IllegalStateException e){
            System.out.println("oh noes: " + e);
        } catch (NoSuchElementException e2){
            System.out.println("this is bad: " + e2);
        }
        System.out.println(myList);
        //<1245>



    }
}