package hello;

public class Addition {
	private final int x;
	private final int y;
	
	public Addition (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public long getSum() {
		return x + y;
	}
	
}