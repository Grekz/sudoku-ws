package grekz.model;

import grekz.enumeration.Board;

import java.util.Arrays;

/**
 * Created by juanmend on 10/16/2016.
 */
public class Sudoku {
    private int[][] grid;
    private boolean isValid;

    public static void main(String[] args) {
        System.out.println(Character.MAX_RADIX);
        System.out.println(Integer.toString(907400000, Character.MAX_RADIX));
        System.out.println(Arrays.toString("asdas.dasdada".split("\\.")));
    }
    public Sudoku(){
        // TODO = Implement valid random board generated.
        this(Board.DEFAULT);
    }
    public Sudoku(Board board){
        this(board.getGrid());
    }
    public Sudoku(int[][] grid){
        this.grid = grid;
        validate();
    }

    public boolean validate(){
        // TODO 1 = check rows
        // TODO 2 = check columns
        // TODO 3 = check 3x3 grids
        isValid = false;
        return false;
    }
    public boolean validateMove(int x, int y, int value){
        grid[x][y] = value;
        boolean res = validate();
//        if ( !res ) grid[x][y] = 0; // if not a valid move, reset value
        return res;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
