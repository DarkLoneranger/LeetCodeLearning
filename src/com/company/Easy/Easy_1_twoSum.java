package com.company.Easy;

import java.util.HashMap;
import java.util.Map;

/**问题描述
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
public class Easy_1_twoSum {

    /*main方法中测试代码
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] outNums = Easy_1_twoSum.twoSum(nums, target);
        System.out.println("["+outNums[0]+","+outNums[1]+"]");*/
    public static int[] twoSum_1(int[] nums, int target) {
        int[] outNums=new int[2];
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    outNums[0]=i;
                    outNums[1]=j;
                    return outNums;
                }
            }
        }
        return null;
    }

    public static int[] twoSum_2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i ;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
