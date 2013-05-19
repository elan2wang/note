---
layout: post
title: Lucene源码分析(1)—文本处理
tags: Lucene analysis
categories: Lucene
---
本文主要分析[Lucene](http://lucene.apache.org/)源码中关于文本处理的部分，该功能封装在[analysis](http://www.docjar.com/docs/api/org/apache/lucene/analysis/package-index.html)包中。本文并不涉及Lucene的使用方法介绍。
![lucene logo]({{ site.url }}/images/lucene_logo.png)
Lucene的文本处理包括：去除非字母字符、大写字母转换成小写、去除停用词、词形还原...等等，并且可以通过自定义扩展实现所需的处理。*Analyzer*抽象类是Lucene进行文本处理的重要类，所有继承*Analyzer*的子类都需要重写*tokenStream()*方法，该方法将文本信息转换成Token流并返回一个*TokenStream*对象，每一个Token除了包含文本单词以外，还包括一些重要的元数据，如：该单词的位置信息，偏移量等。*TokenStream*可以逐一枚举所有的Token并实现对Token的处理和转换。在Lucene中有两类重要的*TokenStream*，分别是*Tokenizer*和*TokenFilter*，下图描述了它们之间的类图关系：
![TokeStream Class Hierarchy]({{ site.url }}/images/tokenstream-class.png)
从上图中，可以看出*TokenFilter和TokenStream*之间有组合关系，也就是说，*TokenFilter*中可以再封装一个*TokenStream*对象(可以是*Tokenizer*也可以是*TokenFilter*)。*Tokenizer*从*java.io.Reader*读取字符并创建Token流，而*TokenFilter*读取Token流，并输出新的Token流（通过添加、删除Token，或者修改Token属性）。Lucene中文本处理链一般从一个*Tokenizer*开始，然后经过若干个*TokenFilter*，最后输出Token流，示意图如下：
![analyzer chain]({{ site.url }}/images/analyzer-chain.png)
