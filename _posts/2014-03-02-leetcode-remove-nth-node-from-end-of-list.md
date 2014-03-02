---
layout: post
title: LeetCode Remove Nth Node From End of List
tags: leetcode
categories: leetcode
---
####[题目描述]
<http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/>
>Given a linked list, remove the nth node from the end of list and return its head.

>For example,

>>   Given linked list: 1->2->3->4->5, and n = 2.

>>   After removing the second node from the end, the linked list becomes 1->2->3->5.

>**Note:**  
>Given n will always be valid.  
>Try to do this in one pass.

####[问题分析]
1. 边界情况  
链表为空, head==null, 直接返回head即可
2. 特殊情况
n=1, 即删除链表最后一个元素;  
n=length, 即删除链表第一个元素;  


题目只有时间上的要求O(n), 所以最先想到的应该是用一个数组记录所有的node, 遍历一遍后即可找到要删除的节点current_node(数组的第length-n+1个元素), 然后只需将(数组第length-n个元素)previous_node.next = current_node.next即可。  


显然以上方法需要消耗O(n)的空间，那么能否在O(1)空间内完成呢?  


1. 创建两个指针cur和cur2分别指向head;  
2. 单独移动cur至指向第n个node;
3. 然后同时移动cur和cur2, 直到cur指向最后一个node(cur.next==null)才停止, 此时cur2指向的即时倒数第n个node.
4. 为了移除cur2最终指向的倒数第n个node, 还需要一个指向cur2前一个node的指针prev_cur2.

####[参考代码]
{% highlight java linenos %}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        ListNode cur = head;
        ListNode cur2 = head;
        ListNode prev_cur2 = new ListNode(0);
        prev_cur2.next = cur2;
        
        int node_i = 1;
        while (node_i < n) {
            cur = cur.next;
            node_i++;
        }
        
        while (cur.next != null) {
            cur = cur.next;
            prev_cur2 = cur2;
            cur2 = cur2.next;
            node_i++;
        }
        
        prev_cur2.next = cur2.next;
        
        return (node_i == n) ? prev_cur2.next : head;
    }
}
{% endhighlight %}