package com.company.Easy;

/**
 * 问题描述
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output:  321
 * Example 2:
 * Input: -123
 * Output: -321
 * Example 3:
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit
 * signed integer range. For the purpose of this problem, assume that your function returns 0
 * when the reversed integer overflows.
 */
public class Easy_2_ReverseInteger {
    public static int reverse(int num) {
        int scale=0;
        if (num > 0) {
            scale=("" + num).length()-1;
        } else if (num < 0) {
            scale=("" + num).length()-2;
        } else if (num== 0) {
            return 0;
        }
        int reverseNum = 0;
        for (int i = scale; i >=0; i--) {
            double a = Double.parseDouble("10");
            double b = Double.parseDouble("" + i);
            double pow = Math.pow(a, b);
            int i2 =(int)pow;
            int i1=num / i2;
            double pow1 = Math.pow(a, Double.parseDouble("" + (scale - i)));
            reverseNum+=i1*(int)pow1;
            num-=i1 * i2;
            if (num==0)break;
        }
        return reverseNum;
        /*Input:
1534236469
Output:
1056389759*/
    }
}
