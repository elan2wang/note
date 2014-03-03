---
layout: post
title: LeetCode merge sorted lists
tags: leetcode
categories: leetcode
---
####[题目描述]
<http://oj.leetcode.com/problems/merge-two-sorted-lists/>  
>Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

####[问题分析]
利用归并排序中merge方法的思想; 时间复杂度为O(n), n表示两个lists的总长度; 若使用新的list来保存合并后的元素, 则需要O(n)的空间消耗; 另外也可以用其中一个lsit来存储元素, 此时不需要而外的空间。

####[参考代码]  
以下代码的空间消耗为O(1)  
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        ListNode head = null;
        ListNode cur = null, tmp = null;
        
        if (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                tmp = cur1;
                cur1 = cur1.next;
            } else {
                tmp = cur2;
                cur2 = cur2.next;
            }
            tmp.next = null;
        } else if (cur1 != null) {
            tmp = cur1;
            cur1 = cur1.next;
            tmp.next = null;
        } else if (cur2 != null) {
            tmp = cur2;
            cur2 = cur2.next;
            tmp.next = null;
        }
        head = tmp;
        cur = tmp;
        
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                tmp = cur1;
                cur1 = cur1.next;
            } else {
                tmp = cur2;
                cur2 = cur2.next;
            }
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        
        while (cur1 != null) {
            tmp = cur1;
            cur1 = cur1.next;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        
        while (cur2 != null) {
            tmp = cur2;
            cur2 = cur2.next;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        
        return head;
    }
}
{% endhighlight %}

==========================================================================
####[题目描述]
<http://oj.leetcode.com/problems/merge-k-sorted-lists/>  
>Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

####[问题分析]
利用merge two sorted lists的思想, 将相邻lists两两合并, 递归实现。

####[参考代码]  
{% highlight java linenos %}
public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0) return null;
    if (lists.size() == 1) return lists.get(0);
        
    ArrayList newList = new ArrayList<ListNode>();
    int i=0;
    for (; i+1 < lists.size(); i+=2) {
        newList.add(mergeTwoLists(lists.get(i), lists.get(i+1)));
    }
    if (i == lists.size()-1) newList.add(lists.get(i));
        
    return mergeKLists(newList);
}
{% endhighlight %}
