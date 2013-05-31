---
layout: post
title: LDA学习笔记(5)-图像分类
tags: LDA Image-Classification
categories: 机器学习 图像处理
---
本文是[LDA学习笔记]({{ site.url }}{% post_url 2013-05-09-LDA-note %})系列文章的第5部分，主要介绍LDA在图像分类中的应用。  
图像处理问题的第一步是特征提取，本文介绍的特征提取算法是[SIFT(Scale-Invariant Feature Transform)](http://www.cs.ubc.ca/~lowe/keypoints/)，该算法最早于1999年由David G. Lowe提出，2004年他在论文["Distinctive image features from scale-invariant keypoints"](http://www.cs.ubc.ca/~lowe/papers/ijcv04.pdf)中对其加以发展和完善。通过SIFT算法可以将图像表示成一个特征的集合，然而这样的特征集合中的特征值都是不同的，为了能把图像表示成BOF(Bag of Feature)，我们可以通过聚类算法将相近的特征表示为同一个特征，常用的聚类算法如：[K-Means](http://en.wikipedia.org/wiki/K-means_clustering)。至此，我们就可以统计每幅图片中各个特征出现的频率，获得特征的频率数据后就可以训练获得LDA模型。

###参考资料
1. [Simultaneous Image Classification and Annotation](http://www.cs.princeton.edu/~blei/papers/WangBleiFeiFei2009.pdf)
2. [基于SIFT+Kmeans+LDA的图片分类器的实现](http://blog.csdn.net/zhuzhutingru1/article/details/8217099)
