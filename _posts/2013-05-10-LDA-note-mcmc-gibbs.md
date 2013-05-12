---
layout: post
title: LDA学习笔记(3)-MCMC和Gibbs采样
tags: LDA MCMC Gibbs
categories: 机器学习 文本分析
---
本文是[LDA学习笔记]({% post_url 2013-05-09-LDA-note %})系列文章之一，主要讲解Markov Chain Monte Carlo和Gibbs采样。在贝叶斯方法中，求解后验分布时需要对一个高维的函数进行积分，通常该积分的计算非常困难，因此产生了一些并非直接进行积分的方法，Markov Chain Monte Carlo就是其中之一。MCMC利用前一次的采样值来随机地产生下一次采样值，产生一个马尔科夫链。
###蒙特卡罗积分(MONTE CARLO INTEGRATION)
原始的蒙特卡罗方法是由物理学家发明的，它用于随机数生成来计算积分。假设我们需要计算一个复杂的积分：
$$
\int_a^b h\left(x\right) dx
$$
如果我们能将$h\left(x\right)$分解成函数$f\left(x\right)$和一个定义在区间$\left(a,b\right)$上的概率密度函数$p\left(x\right)$的乘积，那么我们可以将上面的式子写成
$$
\int_a^b h\left(x\right)dx = \int_a^b f\left(x\right) p\left(x\right) dx = E_{p\left(x\right)}\left\[ f\left(x\right) \right\]
$$
因此积分可以表示成函数$f\left(x\right)$在密度$p\left(x\right)$上的期望。如果我们从$p\left(x\right)$获得一大堆随机变量$x_1,...,x_n$，则
$$
\int_a^b h\left(x\right)dx = E_{p\left(x\right)}\left\[ f\left(x\right) \right\] = \frac{1}{n} \sum_{i=1}^n f\left(x\right)
$$
这个式子就被称为**蒙特卡罗积分**

<br>
<br>
**参考资料**  
[1. Markov Chain Monte Carlo and Gibbs Sampling](http://web.mit.edu/~wingated/www/introductions/mcmc-gibbs-intro.pdf)  
