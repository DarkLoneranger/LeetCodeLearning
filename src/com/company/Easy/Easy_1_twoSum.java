package com.company.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * https://leetcode.com/problems/two-sum/solution/
 */
public class Easy_1_twoSum {

        /*main方法中测试代码
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] outNums = Easy_1_twoSum.twoSum(nums, target);
        System.out.println("["+outNums[0]+","+outNums[1]+"]");*/

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSum_1(int[] nums, int target) {
        int[] outNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    outNums[0] = i;
                    outNums[1] = j;
                    return outNums;
                }
            }
        }
        return outNums;
    }
/*what if the array contains duplicate integers, so that map.put() method could be wrong in this case.

In C++, the running time of map’s get is O(logn), not O(1). In Java, we have O(1) get, so it’s O(n).时间复杂度
 There are at least two different implements of Map in C++. One is based on rb-tree and costs O(log n). Another one, named unorderd_map, is based on hash and costs O(1). You may need to check this.
Further more, an algorithm with better time complexity doesn’t mean a better actual run time in all case.

HashMap vs TreeMap.*/

    public static int[] twoSum_2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
