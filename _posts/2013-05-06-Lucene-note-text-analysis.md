---
layout: post
title: Lucene源码分析(1)—文本处理
tags: Lucene analysis
categories: Lucene
---
本文主要分析[Lucene](http://lucene.apache.org/)源码中关于文本处理的部分，该功能封装在[analysis](http://www.docjar.com/docs/api/org/apache/lucene/analysis/package-index.html)包中。本文并不涉及Lucene的使用方法介绍。
![lucene logo]({{ site.url }}/images/lucene_logo.png)
Lucene的文本处理包括：将文本转化成单词流、将大写字符表示成小写、去除停用词、词形还原...等等。*Analyzer*抽象类是Lucene进行文本处理的重要类，所有继承*Analyzer*的子类都需要重写*tokenStream()*方法，该方法将文本信息转换成Token流并返回一个*TokenStream*对象，每一个Token除了包含文本单词以外，还包括一些重要的元数据，如：该单词的位置信息，偏移量等。*TokenStream*可以逐一枚举所有的Token并实现对Token的处理和转换。在Lucene中有两类重要的*TokenStream*，分别是*Tokenizer*和*TokenFilter*，下图描述了它们之间的类图关系
![TokeStream Class Hierarchy]({{ site.url }}/images/tokenstream-class.png)
