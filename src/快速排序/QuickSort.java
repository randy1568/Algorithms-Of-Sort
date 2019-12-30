package 快速排序;

import java.util.Arrays;

/**
 * 快速排序
 */

public class QuickSort {

    public static void main(String[] args) {
        int num[] = {1,1, 2, 4, 0, 8, 911, 200, -1, 0, -1,-200,-200,-1};
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    private static void quickSort(int[] num,int left, int right){

        if(left < right){
            int res = partition(num,left,right);
            quickSort(num,left,res-1);
            quickSort(num,res+1,right);
        }
    }

    private static int partition(int[] num,int left, int right){

        int temp = num[left];

        while (left < right){
            while (left <right && num[right] >= temp){
                right--;
            }

            num[left] = num[right];

            while (left < right && num[left] <= temp){
                left++;
            }
            num[right] = num[left];
        }
        num[left] = temp;

        return left;
    }
}
