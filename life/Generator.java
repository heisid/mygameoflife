package life;

public class Generator {
    private boolean[][] inputState;
    private boolean[][] outputState;
    private int size;

    public Generator(boolean[][] currentState) {
        this.inputState = Util.cloneMatrix(currentState);
        this.size = this.inputState[0].length;
        this.outputState = Util.cloneMatrix(inputState);
    }

    public boolean[] getNeighborsOf(int x, int y) {
        boolean NW = inputState[Util.mod(y - 1, size)][Util.mod(x - 1, size)];
        boolean N = inputState[Util.mod(y - 1, size)][x];
        boolean NE = inputState[Util.mod(y - 1, size)][Util.mod(x + 1, size)];
        boolean W = inputState[y][Util.mod(x - 1, size)];
        boolean E = inputState[y][Util.mod(x + 1, size)];
        boolean SW = inputState[Util.mod(y + 1, size)][Util.mod(x - 1, size)];
        boolean S = inputState[Util.mod(y + 1, size)][x];
        boolean SE = inputState[Util.mod(y + 1, size)][Util.mod(x + 1, size)];
        return new boolean[]{NW, N, NE, W, E, SW, S, SE};
    }

    public void generateNext() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                int numOfNeighbors = Util.countAliveInRow(getNeighborsOf(x, y));
                if (inputState[y][x]) {
                    if (numOfNeighbors < 2 || numOfNeighbors > 3) {
                        outputState[y][x] = false;
                    }
                } else {
                    if (numOfNeighbors == 3) {
                        outputState[y][x] = true;
                    }
                }
            }
        }
    }

    public boolean[][] getOutputState() {
        return outputState;
    }
}

