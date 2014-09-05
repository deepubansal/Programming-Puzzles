package puzzles.datastructures.algos;

/**
 * 
 * Given a gold mine of n*m dimension. Each field in this mine contains an
 * integer which is amount of gold in tons. Initially miner is in first column
 * but could be at any row i. He can move only (right ->, right up /, right down
 * \). Find out maximum amount of gold he can collect and path followed by him.
 * 
 * @author deepak
 * 
 */

public class GoldMines {

    public static void main(String[] args) {
        int[][] mines = { { 2, 1, 2, 6, 2, 1 }, { 3, 4, 3, 4, 3, 4 }, { 8, 5, 4, 1, 4, 1 }, { 3, 2, 1, 6, 2, 3 }, { 2, 5, 4, 3, 6, 5 },
                { 1, 7, 1, 9, 4, 2 } };
        // int[][] mines = { { 5, 2, 5 }, { 3, 4, 6} };

        StringBuilder path = new StringBuilder();
        int startI = 2;
        int maxGold = maxGold(mines, startI, 0, 6, 6, 0, path, "");

        System.out.println("Maximum gold and Path: ");
        System.out.println(maxGold);
        System.out.println(path);
    }

    public static int maxGold(int[][] mines, int startI, int startJ, int rows, int cols, int total, StringBuilder path, String totalPath) {
        if (startI > rows - 1 || startI < 0)
            return -1;
        if (startJ == cols - 1) {
            System.out.println(total+mines[startI][startJ]);
            System.out.println(totalPath);
            return mines[startI][startJ];
        }
        else {
            StringBuilder subPath1 = new StringBuilder("->");
            StringBuilder subPath2 = new StringBuilder("\\");
            StringBuilder subPath3 = new StringBuilder("/");
            int subMax1 = maxGold(mines, startI, startJ + 1, rows, cols, total + mines[startI][startJ], subPath1, totalPath + subPath1);
            int subMax2 = -1;
            if (startI < rows - 1) {
                subMax2 = maxGold(mines, startI + 1, startJ + 1, rows, cols, total + mines[startI][startJ], subPath2, totalPath + subPath2);
            }
            int subMax3 = -1;
            if (startI > 0) {
                subMax3 = maxGold(mines, startI - 1, startJ + 1, rows, cols, total + mines[startI][startJ], subPath3, totalPath + subPath3);
            }
            if (subMax1 > subMax2) {
                if (subMax1 > subMax3) {
                    path.append(subPath1);
                    return subMax1 + mines[startI][startJ];
                }
                else
                {
                    path.append(subPath3);
                    return subMax3 + mines[startI][startJ];
                }
            }
            else {
                if (subMax2 > subMax3) {
                    path.append(subPath2);
                    return subMax2 + mines[startI][startJ];
                }
                else
                {
                    path.append(subPath3);
                    return subMax3 + mines[startI][startJ];
                }
            }
        }
    }
}
