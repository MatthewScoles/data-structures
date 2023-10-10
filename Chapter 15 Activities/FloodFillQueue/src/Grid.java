import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> fill = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        Pair Pix = new Pair(row, column);
        fill.push(Pix);

        int count = 1;
        while(!fill.isEmpty()) {
            Pix = fill.pop();
            row = Pix.getRow();
            int col = Pix.getColumn();

            if (pixels[row][col] == 0) {
                if (row != 0) {
                    Pix = new Pair(row-1, col);
                    fill.push(Pix);
                }
                if (col != 9) {
                    Pix = new Pair(row, col+1);
                    fill.push(Pix);
                }
                if (row != 9) {
                    Pix = new Pair(row+1, col);
                    fill.push(Pix);
                }
                if (col != 0) {
                    Pix = new Pair(row, col-1);
                    fill.push(Pix);
                }

                pixels[row][col] = count;
                count++;
            }
        }

        System.out.println(toString());
    }

    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%3d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
