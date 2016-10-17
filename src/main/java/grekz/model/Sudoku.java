package grekz.model;

import grekz.enumeration.BoardEnum;
import grekz.util.BoardUtils;

import java.util.Arrays;

/**
 * Created by juanmend on 10/16/2016.
 */
public class Sudoku {
    private int[][] grid;
    private boolean isValidGrid;
    private boolean isSolved;
    private String state;
    private String previousState;


    public Sudoku(String state, String move) {
        this(state);
        char[] mv = move.toCharArray();
        if (mv.length < 3) {
            // invalid move, not enough for x, y and value
            this.validate();
        }else{
            // valid input, we check if is valid
            this.validateMove(mv[0] - '0', mv[1] - '0', mv[2] - '0');
        }
        this.checkIfSolved();
    }

//    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("0010", 10));
//        System.out.println(Integer.toString(907400000, Character.MAX_RADIX));
//        System.out.println(Arrays.toString("asdas.dasdada".split("\\.")));
//    }
    public Sudoku(){
        // TODO = Implement valid random board generated.
        this(BoardEnum.DEFAULT);
    }
    public Sudoku(BoardEnum boardEnum){
        this(boardEnum.getState());
    }
    public Sudoku(int[][] grid){
        this.grid = grid;
        this.validate();
        this.checkIfSolved();
    }

    public Sudoku(String state){
        if (state.equals("default"))
            state = BoardEnum.DEFAULT.getState();
        this.grid = BoardUtils.generateGrid(state);
        this.state = "/sudoku/" + state.toUpperCase();
        this.previousState = this.state;
        this.validate();
        this.checkIfSolved();
    }
    private void checkIfSolved(){
        if (this.isValidGrid){
            this.isSolved = true;
            grid_loop:
            for(int[] a : this.grid)
                for (int b : a)
                    if (b == 0) {
                        this.isSolved = false;
                        break grid_loop;
                    }
        }else{
            this.isSolved = false;
        }
    }

    @SuppressWarnings("Duplicates")
    private void validate(){
        if (grid == null) return;
        // check rows
        boolean[] vals = new boolean[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int num = grid[i][j] - 1;
                if (num >= 0){
                    if(vals[num]){
                        isValidGrid = false;
                        return;
                    }
                    vals[num] = true;
                }
            }
            Arrays.fill(vals, false);
        }

        // check columns
        for(int jc = 0; jc < 9; jc++){
            for(int ic = 0; ic < 9; ic++){
                int num = grid[ic][jc] - 1;
                if (num >= 0){
                    if(vals[num]){
                        isValidGrid = false;
                        return;
                    }
                    vals[num] = true;
                }
            }
            Arrays.fill(vals, false);
        }

        // check for blocks
        for(int block = 0; block < 9; block++){
            for (int ii = block / 3 * 3; ii < block / 3 * 3 + 3; ii++){
                for(int jj = block % 3*3 ; jj < block % 3 * 3 + 3; jj++){
                    int num = grid[ii][jj] - 1;
                    if (num >= 0){
                        if(vals[num]){
                            isValidGrid = false;
                            return;
                        }
                        vals[num] = true;
                    }
                }
            }
            Arrays.fill(vals, false);
        }

        isValidGrid = true;
    }
    private void validateMove(int x, int y, int value){
        this.grid[x][y] = value;
        this.previousState = this.state;
        this.state = "/sudoku/" + BoardUtils.getStateFromGrid(grid);
        this.validate();
        this.checkIfSolved();
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public boolean isValidGrid() {
        return isValidGrid;
    }

    public void setValidGrid(boolean valid) {
        isValidGrid = valid;
    }

    public String getState() {
        return state;
    }

    public String getPreviousState() {
        return previousState;
    }

    public boolean isSolved() {
        return isSolved;
    }
}
