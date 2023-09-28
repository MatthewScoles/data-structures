import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)
        // ...
        Set<Integer> ROW = new HashSet<>();
        
        rows = new ArrayList<>();
        for (int row = 0; row < N; row++){
                ROW = new HashSet<>();
            for (int col = 0; col< N; col++){
                ROW.add(grid[row][col]);
            }
           this.rows.add(ROW);
        }




        


        // create the list of sets for each col (this.cols)
        // ...

        Set<Integer> COL = new HashSet<>();
        int i = 0;
        cols = new ArrayList<>();
            for (int col = 0;col < N; col++) {
                
                for (int row = 0; row < N; row++) {
                    int number = this.grid[row][col];
                    COL.add(number);
                }
                this.cols.add(COL);
                COL = new HashSet<>();
            }
    

        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        // ...
        squares = new ArrayList<>();
        for (i = 0; i < N; i++){
            Set<Integer> SQR = new HashSet<>();
            for (int j = i/M*M; j < i/M*M + M; j++){
                for (int k = i%M*M; k < i%M*M + M; k++){
                    SQR.add(grid[j][k]);
           
        }
    } 
        this.squares.add(SQR);}
            

        // create a hash set for [1..9] (this.nums)
        // ...
        nums = new HashSet<>();
        int n = 1;
        while (n <= 9){
            this.nums.add(n);
            n++;
        }


        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */

         int square = -1;
        if (nextRow < 3){
            switch (nextCol / 3){
                case 0:
                    square = 0;
                    break;
                case 1:
                    square = 1;
                    break;
                case 2:
                    square = 2;
                    break;
            }
        } else if (nextRow < 6){
            switch (nextCol / 3){
                case 0:
                    square = 3;
                    break;
                case 1:
                    square = 4;
                    break;
                case 2:
                    square = 5;
                    break;
            }
        } else {
            switch (nextCol / 3){
                case 0:
                    square = 6;
                    break;
                case 1:
                    square = 7;
                    break;
                case 2:
                    square = 8;
                    break;
            }
        }
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        
        // ...
        possibleNums.removeAll(this.rows.get(nextRow));
        possibleNums.removeAll(this.cols.get(nextCol));
        possibleNums.removeAll(this.squares.get(square)); 


        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            this.grid[nextRow][nextCol] = possibleNum;
            this.rows.get(nextRow).add(possibleNum);
            this.cols.get(nextCol).add(possibleNum);
            this.squares.get(square).add(possibleNum);

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
             /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                // ...
            } else {
                this.grid[nextRow][nextCol] = 0;
                this.rows.get(nextRow).remove(possibleNum);
                this.cols.get(nextCol).remove(possibleNum);
                this.squares.get(square).remove(possibleNum);
            }
        }

        return false;
    }


    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Msscoles\\Desktop\\data-structures\\Chapter 15 Activities\\Sudoku\\src\\puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}