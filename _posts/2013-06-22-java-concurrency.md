---
layout: post
title: Java进阶—并发程序设计
tags: concurrency java
categories: java
---
###Java内存的可见性
参考：[JVM并发机制探讨—内存模型、内存可见性和指令重排序](http://my.oschina.net/chihz/blog/58035)  
[同步和Java内存模型(三)可见性](http://ifeve.com/syn-jmm-visibility/)  


####关键字
1. volatile  
参考：[Java theory and practice: Managing volatility](http://www.ibm.com/developerworks/java/library/j-jtp06197/index.html)  
--_**volatile**关键字能确保变量在线程中的操作不会被**重排序**而是按照代码中规定的顺序进行访问_  
--_**volatile**关键字可以保证变量的**内存可见性**，即变量的改变对所有的线程都是立即可见的_  
2. synchronized

###Java中的进程与线程
参考: [Java 中的进程与线程](http://www.ibm.com/developerworks/cn/java/j-lo-processthread/index.html)  
1. 进程
在JDK中与进程直接关联的类是Java.lang.Process，它是一个抽象类，ProcessImpl是JDK提供的一个实现该抽象类的类，如果用户创建一个进程，那么肯定会伴随着一个新的ProcessImpl实例。Java.lang.Runtime.exec方法和Java.lang.ProcessBuilder.start方法都可以创建一个本地的进程，然后返回代表这个进程的 Java.lang.Process引用。JDK的ProcessImpl实现，引用了native的create，close，waitfor，destory和exitValue方法，native方法是依赖于操作系统平台的本地方法，它的实现是用C/C++等底层语言实现的。针对Windows系统而言，JVM中对应native的create方法实际上是调用了操作系统的CreatePipe和CreateProcess方法来创建一个进程，同时在JVM中保存了这个进程对应的句柄，然后返回给了ProcessImpl类，但是该类对返回句柄进行了隐藏。  
2. 线程
Java创建线程的方式有两种：继承Thread类，实现Runnable接口  
{% highlight java linenos %}
//继承Thread类
class MyThread extends Thread{
	public void run() {
		System.out.println("My thread is started.");
	}
}
//实现Runnable接口
class MyRunnable implements Runnable{
	public void run() {
	    System.out.println("My runnable is invoked.");
	}
}
{% endhighlight %}
对于以上两种方法创建线程时，调用的方式分别如下:  
{% highlight java linenos %}
//继承Thread类
MyThread myThread = new MyThread();
myThread.start();
//实现Runnable接口
Thread myThread = new Thread( new MyRunnable());
myThread.start();
{% endhighlight %}
以上两种方法，不管哪一种都必须实现一个run方法，该方法本质上是一个回调方法。有start方法创建的线程会调用run方法从而执行需要的代码。run方法并不是一个真正的线程函数，只是被线程函数调用的一个java方法而已，如果直接调用run方法，并不会创建一个新的线程。
