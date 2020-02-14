package Assignment1Copy.Exercise1;

/*
A generically-typed, doubly-linked list implementation of the Deque data structure
    Called 'Deqeueue', not 'Deque', because the assignment script suggested that it should be declared as 'Dequeue<T>',
    and I guess it means that the compiler won't confuse it for the Collections Deque thing instead

This implementation does not use the Java Collections thing in any way, shape, or form.
 */
public class Dequeue<T> {

    private DequeueCell<T> left, right;

    public Dequeue(){

        //nothing at the left and the right at first
        left = null;
        right = null;

    }

    //checks to see if this is empty, true if it is empty
    public boolean isEmpty(){
        return (left == null && right == null);
        //right will also be null if left is null anyway
    }

    //attempts to add the data 'x' to the left of this deque
    public void addLeft(T x) {
        left = new DequeueCell<T>(x, null, left);
        //new cell containing x is added to the left, with a reference to the current leftmost cell to the right of it
        if (right == null){
            //this cell will also be the rightmost cell if right is currently null (this new cell is the only thing in the queue)
            right = left;
        } else{
            //making the previous leftmost cell refer to this as being to the left of it
            left.getRight().setLeft(left);

        }
    }

    //attempts to add the data 'x' to the right of this deque
    public void addRight(T x){
        right = new DequeueCell<T>(x,right,null);
        //new cell containing x is added to the right, with a reference to the current rightmost cell to the left of it
        if (left == null){
            //this cell will also be the leftmost cell if left is currently null (this new cell is the only thing in the queue)
            left = right;
        } else{
            //making the previous rightmost cell refer to this as being to the right of it
            right.getLeft().setRight(right);
        }
    }

    //attempts to return the data at the leftmost cell of this deque
    public T left(){
        if (left == null){
            //can't return left if there's nothing there
            throw new DequeueException("left");
        } else {
            return left.getData();
        }
    }

    //attempts to return the data at the rightmost cell of this deque
    public T right(){
        if (right == null){
            //can't return right if there's nothing there
            throw new DequeueException("right");
        } else {
            return right.getData();
        }

    }


    //attempts to remove the leftmost cell of this deque, making left refer to the cell that previously was 2nd furthest left
    public void removeLeft(){
        if (left == null){
            //can't remove stuff that doesn't exist
            throw new DequeueException("removeLeft");
        } else {
            left = left.getRight();
            //left now refers to the cell which was the 2nd furthest left
            if (left == null) {
                right = null;
                //if left is now null, right is also now null
            } else{
                //if left is actually a cell, not a lack of a cell
                left.yeetLeft();
                //nothing to the left of left, so it won't refer to anything being to the left of it
            }
        }
    }

    //attempts to remove the rightmost cell of this deque, making right refer to the cell that previously was 2nd furthest right
    public void removeRight(){
        if (right == null){
            //can't remove stuff that doesn't exist
            throw new DequeueException("removeRight");
        } else {
            right = right.getLeft();
            //right now refers to the cell (or lack of) which was the 2nd furthest right
            if (right == null) {
                left = null;
                //left will be made null if right is now null
            } else{
                //if right is actually a cell, not a lack of a cell
                right.yeetRight();
                //nothing to the right of right, so it won't refer to anything being to the right of it
            }
        }
    }


    //yeah this bit is repurposed from lab 2's ArrayStack toString
    @Override
    public String toString(){
        if (this.isEmpty()){
            return "<empty>";
        } else {
            //StringBuilder would be faster, but StringBuffer is thread-safe, so...
            StringBuffer sb = new StringBuffer();
            sb.append('<');
            DequeueCell<T> current = left;
            while (current != null){
                sb.append(current.getData());
                sb.append(',');
                current = current.getRight();
            }
            sb.setLength(sb.length()-1); //remove the last comma
            sb.append('>');
            return(sb.toString());
        }
    }

}
