package com.company.Easy;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * I - 1
 * V - 5
 * X - 10
 * L - 50
 * C - 100
 * D - 500
 * M - 1000
 * <p>
 * If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
 * If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
 * If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900
 */
public class Easy_4_RomanToInteger {

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int romanNum = 0;
        int i = 0;
        while (i < chars.length) {
            switch (chars[i]) {
                case 'I':
                    if (i + 1 < chars.length && chars[i + 1] == 'V') {
                        romanNum += 4;
                        i++;
                    } else if (i + 1 < chars.length && chars[i + 1] == 'X') {
                        romanNum += 9;
                        i++;
                    } else {
                        romanNum += 1;
                    }
                    break;
                case 'V':
                    romanNum += 5;
                    break;
                case 'X':
                    if (i + 1 < chars.length && chars[i + 1] == 'L') {
                        romanNum += 40;
                        i++;
                    } else if (i + 1 < chars.length && chars[i + 1] == 'C') {
                        romanNum += 90;
                        i++;
                    } else {
                        romanNum += 10;
                    }

                    break;
                case 'L':
                    romanNum += 50;
                    break;
                case 'C':
                    if (i + 1 < chars.length && chars[i + 1] == 'D') {
                        romanNum += 400;
                        i++;
                    } else if (i + 1 < chars.length && chars[i + 1] == 'M') {
                        romanNum += 900;
                        i++;
                    } else {
                        romanNum += 100;
                    }
                    break;
                case 'D':
                    romanNum += 500;
                    break;
                case 'M':
                    romanNum += 1000;
                    break;
            }
            i++;
        }

        return romanNum;
    }

    public static int romanToInt_1(String s) {
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
            if(c[count]=='M') sum+=1000;
            if(c[count]=='D') sum+=500;
            if(c[count]=='C') sum+=100;
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;

        }
        return sum;
    }


}
