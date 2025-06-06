package Week11.Node;

public class StackV2 {
    private Node top;
    private int size;
    private int count;

    public StackV2(){
        this.top = null;
        this.size = 10;
        this.count = 0;
    }
    public StackV2(int size){
        this.top = null;
        this.size = size;
        this.count = 0;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return count == size;
    }
    public boolean push(int item){
        if(isFull()){
            return false;
        }else{
            Node newNode = new Node(item);
            newNode.setNext(top);
            top = newNode;
            count++;
            return true;
        }
    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }else{
            int item = top.getData();
            top = top.getNext();
            count--;
            return item;
        }
    }
    public int getTop(){
        if(isEmpty()){
            return -1;
        }else{
            return top.getData();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        Node current = top;
        while (current != null) {
            result.append(current.getData()).append(" ");
            current = current.getNext();
        }
        result.append("]");
        return result.toString();
    }
}
