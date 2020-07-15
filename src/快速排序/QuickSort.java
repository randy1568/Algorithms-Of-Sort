package 快速排序;

import java.util.Arrays;

/**
 * 快速排序
 */

public class QuickSort {

    public static void main(String[] args) {
        int num[] = {1, 1, 2, 4, 0, 8, 911, 200, -1, 0, -1, -200, -200, -1};
        quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    private static void quickSort(int[] num, int left, int right) {

        if (left < right) {
            int res = partition2(num, left, right);
            quickSort(num, left, res - 1);
            quickSort(num, res + 1, right);
        }
    }

    private static int partition(int[] num, int left, int right) {

        int temp = num[left];

        while (left < right) {
            while (left < right && num[right] >= temp) {
                right--;
            }

            num[left] = num[right];

            while (left < right && num[left] <= temp) {
                left++;
            }
            num[right] = num[left];
        }
        num[left] = temp;

        return left;
    }

    private static int partition2(int[] num, int left, int right) {

        //这里设置最右边的元素作为比较的主元素
        int temp = num[right];
        //此处的p代表比主元素小的所有数里边，在数组中位置最靠右的位置
        int p = left - 1;
        for (int i = left; i < right; i++) {
            if (num[i] <= temp) {
                p++;
                swap(num,i,p);
            }
        }
        swap(num,p+1,right);
        return p+1;
    }

    private static void swap(int[] num, int i, int p) {
        int temp = num[i];
        num[i] = num[p];
        num[p] = temp;
    }
}
