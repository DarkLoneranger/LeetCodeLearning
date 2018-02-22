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
    public static boolean isPalindrome_1(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }

}
