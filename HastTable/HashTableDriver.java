//@author: Gaurav Bishnoi

public class HashTableDriver{
   
    public static void main(String []args){
        HashT ht = new HashT(10);
        ht.add("Hank Moody", 41);
        ht.add("Gaurav", 25);
        ht.add("Saurav", 27);
        System.out.println(ht.searchNode("Gaurav"));
        System.out.println(ht.ll[6].size());
        
        
    }
}

class HashT {
    private int limit;
    public LinkList[] ll;
    
    private int hashC(String k) {
            int i =  k.length();
            return i;
    }
    
    public HashT(int l) {
        limit = l;
        ll = new LinkList[limit];
    }
    
    public void add(String k, Integer v) {
        int m = hashC(k) % limit;
        if (ll[m] == null) {
            ll[m] = new LinkList();
            ll[m].addNode(k, v);
        }
        else {
            ll[m].addNode(k, v);
        }
    }
    
    public Integer searchNode(String k) {
        int m = hashC(k) % limit;
        return ll[m].searchNode(k);
    }
    
    
}

// ---- linklist
    class LinkList {
    
    public LinkList() { };
    
    class Node {
        private String key;
        private Integer value;
        Node next;
        
        public Node(String k, Integer v, Node n) {
            key = k;
            value = v;
            next = n;
        }
        
        public String getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer v) {
            value = v;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node n) {
            next = n;
        }
    }
    
    private int size = -1;
    private Node head = null;
    
    public int size() {
        return (size+1);
    }
    public boolean isEmpty() {
        return (size == -1);
    }
    
    public void addNode(String k, Integer v) {
        int check = 0;
        Node n = head;
        while (n != null) {
            if (n.getKey() == k) {
                n.setValue(v);
                check = 1;
                break;
            }
            n = n.next;
        }
        if (check == 0) {
            head = new Node(k, v, head);
            size++;
        }
    }
    
    public Integer searchNode(String k) {
        Node n = head;
        while (n != null) {
            if (n.getKey() == k) {return n.getValue(); }
            n = n.next;
        }
        return null;
    }
}
