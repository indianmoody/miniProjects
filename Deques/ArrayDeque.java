public class ArrayDeque{

     public static void main(String []args){
        Deques d = new Deques();
        System.out.println(d.isEmpty());
        d.addFirst(10);
        d.addLast(15);
        d.addLast(20);
        d.addFirst(5);
        d.addLast(30);
        System.out.println(d.isEmpty());
        System.out.println(d.removeLast());
        while (!d.isEmpty()) {
            System.out.println(d.removeFirst());
        }
     }
}

class Deques {
    
    private int size = -1;
    private int start = 0;
    private int limit = 100;
    private Integer[] arr = new Integer[limit];
    
    public boolean isEmpty() {
        return (size == -1);
    }
    
    public int size() {
        return (size+1);
    }
    
    public void addFirst(Integer data) throws IllegalStateException {
        if (size() >= limit) throw new IllegalStateException("Deque is full!");
        size++;
        start = (start+limit-1)%limit;
        arr[start] = data;
    }
    
    public void addLast(Integer data) throws IllegalStateException {
        if (size() >= limit) throw new IllegalStateException("Deque is full!");
        size++;
        arr[(start+size)%limit] = data;
    }
    
    public Integer removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque is already empty! Can't remove!");
            return null;
        }
        Integer temp = arr[start];
        arr[start] = null;
        size--;
        start = (start+1)%limit;
        return temp;
    }
    
    public Integer removeLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty! There is no last element!");
        }
        Integer temp = arr[(start+size)%limit];
        arr[(start+size)%limit] = null;
        size--;
        return temp;
    }
    
    public Integer first() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }
        return arr[start];
    }
    
    public Integer last() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }
        return arr[(start + size) % limit];
    }
}