package myArray;

public class SearchMatrix {

    public static void main(String[] args) {

    }

    public boolean searchMatrix1(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {


        return false;
    }


}
