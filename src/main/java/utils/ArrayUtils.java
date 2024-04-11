package utils;

public class ArrayUtils {
    public static void main(String[] args) {
        String str = "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]";


        int[][] array = stringTo2DArray(str);


        // 打印二维数组
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] stringTo2DArray(String input) {
        String[] rows = input.substring(2, input.length() - 2).split("\\],\\[");
        int[][] array = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].split(",");
            array[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                array[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return array;
    }

    public static int[] stringToArray(String str) {

        str = str.replace("[", "").replace("]", "");
        String[] strArr = str.split(",");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
       return  intArr;
    }
    public static void printArray(int[] arr){
        if (arr != null && arr.length > 0){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void print2DArray(int[][] arr){
        if (arr != null && arr.length > 0){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.printf("%4d", arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}
