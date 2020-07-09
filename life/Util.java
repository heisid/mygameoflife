package life;

public class Util {
    public static boolean[][] cloneMatrix(boolean[][] a) {
        boolean[][] b = new boolean[a.length][];
        for (int i = 0; i < a.length; i++) {
            b[i]= new boolean[a[i].length];
            System.arraycopy(a[i], 0, b[i], 0, a[i].length);
        }
        return b;
    }

    public static int mod(int n, int m) {
        return (((n % m) + m) % m);
    }

    public static int countAliveInRow(boolean[] cells) {
        int count = 0;
        for (boolean cell : cells) {
            if (cell) {
                count++;
            }
        }
        return count;
    }
}

