package day08;

import java.util.Arrays;

/*
*插入排序insertion sort
*选择排序selection sort
*冒泡排序
*快速排序Quicksort

希尔排序
堆排序
归并排序
基数排序
 */

public class BubbleSort {
// 冒泡排序
    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(ints));
        // sort
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j + 1] < ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(ints));
    }
}
