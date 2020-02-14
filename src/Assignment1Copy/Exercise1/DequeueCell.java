package Assignment1Copy.Exercise1;

class DequeueCell<T> {
    //private because you shouldn't be able to freely modify these
    private T data;
    private DequeueCell<T> left, right;

    public DequeueCell(T x, DequeueCell<T> l, DequeueCell<T> r) {
        data = x;
        left = l;
        right = r;
    }

    //setting the left/right references to be a different cell
    public void setLeft(DequeueCell <T> newLeft){
        left = newLeft;
    }

    public void setRight(DequeueCell <T> newRight){
        right = newRight;
    }

    //setting the left/right references to null
    public void yeetLeft(){
        left = null;
    }

    public void yeetRight(){
        right = null;
    }

    //obtaining the left/right references
    public DequeueCell<T> getLeft(){
        return left;
    }

    public DequeueCell<T> getRight(){
        return right;
    }

    //getting the data that the cell actually holds
    public T getData(){
        return data;
    }
}