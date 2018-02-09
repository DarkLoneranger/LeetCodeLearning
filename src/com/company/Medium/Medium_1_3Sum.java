package com.company.Medium;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题描述
 * given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 注：[-1,0,1]和[0,1,-1]算作一个
 */
public class Medium_1_3Sum {

    /*main方法中测试代码
     int[] nums = {-1, 0, 1, 2, -1, -4};
     System.out.println(Medium_1_3Sum.threeSum(nums).toString());
     */

    /*Time Limit Exceeded 太暴力了，时间复杂度过高*/
    public static List<List<Integer>> threeSum(int[] nums) {
        //先排序
    /*    for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }*/
        Arrays.sort(nums);  //快速排序
        List<List<Integer>> outNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> ints = new ArrayList<Integer>();
                        ints.add(nums[i]);
                        ints.add(nums[j]);
                        ints.add(nums[k]);
                        if (!outNums.contains(ints)) {
                            outNums.add(ints);
                        }
                    }
                }
            }
        }


        return outNums;
    }


    public static List<List<Integer>> threeSum_1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {  //为什么是2？因为是三个数的和
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {//说明大的值较大，需要左移，减小
                    k--;
                } else { //说明小的值较小，需要右移，增大
                    j++;
                }
            }
        }
        return res;
    }

        public static List<List<Integer>> threeSum_3(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length < 3) return result;
            Arrays.sort(nums);
            int i = 0;
            while(i < nums.length - 2) {
                if(nums[i] > 0) break;  //最小的数如果已经大于0就直接跳出循环
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                    if(sum >= 0) while(nums[k--] == nums[k] && j < k);
                }
                while(nums[i] == nums[++i] && i < nums.length - 2);
            }
            return result;
        }
}
