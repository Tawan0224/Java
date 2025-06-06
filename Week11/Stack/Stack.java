package Week11.Stack;

public class Stack {
    private int top;
    private int size;
    private int[] array;

    //Default Constructor creates as stack of size 10
    public Stack(){
        this.size = 10;
        this.top = -1;
        this.array = new int[size];
    }

    public Stack(int size){
        this.size = size;
        this.top = -1;
        this.array = new int[size];
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == size-1;
    }
    public boolean push(int item){
        if (isFull()){
            return false;
        }else {
            top++;
            array[top] = item;
            return true;
        }
    }
    public int pop(){
        int item;
        if(isEmpty()){
            return -1;
        }else{
            item = array[top];
            top--;
            return item;
        }
    }
    public int getTop(){
        if(isEmpty()){
            return -1;
        }else{
            return array[top];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        for (int i = top; i >= 0; i--) {
            result.append(array[i]);
            result.append(" ");
        }
        result.append("]");
        return result.toString();
    }
}
