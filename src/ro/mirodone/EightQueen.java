package ro.mirodone;

public class EightQueen {

   private final int N = 5;


   private boolean isSafe(int board[][], int row, int col) {
        int i, j;

        //check row on left side

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        //check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        //check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    //solve problem using a recursive utility function

    private boolean solveUtilFct(int board[][], int col) {

        //all queens are placed
        if (col >= N)
            return true;


        for (int i = 0; i < N; i++) {
            //check if queen can be placed on board[i][col]
            if (isSafe(board, i, col)) {
                //if ok, place this queen on board[i][col]
                board[i][col] = 1;

                //recurrence to place all the queens
                if (solveUtilFct(board, col + 1))
                    return true;

                //if placing queen in board[i][col] does not lead to solution,
                //remove queen

                board[i][col] = 0;
            }
        }
        return false;
    }

    // method to print the solution
    private void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    void solveQueen() {

        int board[][] = {{0, 0, 0, 0,0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
        };

        //if (solveUtilFct(board, 0) == false)
        if (!solveUtilFct(board, 0)) {
            System.out.println("No solution !");

        }

        printSolution(board);

    }

}
