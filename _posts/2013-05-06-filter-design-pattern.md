---
layout: post
title: 过滤器设计
tags: Lucene Filter
categories: 设计模式
---
本文是在研读[Lucene](http://lucene.apache.org/)源码[analysis](http://www.docjar.com/docs/api/org/apache/lucene/analysis/package-index.html)包后，对过滤器TokenFilter的理解和分析，并将该设计与JDK中输入输出流设计，以及Java Web中过滤器设计进行简单比较。  
Lucene的TokenFilter设计中，数据流经过多个Filter时，只需要遍历一遍数据流，和Java API中的字符串过滤器原理相似。特点是，所有的Filter都以word为基本单位进行处理。

Servlet的Filter设计中，数据流每经过一个Filter，都会被遍历一遍。特点是，不同过滤器对数据流的处理方式都不尽相同。