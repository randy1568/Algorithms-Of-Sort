package 归并排序;

import java.util.Arrays;

/**
 * 自上而下（递归实现）
 */
public class MergeSort {


    public static void main(String[] args) {
        int num[] = {1,1, 2, 4, 0, 8, 911, 200, -1, 0, -1,-200,-200,-1};
        SortedUpToDown(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    public static void SortedUpToDown(int[] nums, int left, int right) {

        if (nums == null || left >= right) {
            return ;
        }
        int middle =left+ (right - left) / 2;
        SortedUpToDown(nums, left, middle);
        SortedUpToDown(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }

    private static void merge(int[] nums, int left, int middle, int right) {

        int[] temp = new int[right-left+1];
        int i = left;
        int j = middle+1;
        int k =0;
        while (i <=middle && j<=right){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i<=middle){
            temp[k++] = nums[i++];
        }
        while (j<=right){
            temp[k++] = nums[j++];
        }
        for (int w=0;w<k;w++){
            nums[left+w] = temp[w];
        }
    }
}
