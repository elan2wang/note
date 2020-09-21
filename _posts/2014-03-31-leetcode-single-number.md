---
layout: post
title: LeetCode single number
tags: leetcode
categories: leetcode
---
#### [题目描述]
<url>  
>description

#### [问题分析]  

[Java位运算](http://shitouer.cn/2013/04/java-bit-operation-tutorial/)
>~ 按位非(NOT),   逐位取反  
>& 按位与(AND),   全部为1为1, 有0为0  
>| 按位或(OR),    全部为0为0, 有1为1  
>^ 按位异或(XOR), 相同为0, 相异为1  

int和long类型最高位为符号位，正数为0，负数为1.正数的反码和补码与原码相同，负数的反码为原码逐位取反，反码加1得到补码，负数是用补码参与运算，得到的也是补码，需要将结果转换为原码。  
>int i=-1  
>原码：1000 0000 0000 0000 0000 0000 0000 0001  
>反码：0111 1111 1111 1111 1111 1111 1111 1110  
>补码：0111 1111 1111 1111 1111 1111 1111 1111  


#### [参考代码]
{% highlight java linenos %}

{% endhighlight %}
