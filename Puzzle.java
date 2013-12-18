package tubesstrukdatpuzzle;

public class Puzzle { 

    int size = 3;
    int[][] matrix;
    public final int[][] reff = new int[][]{{1, 2, 3}, {4, 5, 6},
        {7, 8, 0}};
    boolean found = false, isLoop = false;
    int counter = 0, round = 0;
    boolean loopUp = false, loopDown = false, loopLeft = false,
            loopRight = false;
    int leftChild = 0, rightChild = 0, upChild = 0, downChild = 0;
    MatrixOperation operation = new MatrixOperation();

    void solve() {
        Node root = new Node(matrix, new Tracer());
        found = false;
        buildTree(root, false, false, false, false);
    }

    boolean isCorrect(Node parent) {
        if (parent.data == null) {
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (parent.data[i][j] != reff[i][j]) {
                        return false;
                    }
                }
            }
        }
        found = true;
        return true;
    }

    void buildTree(Node parent, boolean moveUp, boolean moveDown,
            boolean moveLeft, boolean moveRigth) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(parent.data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("+=======================+");

        while (!isCorrect(parent) && parent.data != null && !found) {
            int[][] left = null, right = null, up = null, down = null;
            Coor coor = null;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (parent.data[i][j] == 0) {
                        coor = new Coor(j, i);
                    }
                }
            }

            operation = new MatrixOperation(parent.data, coor);

            if (coor != null) {
                if (coor.x > 0) {
                    if (coor.x < size - 1) {
                        left = operation.getLeft();
                    }
                    right = operation.getRight();
                } else {
                    left = operation.getLeft();
                }

                if (coor.y > 0) {
                    if (coor.y < size - 1) {
                        up = operation.getUp();
                    }
                    down = operation.getDown();
                } else {
                    up = operation.getUp();
                }
            }

            parent = new Node(parent.data, new Tracer(left, right, up, down));
            System.out.println(parent.left.match + " " + parent.right.match
                    + " " + parent.up.match + " " + parent.down.match);



            counter++;
            if (counter == 4 && isLooping()) {
                break;
            } else if (counter == 4) {
                counter = 0;
                loopDown = loopLeft = loopRight = loopUp = false;
            }

            if (parent.left.match >= parent.match && !moveRigth && !found
                    && !parent.left.isNull) {
                System.out.println("left");
                loopLeft = !loopLeft;
                buildTree(parent.left, false, false, true, false);
            }
            if (parent.right.match >= parent.match && !moveLeft && !found
                    && !parent.right.isNull) {
                System.out.println("right");
                loopRight = !loopRight;
                buildTree(parent.right, false, false, false, true);
            }
            if (parent.up.match >= parent.match && !moveDown && !found
                    && !parent.up.isNull) {
                System.out.println("up");
                loopUp = !loopUp;
                buildTree(parent.up, true, false, false, false);
            }
            if (parent.down.match >= parent.match && !moveUp && !found
                    && !parent.down.isNull) {
                System.out.println("down");
                loopDown = !loopDown;
                buildTree(parent.down, false, true, false, false);
            }

            break;
        }

    }

    boolean isLooping() {
        return loopDown && loopLeft && loopRight && loopUp;
    }

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        puzzle.matrix = new int[][]{{1, 2, 3}, {8, 7, 0}, {6, 5, 4}};
        puzzle.solve();
    }
}
