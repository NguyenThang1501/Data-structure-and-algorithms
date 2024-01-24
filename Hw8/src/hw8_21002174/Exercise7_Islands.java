package hw8_21002174;

public class Exercise7_Islands {
    boolean isSafe(char[][] grid, int row, int col, boolean[][] visited, int ROW,
                   int COL) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) &&
                (grid[row][col] == '1' && !visited[row][col]);
    }
    void DFS(char grid[][], int row, int col, boolean[][] visited, int ROW,
             int COL) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int[] rowNbr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int k = 0; k < 8; ++k)
            if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visited, ROW, COL))
                DFS(grid, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (grid[i][j] == '1' && !visited[i][j]) // If a cell with
                {                                        // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(grid, i, j, visited, ROW, COL);
                    ++count;
                }

        return count;
    }

}
