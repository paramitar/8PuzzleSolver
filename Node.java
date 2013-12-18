
package tubesstrukdatpuzzle;

public class Node { 
	int[][] data;
	int[][] reff = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
	int match = 0;
	boolean isNull;
	Node left, right, up, down;

	public Node(int[][] data, Tracer trace) { 
		this.data = data;
		this.left = trace.left;
		this.right = trace.right;
		this.up = trace.up;
		this.down = trace.down;

		if (data != null) {
			checkMatch();
		} else {
			this.match = 0;
			this.isNull = true;
		}
	}

	public void checkMatch() { //method 
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i][j] == reff[i][j] && !(i == 2 && j == 2)) {
					match++;
				}
			}
		}
	}
}
