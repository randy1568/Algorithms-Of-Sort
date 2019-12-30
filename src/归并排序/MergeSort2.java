package 归并排序;

import java.util.Arrays;

/**
 * 自下而上
 */
public class MergeSort2 {


    public static void main(String[] args) {
        int num[] = {1,1, 2, 4, 0, 8, 911, 200, -1, 0, -1,-200,-200,-1};
        SortedDownToU(num);
        System.out.println(Arrays.toString(num));
    }

    public static void SortedDownToU(int[] nums) {

        if (nums == null) {
            return ;
        }
        for (int n = 1;n<nums.length;n=2*n){
            mergeGroups(nums,n);
        }
    }

    private static void mergeGroups(int[] nums, int n) {
        int groupGap = 2*n;
        int i = 0;
        for (;i+groupGap-1<nums.length;i+=groupGap){
            merge(nums,i,i+n-1,i+groupGap-1);
        }
        if(i+n-1<nums.length){
            merge(nums,i,i+n-1,nums.length-1);
        }
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
