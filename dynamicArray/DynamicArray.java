// @Author: Gaurav Bishnoi

public class DynamicArray{

     public static void main(String []args){
        DynamicArraylist dal = new DynamicArraylist();
        System.out.println(dal.isEmpty());
        for (int i=0; i<10; i++) {
            dal.add(i);
        }
        dal.add(21, 5);
        System.out.println(dal.size());
        dal.remove(5);
        System.out.println(dal.currentLimit());
        
     }
}

class DynamicArraylist {
    private int size = 0;
    private int limit = 10;
    private Integer[] arr = new Integer[limit];
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public int currentLimit() {
        return limit;
    }
    
    public void resize() {
        limit = 2*limit;
        Integer[] temp = new Integer[limit];
        for (int i=0; i<arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
    
    public Integer get(int i) {
        if (i>0 || i< limit) {
            return arr[i];
        }
        else {
            System.out.println("invalid index!");
            return null;
        }
    }
    
    public void set(Integer d, int i) throws IndexOutOfBoundsException {
        if (i<0 || i>=size) throw new IndexOutOfBoundsException("invalid index exception!");
        arr[i] = d;
    }
    
    public void add(Integer d) {
        if (size >= limit) {
            resize();
        }
        arr[size] = d;
        size++;
    }
    
    public void add(Integer d, int i) throws IndexOutOfBoundsException {
        if (i<0 || i>size) throw new IndexOutOfBoundsException("invalid index exception!");
        if (size >= limit) {
            resize();
        }
        
        for (int j=size; j>i; j--) {
            arr[j] = arr[j-1];
        }
        arr[i] = d;
        size++;
    }
    
    public Integer remove (int i) throws IndexOutOfBoundsException {
        if (i<0 || i>size) throw new IndexOutOfBoundsException("invalid index exception!");
        Integer temp = arr[i];
        for (int j=i; j<size-1; j++) {
            arr[j] = arr[j+1];
        }
        arr[size-1] = null;
        size--;
        return temp;
    }
    
}