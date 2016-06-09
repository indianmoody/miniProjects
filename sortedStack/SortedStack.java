// @author: Gaurav Bishnoi

public class ex3 {

	public static void main(String[] args) {
		
		stacks st = new stacks();
		System.out.println(st.isEmpty());
		st.push(7);
		st.push(3);
		st.push(21);
		st.push(10);
		st.push(90);
		st.push(2);
		
		SortStack s = new SortStack(st);
		s.sort();
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}
		

	}

}

class SortStack {
	
	stacks s1 = new stacks();
	stacks s2 = new stacks();
	
	public SortStack(stacks st) {
		s1 = st;
	}
	
	public void sort() {
		while (!s1.isEmpty()) {
			Integer x = s1.pop();
			if (s2.isEmpty()) {
				s2.push(x);
			}
			else {
				int count = 0;
				while (!s2.isEmpty()) {
					if (x < s2.peek()) {
						s1.push(s2.pop());
						count++;
					}
					else {
						s2.push(x);
						break;
					}
				}
				while (count > 0) {
					s2.push(s1.pop());
					count--;
				}
			}
		}
		
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
}

class stacks {
	private int limit = 100;
	private Integer[] arr = new Integer[limit];
	private int size = 0;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void push(Integer n) {
		if (size < limit || size > 0) {
			arr[size] = n;
			size++;
		}
		else {
			System.out.println("Stack is full");
		}
	}
	
	public Integer pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty, can't pop!");
			return null;
		}
		else {
			Integer temp = arr[size-1];
			arr[size-1] = null;
			size--;
			return temp;
		}
	}
	
	public Integer peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty, can't peek!");
			return null;
		}
		else {
			return arr[size-1];
		}
	}
	
}


