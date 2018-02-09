package com.company;


import com.company.Easy.Easy_1_twoSum;

public class Main {


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] outNums = Easy_1_twoSum.twoSum_2(nums, target);
        System.out.println("["+outNums[0]+","+outNums[1]+"]");
    }



}
