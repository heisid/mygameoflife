package life;

public class Universe {
    private int size;
    private boolean[][] state;

    public Universe(int size) {
        this.size = size;
        this.state = new boolean[size][size];
    }

    public void setAt(int x, int y, boolean cell) {
        state[y][x] = cell;
    }

    public void setState(boolean[][] array) {
        state = Util.cloneMatrix(array);
    }

    public boolean[][] getState() {
        return Util.cloneMatrix(state);
    }

    public int countAlive() {
        int count = 0;
        for (boolean[] row : state) {
            count += Util.countAliveInRow(row);
        }
        return count;
    }

    public void draw() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (state[y][x]) {
                    System.out.print('O');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.print('\n');
        }
    }

}

