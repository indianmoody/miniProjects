// @author: Gaurav Bishnoi
// Single LinkedList with advanced features, please refer "readme.txt".		
		
// Single Linked List
public class TestSinglyLinkedList{

     public static void main(String []args){
        SinglyLinkedList lst = new SinglyLinkedList();
        int x = 5;
        int y = 7;
        int z = 7;
        lst.addFirst(x);
        lst.addLast(y);
        lst.addFirst(z);
        System.out.println(lst.size());
        /*System.out.println(lst.isEmpty());
        lst.removeFirst();
        System.out.println(lst.isEmpty());
        System.out.println(lst.size());
        lst.removeFirst();
        System.out.println(lst.isEmpty());
        System.out.println(lst.size());
        lst.removeFirst();
        System.out.println(lst.isEmpty());
        System.out.println(lst.size());
        lst.removeFirst();
        System.out.println(lst.isEmpty());
        System.out.println(lst.size());*/
        lst.removeElement(y);
        System.out.println(lst.size());
	lst.addLast(21);
	lst.addLast(31);
	lst.addLast(41);
	lst.printList();
     }
}

class SinglyLinkedList<E> {
	
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node (E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> e) {
			next = e;
		}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList() {}
	
	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}
	
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (isEmpty())
			tail = head;
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if (isEmpty()) {
			System.out.println("List is already Empty!");
			return null;
		}
		E answer = head.getElement();	
		head = head.getNext();
		size--;
		if (isEmpty()) {
			tail = null;
			System.out.println("Now, list is empty!");
		}
		return answer;
	}
	
	public void removeElement(E e) {
		int check = 0;
		Node<E> n = head;
		Node<E> m = head;
		if (n.getElement() == e) {
			head = head.getNext();
			n = n.getNext();
			size--;
			if (isEmpty()) 
				tail = null;
			check++;
		}
			
		while (n != null)
		{
			if (n.getElement() == e) {
				m.setNext(n.getNext());
				if (n.getNext() == null) {
					tail = m;
					n = n.getNext();
				}
				else {
					n = n.getNext();
				}
				size--;
				check++;
			}
			else {
				m = n;
				n = n.getNext();
			}
			
		}
		if (check == 0)
			System.out.println("Specified element was not found in the list!");
		else
			System.out.println("Specified element is removed from list!");
	}
	
	public void printList() {
		Node<E> n = head;
		while (n != null) {
			System.out.println(n.getElement());
			n = n.next;
		}
	}
}


// --------------------------------------------------------------------


