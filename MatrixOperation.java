
package tubesstrukdatpuzzle;



public class MatrixOperation {  
	private int[][] matrix;
	private Coor coor;

	public MatrixOperation(int[][] matrix, Coor coor) { 
		this.matrix = matrix;
		this.coor = coor;
	}

	public MatrixOperation() {
	}
        
	int[][] getRight() {
		int returnMatrix[][] = copyArray();
		returnMatrix[coor.y][coor.x] = returnMatrix[coor.y][coor.x - 1];
		returnMatrix[coor.y][coor.x - 1] = 0;
		return returnMatrix;
	}

	int[][] getLeft() {
		int returnMatrix[][] = copyArray();
		returnMatrix[coor.y][coor.x] = returnMatrix[coor.y][coor.x + 1];
		returnMatrix[coor.y][coor.x + 1] = 0;
		return returnMatrix;
	}

	int[][] getDown() {
		int returnMatrix[][] = copyArray();
		returnMatrix[coor.y][coor.x] = returnMatrix[coor.y - 1][coor.x];
		returnMatrix[coor.y - 1][coor.x] = 0;
		return returnMatrix;
	}

	int[][] getUp() {
		int returnMatrix[][] = copyArray();
		returnMatrix[coor.y][coor.x] = returnMatrix[coor.y + 1][coor.x];
		returnMatrix[coor.y + 1][coor.x] = 0;
		return returnMatrix;
	}
	
	int[][] copyArray(){
		int[][] returnArray = new int[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				returnArray[i][j] = matrix[i][j];
			}
		}
		return returnArray;
	}
}
