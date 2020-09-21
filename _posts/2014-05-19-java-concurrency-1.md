---
layout: post
title: Java Concurrent Programming[1] - Theory
tags: concurrency java
categories: Java
---
## 1. 锁
Java语言中锁分为**对象锁**和**类锁**。**同步锁**属于**对象锁**，每个对象被成功创建都会拥有一个且只拥有一个同步锁。对象的同步锁是**可重入锁(ReentrantLock)**，同一个线程获取该对象的同步锁后，还能再次获得。  
### 1.1. synchronized
**synchronized**用于获得对象的同步锁。
#### 1.1.1. 修饰非静态方法
#### 1.1.2. 修饰静态成员变量  
#### 1.1.3. synchronized(this)
#### 1.1.4. synchronized(object)

- 参考资料  
<http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html>

## 2. Java锁的内存模型
### 2.1. 内存模型
### 2.2. 内存可见性
### 2.3. 指令重排序
### 2.4. volatile

- 参考资料  
<http://my.oschina.net/chihz/blog/58035>  
<http://ifeve.com/syn-jmm-visibility/>  
<http://www.infoq.com/cn/articles/java-memory-model-5>  
<http://www.ibm.com/developerworks/java/library/j-jtp06197/index.html>  

## 3. Object监视方法
### 3.1. wait, notify, notifyAll方法介绍
- 参考资料  
<http://www.cnblogs.com/skywang12345/p/3479224.html#p5>

### 3.2. 实现原理

## 4. Condition
