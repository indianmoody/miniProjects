// @Author: Gaurav Bishnoi

public class ArrayQueue{

     public static void main(String []args){
        Queues q = new Queues();
        System.out.println(q.isEmpty());
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(87);
        System.out.println(q.first());
        System.out.println(q.size());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.size());
        q.dequeue();
     }
}

class Queues {
    private int limit = 100;
    private Integer[] arr = new Integer[limit];
    private int size = -1;
    private int start = 0;
    
    public int size() {
        return (size+1);
    }
    
    public boolean isEmpty() {
        return (size == -1);
    }
    
    public Integer first() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return arr[start];
    }
    
    public void enqueue(Integer data) throws IllegalStateException{
        if (size >= limit) throw new IllegalStateException("Queue is full!");
        size++;
        arr[(start+size)%limit] = data;
    }
    
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Can't access value!");
            return null;
        }
        Integer temp = arr[start];
        arr[start] = null;
        size--;
        start++;
        start = start%limit;
        return temp;
    }
    
}
