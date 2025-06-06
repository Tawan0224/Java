package Week11.Node;

import Week11.Stack.Stack;

public class StackV2Driver {
    public static void main(String[] args) {
        StackV2 myStack = new StackV2(5);
        myStack.push(2);
        myStack.push(5);
        myStack.push(7);
        myStack.push(4);

        System.out.println(myStack); //Expect: [ 4 7 5 2 ]

        myStack.pop();
        myStack.pop();
        System.out.println(myStack); //Expect: [ 5 2 ]

        while(!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
        System.out.println(myStack); // Expect: [ ]
    }
}
