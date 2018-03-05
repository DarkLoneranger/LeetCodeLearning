package com.company.Easy;

import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Easy_20_ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)  //添加长度检测，如果是单数证明一定存在没有配对的括号，直接返回false
            return false;
/*ArrayDeque
为双端队列，支持首部，尾部两端的操作，因此做双端操作可用于fifo
（First Input First Output的缩写，先入先出队列）等queue, 做单端操作可作为stack.

linkedList内部实现用node节点链接前后元素。模拟c/c++的链表（长处在于中间节点的增删操作为o(1)）。
vector方法加着synchronized修饰（同步 将带来性能的损耗）。Stack的实现又继承自vector，问题同上。
ArrayDeque 的底层实现为单纯的数组操作。所以单从性能上看。ArrayDeque在优于他们。
当然因为没有做同步处理，所以存在并发问题。须要调用方自己保障。*/
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)//还没循环结束，栈 内就已经空了，证明该后括号没有对应前括号
                //peek 与 pop 的区别
                //相同点：大家都返回栈顶的值。
                //不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
                return false;
        }
        return stack.isEmpty();
    }
}
