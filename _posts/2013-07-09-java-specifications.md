---
layout: post
titile: Java Specification
tags: java
categories: Java
---

1. ResourceBundle和Properties比较  
一般来说，ResourceBundle类通常是用于针对不同的语言来使用的属性文件。
而如果你的应用程序中的属性文件只是一些配置，并不是针对多国语言的目的，那么使用Properties类就可以了。
2. Java内存泄漏  
java内存的分配是由程序完成的，程序员通过关键字**new**为每个对象申请内存空间，所有的对象都在队（Heap）中分配空间。（临时变量在堆栈Stack中分配内存）。Java的垃圾回收机制GC负责内存的释放，为了能够正确释放对象，GC必须监控每个对象的运行状态，包括对象的申请，引用，被引用，赋值等。  
Java内存泄漏就是存在一些被分配的对象，这些对象有两个特点：首先，这些对象是可达的，即在有向图中存在通路（也就是存在该内存的引用）；其次，这些对象是无用的，即程序以后不会再使用这些对象。如果对象满足这两个条件，就可以判定为Java的内存泄漏。  
**与C++内存泄漏的区别**，C++内存泄漏范围更大。C++不存在GC，所以有些对象被分配了内存空间，然后却不可达，这些内存将永远无法回收。
3. ThreadLocal  
<http://blog.csdn.net/qjyong/article/details/2158097>  
<http://www.blogjava.net/jspark/archive/2011/11/02/61165.html>  
<http://lavasoft.blog.51cto.com/62575/51926/>  



