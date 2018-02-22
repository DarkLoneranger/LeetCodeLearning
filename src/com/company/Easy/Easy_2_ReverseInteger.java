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
        int scale = 0;
        if (num > 0) {
            scale = ("" + num).length() - 1;
        } else if (num < 0) {
            scale = ("" + num).length() - 2;
        } else if (num == 0) {
            return 0;
        }
        long reverseNum = 0;
        for (int i = scale; i >= 0; i--) {
            double a = Double.parseDouble("10");
            double b = Double.parseDouble("" + i);
            double pow = Math.pow(a, b);
            long i2 = (int) pow;
            long i1 = num / i2;
            double pow1 = Math.pow(a, Double.parseDouble("" + (scale - i)));
            reverseNum += i1 * (int) pow1;
            if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) return 0; //判断是否溢出
            num -= i1 * i2;
            if (num == 0) break;
        }
        return (int) reverseNum;
        /*Input:
1534236469
Output:
1056389759

int占32位的时候，最大可以赋值为：2147483647。也就是0x7fffffff。
注意：7的二进制形式最高位为0，如果你对2147483647+1.输出的就是-2147483648。
这个数是负数中最大的数，也就是int型可以表示的最小的负数。
它的十六进制表示为：0x8fffffff，8的二进制形式最高位是符号位，是1，为负。
9646324351*/
    }

    public static int reverse_1(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev != 0 && Integer.MAX_VALUE / rev < 10
                    && Integer.MAX_VALUE / rev > -10)
                return 0;
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev;
    }

    /*1、知识理解

在计算机内，定点数有3种表示法：原码、反码和补码

[原码]二进制定点表示法，即最高位为符号位，“0”表示正，“1”表示负，其余位表示数值的大小。

[反码]表示法规定：正数的反码与其原码相同；负数的反码是对其原码逐位取反，但符号位除外。

[补码]表示法规定：正数的补码与其原码相同；负数的补码是在其反码的末位加1。

计算机数据是用补码表示的，正数的补码就是它的原码，而负数的补码是将其原码（取绝对值后的原码）取反加1得到的。

2、理解方式1
1.确定byte是1个字节，也就是8位

2.最大的应该是0111 1111，因为第一位是符号位，0表示正数

3.最小的应该是1000 0000（1111 1111是是负数-1的补码）

4.0111 1111即127

5.1000 0000按照上面的解释为先减一，得到0111 1111，然后按位取反得到1000 0000，该结果为欲求负数的绝对值，所以结果是-128（和概念反着来求出该负数）

3、理解方式2

0 00000000

1 00000001
…….
127 01111111
----------------
正数（包括0）共 128 个



-1 11111111
-2 11111110
……
-128 10000000
----------------
负数共 128 个
我们都知道byte占8位。而2的8次方等于256，也就是byte最多可以表示256个不同的数，
0~127：128个
-0~127：128个
但是这里0与-0表示一样的数了，所以就用-0的二进制补码表示到-128里面去了（这里是关键，也就是说-0的补码用来表示-128了，根据理解方式1中
的第五步，-0的补码"10000000"通过逆向计算刚好得到-128这个值）*/
}
