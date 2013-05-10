---
layout: post
title: LDA学习笔记(4)-扩展模型
tags: LDA Extend
categories: 
---
本文是[LDA学习笔记]({% post_url {{ 2013-05-09-LDA-note }} %})系列文章的第4部分，主要介绍一些比较常见的LDA的扩展模型  
##4. LDA扩展
###4.1. Author-Topic模型
阅读论文: [Michal Rosen-Zvi et al. "The Author-Topic Model for Authors and Documents" 2004](http://psiexp.ss.uci.edu/research/papers/uai04_v8.pdf)  
实验数据: [NIPS data set](http://www.cs.toronto.edu/~roweis/data.html)  

![grapic model of author-topic](/note/images/author-topic.png)  
从上图可以看出，Author-topic模型是LDA模型与Author模型的结合。LDA模型的文本生成过程中，是根据doc-topic的分布$\theta$来选择下一个词的主题;而在Author-Topic模型，是根据doc-topic的分布$\theta$以及Author的主题分布两个因素结合来确定下一个词的主题分布。  
###4.2. 动态主题模型
阅读论文: [David M. Blei et al. "Dynamic Topic Models" 2006](http://www.cs.princeton.edu/~blei/papers/BleiLafferty2006a.pdf)  
LDA模型假设文档的所包含的主题顺序是可交换的，但是实际上，文档的顺序会反映主题的演化过程，如：新闻文章、邮件等，因此本文提出了一种动态的主题模型。  
![Dynamic Topic Model](/note/images/dynamic-topic-model.png)  
在动态主题模型中，文档集被分割成$t$个时间切片，每个切片的文档都用包含$K$个主题的主题模型建模，并且，与切片$t$关联的topic-word分布$\beta_t$是由与$t-1$切片关联的topic-word分布$\beta_{t-1}$演化而来的，$\beta_{t,k}$表示时间$t$时主题$k$对应的topic-word分布向量。
