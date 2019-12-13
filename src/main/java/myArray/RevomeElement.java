package myArray;

/**
 * 给出一个数组 和一个元素
 * 如果数组中存在这个元素，移除它
 */
public class RevomeElement {

    public static int removeElement(int[] arr,int value)
    {
        int tail = 0;
        for (int i = 0;i < arr.length;i++)
        {
            if (value != arr[i])
            {
                arr[tail++] = arr[i];
            }
        }

        return tail;

    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 3, 1, 1, 2, 3, 3, 3};
        int len = removeElement(data, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }
    }

}
