---
layout: post
title: Security of RESTful API
tags: REST API Security
categories: REST
---
###AWS S3机制
####1. S3 Basics
S3处理的对象包括_objects_和_buckets_。object对象对应存储的文件，object包含identifier, owner, permissions。objects被存储在bucket中，每个bucket拥有唯一的名字，并且该名字必须满足域名的命名规则。object通过URL进行编址，如：_http://s3.amazonaws.com/bucketname/objectid_。object的identifier可以是文件名或带有相对地址的文件名(e.g., myalbum/august/photo21.jpg)。通过这样的命名模式，S3的存储可以呈现为一个常规的文件系统。
####2. S3 REST Security
S3 REST的所有资源都是受保护的，AWS客户通过分配的AWSSecretKey来访问资源，这个key由AWSSecretKeyID进行验证。S3的安全特性包括：

- Authentication: requests include AWSAccessKeyID
- Authorization: Access Control List(ACL) could be applied to each resource
- Integrity: Request are digitally signed with AWSSecretKey
- Confidentiality: S3 is available through both HTTP and HTTPS
- Non repudiation: Requests are time stamped(with integrity, it's a proof of transaction)

###网络攻击
####1. 密码保护
数据库中的用户密码绝对不能明文，常用MD5,sha1等算法加密存储。但是万一哪天服务器的数据库被泄漏，所有存储的用户及其密码数据都被公开了（CSDN的教训想必大家都还后怕着...），那么即使是加密过的密码也很容易被破解（甚至有专门的网站可以提供批量解密功能）。如何在数据库中存储的用户数据被泄漏后，仍能保障账号安全呢？  
其实方法很简单，数据库不存真实的登录密码就行了。具体方案是：  
>_step1_: 当用户设置自己的密码password后，后台程序自动在用户的密码后面添加一些附加字符串str(如：&6%％¥hfhj;)后再加密，那么数据库中存储的密码为：MD5(password+str)或者MD5(MD5(password+str))。这个附加字符串被称为盐值salt。  
>_step2_: 用户登录时，后台程序通过相同的处理方式，加密输入的密码，然后再与数据库中存储的密码进行匹配  

####2. Session Fixsation Attack[[wiki](http://en.wikipedia.org/wiki/Session_fixation)] 
Session fixation attack(会话固定攻击)是利用服务器的session不变机制，借他人之手获得认证和授权，然后冒充他人。如果应用程序在用户首次访问时为该用户建立一个匿名会话，并且在用户登录成功后，仍然使用该会话的SID(sessionId)，那么便存在安全漏洞。  
**攻击场景**   
>_step1_: Mallory访问 http://unsafe/ 并获得了一个会话ID（SID），例如服务器返回的形式是：Set-Cookie: SID=0D6441FEA4496C2  
_step2_: Mallory给Alice发了一个邮件：“我行推出了一项新服务，率先体验请点击：http://unsafe/?SID=0D6441FEA4496C2”  
_step3_: Alice点击并登录了  
_step4_: 因为服务器的会话ID不改变，现在Mallory点击“http://unsafe/?SID=0D6441FEA4496C2”后，他就拥有了Alice的身份  

**防范措施**  
最简单的防范措施是，在每次用户登录成功后，将旧的会话失效，为该用户创建一个新的会话。

####3. Replay Attack[[wiki](http://en.wikipedia.org/wiki/Replay_attack)]

**防范措施**  
[Cryptographic nonce](http://en.wikipedia.org/wiki/Cryptographic_nonce)

####参考资料  
1. [关于Spring Security中无Session和无状态stateless](http://www.cnblogs.com/Mainz/p/3230077.html)
2. [Jetty源码学习11-Session](http://my.oschina.net/tryUcatchUfinallyU/blog/113350)
3. [RESTful Authentication](http://stackoverflow.com/questions/319530/restful-authentication)
4. [Principles for Standardized REST Authentication](http://broadcast.oreilly.com/2009/12/principles-for-standardized-rest-authentication.html)
5. [How to implement RESTful authentication](http://blog.synopse.info/post/2011/05/24/How-to-implement-RESTful-authentication)
6. [Security of REST authentication schemes](http://stackoverflow.com/questions/454355/security-of-rest-authentication-schemes)