---
layout: post
title: LeetCode median of two sorted arrays
tags: leetcode
categories: leetcode
---
#### [题目描述]
<http://oj.leetcode.com/problems/median-of-two-sorted-arrays>  
>There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

#### [问题分析]
这个问题可以泛化为去第k个元素。  
**方案一**  
利用merge sort排序算法中的合并操作，将两个数组合并，从合并好的数组中取出下标为k-1的元素就是我们需要的答案。此方案，合并是需要O(n)的时间复杂度，n为两个数组的总长度。  

**方案二**  
因为我们只需要取第k的元素，所以并不需要对整个数组排序。使用两个指针pa和pb分别指向A和B的第一个元素，使用merge sort的合并原理，如果数组A的元素小，那么pa++，同时m++；如果数组B的元素小，那么pb++，同时m++。当m等于k的时候，就找到了第k大的元素。此方案的时间复杂度为O(k)，如果k接近n，那么时间复杂度为O(n)。  

**方案三**  
<http://www.geeksforgeeks.org/median-of-two-sorted-arrays>  
利用二分的思想，


#### [参考代码]
{% highlight java linenos %}

{% endhighlight %}