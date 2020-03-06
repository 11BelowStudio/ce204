package Lab2.Lab2Part2;

import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) {
        Stack mystack = new ArrayStack<Character>();

        Scanner scanInput = new Scanner(System.in);
        System.out.println("pls enter an string");

        String textline = scanInput.nextLine();
        // input a line of text into textline (uses a Scanner object)


        int i;
        for (i=0; i<textline.length(); i++) {
            // push the ith character of textline onto mystack
            mystack.push(textline.charAt(i));
        }

        // while mystack is not empty
        while (!mystack.isEmpty()) {
            // print the top character of mystack (without a newline character)
            System.out.print(mystack.top());
            // pop mystack
            mystack.pop();
        }
        System.out.println(); //pretty much adds a newline character to the end of the prior line


    }
}