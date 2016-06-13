// @author: Gaurav Bishnoi

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		Node a = new Node();
		a.name = "a";
		Node b = new Node();
		b.name = "b";
		Node c = new Node();
		c.name = "c";
		Node d = new Node();
		d.name = "d";
		Node e = new Node();
		e.name = "e";
		Node f = new Node();
		f.name = "f";
		Node g = new Node();
		g.name = "g";
	    a.left = b;
	    a.right = e;
	    b.left = c;
	    b.right = d;
	    d.left = f;
	    d.right = g;
	     
	    Traverse tr = new Traverse();
	    tr.inTraverse(a);
	    System.out.println(" ");
		tr.preTraverse(a);
		System.out.println(" ");
		tr.postTraverse(a);

	}

}

class Node {
    public String name;
    public Node left;
    public Node right;
}

class Traverse {
    
    private void visit(Node n) {
        System.out.print(n.name + " ");
    }
    
    public void inTraverse (Node n) {
        if (n != null) {
            inTraverse (n.left);
            visit(n);
            inTraverse (n.right);
        }
        
    }
    
    public void preTraverse(Node n) {
    	if (n != null) {
    		visit(n);
    		preTraverse(n.left);
    		preTraverse(n.right);
    	}
    }
    
    public void postTraverse(Node n) {
    	if (n != null) {
    		postTraverse(n.left);
    		postTraverse(n.right);
    		visit(n);
    	}
    }
}
