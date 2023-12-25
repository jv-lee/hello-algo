package test;

import java.util.Arrays;

public class SortTest {
    public static void test() {
        bubbleSort();
    }

    public static void bubbleSort() {
        int[] array = { 6, 4, 3, 5, 6, 7, 2, 1 };

        for (int i =0;i<array.length;i++) {
            boolean flag = false;
            for (int j = 0;j<array.length - i - 1;j ++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (flag == false) break;
        }
        System.out.println(Arrays.toString(array));
    }
}
