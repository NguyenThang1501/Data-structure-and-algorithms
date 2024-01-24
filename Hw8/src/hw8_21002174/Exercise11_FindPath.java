package hw8_21002174;

public class Exercise11_FindPath {
    public static void isPath(int[][] matrix, int n)
    {
        boolean[][] visited = new boolean[n][n];
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // if matrix[i][j] is source
                // and it is not visited
                if (matrix[i][j] == 1 && !visited[i][j])

                    // Starting from i, j and
                    // then finding the path
                    if (isPath(matrix, i, j, visited)) {
                        // if path exists
                        flag = true;
                        break;
                    }
            }
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    // Method for checking boundaries
    public static boolean isSafe(int i, int j, int[][] matrix)
    {

        return i >= 0 && i < matrix.length && j >= 0
                && j < matrix[0].length;
    }

    public static boolean isPath(int[][] matrix, int i,
                                 int j, boolean[][] visited)
    {

        if (isSafe(i, j, matrix) && matrix[i][j] != 0
                && !visited[i][j]) {
            visited[i][j] = true;

            if (matrix[i][j] == 2)
                return true;

            boolean up = isPath(matrix, i - 1, j, visited);

            if (up)
                return true;

            boolean left
                    = isPath(matrix, i, j - 1, visited);

            if (left)
                return true;

            boolean down
                    = isPath(matrix, i + 1, j, visited);

            if (down)
                return true;

            boolean right
                    = isPath(matrix, i, j + 1, visited);

            if (right)
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {

        int[][] matrix = { { 0, 3, 0, 1 },
                { 3, 0, 3, 3 },
                { 2, 3, 3, 3 },
                { 0, 3, 3, 3 } };

        isPath(matrix, 4);
    }
}
