package com.company.Easy;

import java.util.ArrayList;

/**问题描述
 *Determine whether an integer is a palindrome. Do this without extra space.
 Could negative integers be palindromes? (ie, -1)
 If you are thinking of converting the integer to string, note the restriction of using extra space.
 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 you know that the reversed integer might overflow. How would you handle such case?
 There is a more generic way of solving this problem.
 */
public class Easy_3_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;  //所有的负数都不能归为回文数字
        ArrayList<Integer> integers = new ArrayList<>();
        while (x!=0){
            integers.add(x%10);
            x=x/10;
        }
       //2147483647
       //-2147447412

        for (int i = 0; i < integers.size() / 2; i++) {
            if (integers.get(i)!=integers.get(integers.size() -1-i))
                return false;
        }

        return true;

    }

}
