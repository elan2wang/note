---
layout: post
title: Order Book
tags: book
categories: Java ZeroGC
---
Order book is the most basic but also important part of electronic trading. Different parties (exchange match engine, broker order book, prop trading, market maker, etc.) could have their own consideration. This post mainly focus on the efficiency of order book construction. How to ensure constant time of:
* accepting new order
* updating price of an existing order
* updating quantity of an existing order
* cancelling an existing order
* retrieving best bid offer (BBO)


**Reference**
* [Order Book Data Structures](https://csce.ucmss.com/cr/books/2018/LFS/CSREA2018/FCS3665.pdf)
* [How to Build a Fast Limit Order Book](https://web.archive.org/web/20110219163448/http://howtohft.wordpress.com/2011/02/15/how-to-build-a-fast-limit-order-book/)
* [What is an efficient data structure to model order book](https://quant.stackexchange.com/questions/3783/what-is-an-efficient-data-structure-to-model-oer-book)
* [Quant Cup 1's winning order book implementation](https://gist.github.com/elan2wang/49e85e6d7e5a9b1d9ccf1c70a4425c58)
* [Limit Order Book Implementation for Low Latency Trading (in C++)](https://alexabosi.wordpress.com/2014/08/28/limit-order-book-implementation-for-low-latency-trading-in-c/)
* [Red Black Tree vs AVL Tree](https://www.geeksforgeeks.org/red-black-tree-vs-avl-tree/)
* [translation lookaside buffer (TLB)](https://en.wikipedia.org/wiki/Translation_lookaside_buffer)