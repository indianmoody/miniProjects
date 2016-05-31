import java.util.Arrays;

public class LinkedListStack{

     public static void main(String []args){
        Stacks st = new Stacks();
        int x = 5;
        int y = 7;
        int z = 11;
        System.out.println(st.size());
        st.push(x);
        st.push(y);
        st.push(z);
        System.out.println(st.size());
        int d = st.pop();
        System.out.println(st.size());
        st.pop();
        st.pop();
        System.out.println(st.size());
        st.pop();
        System.out.println("d = " + d);
     }
}

class Stacks {
    private int limit = 100;
    private Integer[] arr = new Integer[limit];
    private int size = -1;
    
    public boolean isEmpty() {
        return (size == -1);
    }
    
    public int size() {
        return (size+1);
    }
    
    public Integer peek() {
        if (!isEmpty()) {
            return arr[size];
        }
        else {
            System.out.println("Stack is empty!");
            return null;
        }
    }
    
    public void push (Integer data) throws IllegalStateException{
        if (size() >= limit) throw new IllegalStateException("Stack is Full!");
        arr[++size] = data;
    }
    
    public Integer pop () {
        if (!isEmpty()) {
            Integer temp = arr[size];
            arr[size] = null;
            size--;
            return temp;
        }
        else {
            System.out.println("Stack is empty! Can't pop!");
            return null;
        }
    }
    
}