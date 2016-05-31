import java.util.*;

public class LinkedListStack{

     public static void main(String []args){
         Stacks st = new Stacks();
        Integer x = 5;
        Integer y = 7;
        Integer z = 11;
        System.out.println(st.size());
        st.push(x);
        st.push(y);
        st.push(z);
        System.out.println(st.size());
        Integer d = st.pop();
        System.out.println(st.size());
        st.pop();
        st.pop();
        System.out.println(st.size());
        st.pop();
        System.out.println("d = " + d);
        
     }
}

class Stacks {
    LinkedList ll = new LinkedList();
    private int size = -1;
    
    public boolean isEmpty() {
        return (size == -1);
    }
    
    public int size() {
        return (size+1);
    }
    
    public Integer peek() {
        if (!isEmpty()) {
            return (Integer) ll.getLast();
        }
        else {
            System.out.println("Stack is empty!");
            return null;
        }
    }
    
    public void push (Integer data) {
        ll.addLast(data);
        size++;
    }
    
    public Integer pop () {
        if (!isEmpty()) {
            size--;
            return (Integer) ll.removeLast();
        }
        else {
            System.out.println("Stack is empty! Can't pop!");
            return null;
        }
    }
    
}
