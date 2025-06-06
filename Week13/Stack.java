package Week13;

public class Stack<T> {
    private Node<T> top;
    private int size;
    private int count;

    public Stack(){
        this.top = null;
        this.size = 10;
        this.count = 0;
    }
    public Stack(int size){
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
    public boolean push(T item){
        if(isFull()){
            return false;
        }else{
            Node<T> newNode = new Node<T>(item);
            newNode.setNext(top);
            top = newNode;
            count++;
            return true;
        }
    }
    public T pop(){
        if(isEmpty()){
            return null;
        }else{
            T item = top.getData();
            top = top.getNext();
            count--;
            return item;
        }
    }
    public T getTop(){
        if(isEmpty()){
            return null;
        }else{
            return top.getData();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        Node<T> current = top;
        while (current != null) {
            result.append(current.getData()).append(" ");
            current = current.getNext();
        }
        result.append("]");
        return result.toString();
    }
}
