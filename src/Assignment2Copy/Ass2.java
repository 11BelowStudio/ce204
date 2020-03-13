package Assignment2Copy;

public class Ass2 {

    public static void main(String args[]){
        System.out.println("1804170");
        System.out.println("ok so basically this is an expression evaluation program, pls type an expression to be evaluated, remember to end it with a semicolon k thx: ");
        boolean quit = false; //working out whether or not to quit basically

        Parser p = new Parser();
        ExpTree tree;
        do{
            try {
                tree = p.parseLine();
                System.out.println("Post-Order: " +  tree.postOrder());
                System.out.println("Parsed equation: " + tree);
                System.out.println("The value of this expression is: " + tree.evaluation());
            } catch(ParseException | ArithmeticException e1){
                System.out.println(e1); //these are expected to be thrown
            }
            catch (Exception e){
                e.printStackTrace(); //these are not expected to be thrown
            }
            System.out.println("Enter 'q' to quit, enter anything else to continue doing stuff");
            String userChoice = p.getLine();
            if (userChoice.equals("q")){
                quit = true; //will quit if you entered q
            }
        } while(!quit);
        System.out.println("aight bye");
    }
}
