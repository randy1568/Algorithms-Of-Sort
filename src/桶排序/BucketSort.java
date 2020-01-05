package 桶排序;

import java.util.*;

/**
 * 非比较实现的稳定的排序，时间复杂度为O(N)
 */
public class BucketSort {

    public static void bucketSort(double[] nums){

        double max = nums[0];
        double min = nums[0];
        List<LinkedList<Double>> bucket = new ArrayList<>(nums.length);
        for (double temp:nums){
            if(temp > max){
                max = temp;
            }
            if(temp < min){
                min = temp;
            }
            bucket.add(new LinkedList<Double>());
        }

        double gap = max - min;
        for (double temp:nums){
            int location = (int) ((temp-min)*(nums.length-1)/gap);
            bucket.get(location).add(temp);
        }
        int k = 0;
        for (LinkedList<Double> temp:bucket){
            Collections.sort(temp);
            for (Double temp2:temp){
                nums[k++] = temp2;
            }
        }
    }

    public static void main(String[] args) {
        double[] nums = new double[]{4.5,0.84,3.25,2.18,0.5};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
