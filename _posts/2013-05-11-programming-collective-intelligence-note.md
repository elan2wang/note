---
layout: post
title: 《集体智慧编程》读书笔记
tags: programming-collective-intelligence similarity-score
categories: 机器学习 文本分析
---

本文章是在阅读[《集体智慧编程》](http://book.douban.com/subject/3056375/)过程中记录的一些对我有用的信息。  
##1. 相似度计算方式
###1.1. Euclidean Distance Score
###1.2. Pearson Correlation Score
###1.3. Jaccard Coefficient Score
Jaccard Coefficient用于测量样本集之间的相似度，它定义为：集合交集与集合并集的比值，公式如下：
$$
J\left( A, B \right) = \frac{\left|A \bigcap B \right|}{\left| A \bigcup B \right|}
$$
Jaccard Distance用于测量样本集之间的非相似度，它定义为：1 - Jaccard Coefficient，公式如下:
$$
{J}_{\delta }\left( A, B \right) = 1-J\left( A, B \right) = \frac{\left|A \bigcup B \right| - \left|A \bigcap B \right|}{\left| A \bigcup B \right|}
$$
###1.4. Manhattan Distance Socre
**曼哈顿距离**又称为**出租车几何**或**方格线距离**，它定义为：欧几里得空间的固定直角坐标系上两点所形成的线段对轴产生的投影的距离总和。
![Manhattan_distance.png]({{ site.url }}/images/Manhattan_distance.png)
上图中，红、蓝、黄线表示的曼哈顿距离都相等（为12），绿线表示欧几里得距离($6 * \sqrt{2} \approx 8.48$)。
<br>
<br>
更多的相似度计算公式可以参见[Wikipedia](http://en.wikipedia.org/wiki/Metric_%28mathematics%29)