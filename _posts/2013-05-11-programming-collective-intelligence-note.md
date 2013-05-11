---
layout: post
title: 《集体智慧编程》读书笔记
tags: programming-collective-intelligence similarity-score
categories: 机器学习 文本分析
---

本文章是在阅读[《集体智慧编程》](http://book.douban.com/subject/3056375/)过程中记录的一些对我有用的信息。  
##1. 相似度计算方式
###Euclidean Distance Score
###Pearson Correlation Score
###Jaccard Coefficient Score
Jaccard Coefficient用于测量样本集之间的相似度，它定义为：集合交集与集合并集的比值，公式如下：
$$
J\left( A, B \right) = \frac{\left|A \bigcap B \right|}{\left| A \bigcup B \right|}
$$
Jaccard distance用于测量样本集之间的非相似度，它定义为：1 - Jaccard Coefficient，公式如下:
$$
{J}_{\delta }\left( A, B \right) = 1-J\left( A, B \right) = \frac{\left|A \bigcup B \right| - \left|A \bigcap B \right|}{\left| A \bigcup B \right|}
$$
###Manhattan Distance Socre
更多的相似度计算公式可以参见[Wikipedia](http://en.wikipedia.org/wiki/Metric_%28mathematics%29)