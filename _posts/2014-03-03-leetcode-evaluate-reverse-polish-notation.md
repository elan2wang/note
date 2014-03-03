---
layout: post
title: LeetCode Evaluate Reverse Polish Notation
tags: leetcode
categories: leetcode
---
####[题目描述]
<http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/>
>Evaluate the value of an arithmetic expression in Reverse Polish Notation.

>Valid operators are **+, -, *, /**. Each operand may be an integer or another expression.

>Some examples:
>>  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9  
>>  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

####[问题分析]
使用堆栈, 每次遇到数字则将数字进栈, 遇到操作符则取出栈顶的两个操作数, 进行相应的计算后, 将计算结果入栈. 可以用数组模拟堆栈.

时间和空间复杂度均为O(N).
####[参考代码]
{% highlight java linenos %}
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        
        int[] operands = new int[tokens.length];
        int len = 0;
        
        for (int i=0; i<tokens.length; i++) {
            if (!isOperator(tokens[i])) {
                operands[len++] = Integer.valueOf(tokens[i]);
            } else {
                int left = operands[len-2];
                int right = operands[len-1];
                switch(tokens[i].charAt(0)){
                    case '+':
                        operands[len-2] = left + right;
                        break;
                    case '-':
                        operands[len-2] = left - right;
                        break;
                    case '*':
                        operands[len-2] = left * right;
                        break;
                    case '/':
                        operands[len-2] = left / right;
                        break;
                }
                len--;
            }
        }
        
        return operands[0];
    }
	
	private boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || 
		    s.equals("*") || s.equals("/")) return true;
		else return false;
    }
}
{% endhighlight %}