---
layout: post
title: LDA学习笔记(5)-图像分类
tags: LDA Image-Classification
categories: 机器学习 图像处理
---
本文是[LDA学习笔记]({{ site.url }}{% post_url 2013-05-09-LDA-note %})系列文章的第5部分，主要介绍LDA在图像分类中的应用。  
图像处理问题的第一步是特征提取，本文介绍的特征提取算法是[SIFT(Scale-Invariant Feature Transform)](http://www.cs.ubc.ca/~lowe/keypoints/)，该算法最早于1999年由David G. Lowe提出，2004年他在论文["Distinctive image features from scale-invariant keypoints"](http://www.cs.ubc.ca/~lowe/papers/ijcv04.pdf)中对其加以发展和完善。通过SIFT算法可以将图像表示成一个特征的集合，然而这样的特征集合中的特征值都是不同的，为了能把图像表示成BOF(Bag of Feature)，我们可以通过聚类算法将相近的特征表示为同一个特征，常用的聚类算法如：[K-Means](http://en.wikipedia.org/wiki/K-means_clustering)。至此，我们就可以统计每幅图片中各个特征出现的频率，获得特征的频率数据后就可以训练获得LDA模型。
###SIFT算法分析
####相关概念
- *关键点* 就是在不同尺度空间的图像下检测出的具有方向信息的局部极值点。
- *尺度空间* 通过对原始图像进行尺度变换，获得图像在多尺度下的尺度空间表示序列，对这些序列进行尺度空间主轮廓提取，并以该主轮廓为一种特征向量，实现边缘、角点检测和不同分辨率上的特征提取。尺度越大图像越模糊。实际上，在尺度空间理论中，是通过对图像进行模糊来模拟多尺度下的图像。直观上，图像的模糊程度逐渐增大，模拟了人在距离目标由近到远时目标在视网膜上的成像过程。
- *高斯卷积* 图像的尺寸是自然存在的，而不是人为创造的。高斯核是唯一可以产生多尺度空间的线性核，一个图像的尺度空间L(x, y,σ) 定义为原始图像I(x, y)与一个可变尺度的2维高斯函数G(x, y,σ)的卷积运算。σ表示尺度。

###K-Means聚类

###参考资料
1. [Simultaneous Image Classification and Annotation](http://www.cs.princeton.edu/~blei/papers/WangBleiFeiFei2009.pdf)
2. [基于SIFT+Kmeans+LDA的图片分类器的实现](http://blog.csdn.net/zhuzhutingru1/article/details/8217099)
3. [SIFT原理与源码分析(OpenCV):DoG尺度空间构造](http://blog.csdn.net/xiaowei_cqu/article/details/8067881)
4. [SIFT特征提取分析](http://blog.csdn.net/abcjennifer/article/details/7639681)
