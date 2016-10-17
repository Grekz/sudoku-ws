package grekz.util;

/**
 * Created by juanmend on 10/16/2016.
 *
 * Simple utility class to help with Board opearations
 *
 * @author Juan Mendoza
 */
public class BoardUtils {
    public static int[][] generateGrid(String state){
        // receives a state string, containing the rows in base36 format
        int[][] grid = new int[9][9];
        String rows[] = state.split("\\-");
        int i = 0, j = 0;
        for(String r : rows) {
            if (r.length() > 0 ){
                r = Integer.parseInt(r, 36) + "";
                for(int k = 0; k < 9 - r.length(); k++ )
                    grid[j][i++] = 0; // fill leading zeros.
                for (char c : r.toCharArray())
                    grid[j][i++] = c - '0'; // fill proper values of grid
            }
            i = 0;
            j++;
        }
        return grid;
    }

    public static String getStateFromGrid(int[][] grid) {
        StringBuilder res = new StringBuilder();
        for(int[] a : grid){
            StringBuilder sb = new StringBuilder();
            for(int x : a)
                sb.append(x);
            res.append(Integer.toString(Integer.parseInt(sb.toString(),10), 36)).append('.');
        }
        String result = res.toString();
        return result.substring(0, result.length() - 1).toUpperCase();
    }
}
