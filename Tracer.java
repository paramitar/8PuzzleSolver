package tubesstrukdatpuzzle;

public class Tracer { 
	Node left;
	Node right;
	Node up;
	Node down;

	public Tracer(int[][] left, int[][] right, int[][] up, int[][] down) {
		this.left = new Node(left, new Tracer());
		this.right = new Node(right, new Tracer());
		this.up = new Node(up, new Tracer());
		this.down = new Node(down, new Tracer());
	}

	public Tracer() {

	}
}
