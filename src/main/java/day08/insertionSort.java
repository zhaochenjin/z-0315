package day08;
// 插入排序
import java.util.Arrays;

class InsertionSort {
    /*    public static void main(String[] args) {
            int[] ints = new int[10];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = (int) (Math.random() * 100);
            }
            System.out.println(Arrays.toString(ints));
    */
    public static void InsertSort(int[] arr)
    {
        int i, j;
        //   int n = arr.Length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < arr.length; i++) {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
            System.out.println(arr[i]);
        }}}