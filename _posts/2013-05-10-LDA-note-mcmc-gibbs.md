---
layout: post
title: LDA学习笔记(3)-MCMC和Gibbs采样
tags: LDA MCMC Gibbs
categories: 机器学习 文本分析
---
本文是[LDA学习笔记]({% post_url 2013-05-09-LDA-note %})系列文章之一，主要讲解Markov Chain Monte Carlo和Gibbs采样。在贝叶斯方法中，求解后验分布时需要对一个高维的函数进行积分，通常该积分的计算非常困难，因此产生了一些并非直接进行积分的方法，Markov Chain Monte Carlo就是其中之一。MCMC利用前一次的采样值来随机地产生下一次采样值，产生一个马尔科夫链。
###蒙特卡罗积分
原始的蒙特卡罗方法是由物理学家发明的，它利用生成随机数来计算积分。假设我们需要计算一个复杂的积分：
$$
\int_a^b h\left(x\right) dx
$$
如果我们能将$h\left(x\right)$分解成函数$f\left(x\right)$和一个定义在区间$\left(a,b\right)$上的概率密度函数$p\left(x\right)$的乘积，那么我们可以将上面的式子写成
$$
\int_a^b h\left(x\right)dx = \int_a^b f\left(x\right) p\left(x\right) dx = E_{p\left(x\right)}\left\[ f\left(x\right) \right\]
$$
因此积分可以表示成函数$f\left(x\right)$在概率密度$p\left(x\right)$上的期望。如果我们从$p\left(x\right)$获得一系列随机变量$x_1,...,x_n$，则
$$
\int_a^b h\left(x\right)dx = E_{p\left(x\right)}\left\[ f\left(x\right) \right\] = c \sum_{i=1}^n f\left(x_i \right)
$$
这个式子就被称为**蒙特卡罗积分**。蒙特卡罗积分可以用于近似贝叶斯分析中的后验分布(或边缘分布)，对于积分$I\left(y \right) = \int f\left(y \mid x \right) p\left(x\right) dx$，它可以近似于
$$
\hat{I} \left(y \right) = \frac{1}{n} \sum_{i=1}^n f\left(y \mid x_i\right)
$$
其中$x_i$是通过概率密度$p\left(x\right)$生成的随机变量。**蒙特卡罗标准误差**可以用以下公式估计
$$
SE^2\left\[\hat{I} \left(y \right) \right\] = \frac{1}{n} \left(\frac{1}{n-1} \sum_{i=1}^n \left(f\left(y \mid x_i\right) - \hat{I} \left(y \right) \right) \right)
$$
###重要性采样
在利用蒙特卡罗方法求复杂积分时，我们需要根据概率密度$p\left(x\right)$获取一系列的随机变量，但是计算机只能获得均匀分布的随机数。假设我们需要按照正态分布$N\left(0,1\right)$获得10个随机数，蒙特卡罗法是这样做的：  
>首先，在[0,1]区间上按均匀分布选取10个随机数，例如：  
>0.4505, 0.0838, 0.2290, 0.9133, 0.1524, 0.8258, 0.5383, 0.9961, 0.0782, 0.4427  
>接着，计算该正态分布的[累积概率分布函数](http://en.wikipedia.org/wiki/Cumulative_distribution_function)分别取上述值时对应的自变量值$x_i$，这样获得的$x_1,...,x_{10}$值：  
>-0.1243, -1.3798, -0.7422, 1.3616, -1.0263, 0.9378, 0.0963, 2.6636, -1.4175, -0.1442  
>就是服从正态分布的10个随机数。

<br>
<br>
**参考资料**  
[1. Markov Chain Monte Carlo and Gibbs Sampling](http://web.mit.edu/~wingated/www/introductions/mcmc-gibbs-intro.pdf)  
[2. 如何理解重要性采样](http://wbxin2007.blog.163.com/blog/static/1643141252011229729234/?COLLCC=1808049947&)
