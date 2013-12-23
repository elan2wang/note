---
layout: post
title: Security of RESTful API
tags: REST API Security
categories: REST
---
###网络攻击
####1. Session Fixsation Attack[[wiki](http://en.wikipedia.org/wiki/Session_fixation)] 
Session fixation attack(会话固定攻击)是利用服务器的session不变机制，借他人之手获得认证和授权，然后冒充他人。如果应用程序在用户首次访问时为该用户建立一个匿名会话，并且在用户登录成功后，仍然使用该会话的SID(sessionId)，那么便存在安全漏洞。  
1. 攻击场景  
>step1: Mallory访问 http://unsafe/ 并获得了一个会话ID（SID），例如服务器返回的形式是：Set-Cookie: SID=0D6441FEA4496C2  
>step2: Mallory给Alice发了一个邮件：“我行推出了一项新服务，率先体验请点击：http://unsafe/?SID=0D6441FEA4496C2”
>step3: Alice点击并登录了  
>step4: 因为服务器的会话ID不改变，现在Mallory点击“http://unsafe/?SID=0D6441FEA4496C2”后，他就拥有了Alice的身份  
2. 防范措施  
最简单的防范措施是，在每次用户登录成功后，将旧的会话失效，为该用户创建一个新的会话。


####参考资料  
1. [关于Spring Security中无Session和无状态stateless](http://www.cnblogs.com/Mainz/p/3230077.html)
2. [Jetty源码学习11-Session](http://my.oschina.net/tryUcatchUfinallyU/blog/113350)
3. [RESTful Authentication](http://stackoverflow.com/questions/319530/restful-authentication)
4. [Principles for Standardized REST Authentication](http://broadcast.oreilly.com/2009/12/principles-for-standardized-rest-authentication.html)
5. [How to implement RESTful authentication](http://blog.synopse.info/post/2011/05/24/How-to-implement-RESTful-authentication)