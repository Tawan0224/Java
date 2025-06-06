package Week13;

public class StackDriver {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>(5);
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

        Stack<String > strStack = new Stack<String>();
        strStack.push("Hi");
        strStack.push("there");
        strStack.push(":)");

        System.out.println(strStack);
    }
}
