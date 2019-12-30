package 堆排序;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int num[] = {1, 2, 4, 0};

        Sort(num);
        System.out.println(Arrays.toString(num));
    }
    public static void Sort(int[] nums) {

        for (int i = (nums.length) / 2 - 1; i >= 0; i--) {
            HeapAdjust(nums, i, nums.length);
        }
        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums,0,j);
            HeapAdjust(nums,0,j);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void HeapAdjust(int[] nums, int i, int arrayLength) {
        int temp = nums[i];

        while (i < arrayLength && ( 2 * i + 1)<arrayLength) {

            int k = 2 * i + 1;
            if (k + 1 < arrayLength && nums[k + 1] > nums[k]) {
                k++;
            }
            if (temp < nums[k]) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }
}
