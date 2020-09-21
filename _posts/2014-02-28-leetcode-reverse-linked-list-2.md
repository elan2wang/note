---
layout: post
title: LeetCode Reverse Linked List II
tags: leetcode
categories: leetcode
---
#### [题目描述]
<http://oj.leetcode.com/problems/reverse-linked-list-ii/>
>Reverse a linked list from position m to n. Do it in-place and in one-pass.

>For example:
>Given 1->2->3->4->5->NULL, m = 2 and n = 4,

>return 1->4->3->2->5->NULL.

>**Note:**

>Given m, n satisfy the following condition:

>1 ≤ m ≤ n ≤ length of list.

#### [问题分析]
1. 边界情况  
链表为空, {};  
链表只有一个元素, {1}; 
以上两种情况, reverse时无需任何操作，直接返回链表表头即可。
2. 特殊情况  
若m和n的值相等, {1,2,3,4}, m=2,n=2; 此情况reverse时也无需任何操作, 直接返回链表表头.  
若m等于1, {1,2,3,4}, m=1, n=2;  
若n等于链表的长度, {1,2,3,4}, m=2, n=4;  
若m等于1, 且n等于链表长度, {3,5}, m=1, n=2;  

#### [参考代码]
{% highlight java linenos %}
public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null || m == n) return head;
      
    ListNode cur = head;
    ListNode next = null;
    ListNode sub_head = null;
    ListNode sub_tail = null;
    ListNode pre_sub = new ListNode(0);
        
    int node_i = 1;
    while (node_i < n) {
        next = cur.next;
        if (node_i < m) {
            pre_sub = cur;
        } else {
            if (node_i == m) {
                sub_tail = cur;
            }
            cur.next = sub_head;
            sub_head = cur;
        }
        cur = next;
        pre_sub.next = next;
        node_i++;
    }
    sub_tail.next = cur.next;
    cur.next = sub_head;
        
    return m == 1 ? cur : head;  
}
{% endhighlight %}