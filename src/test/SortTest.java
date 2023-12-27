package test;

import java.util.Arrays;

public class SortTest {
    public static void test() {
        /// 冒泡排序 时间复杂度为 O(n2) ,空间复杂度为 O(1)
        /// 插入排序 时间复杂度为 O(n2) ,空间复杂度为 O(1)
        /// 插入排序优于冒泡排序，因为冒泡排序的数据移动1次需要进行3次数据付值，而插入排序的数据移动1次只需要1次付值
        bubbleSort();
        insetionSort();
    }

    public static void bubbleSort() {
        int[] array = { 6, 4, 3, 5, 6, 7, 2, 1 };

        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false)
                break;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void insetionSort() {
        int[] array = { 6, 4, 3, 5, 6, 7, 2, 1 };

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }

        System.out.println(Arrays.toString(array));
    }
}
