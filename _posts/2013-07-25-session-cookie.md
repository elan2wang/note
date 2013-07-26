---
layout: post
title: http协议分析－Cookie和Session
tags: http
categories: java http
---
**Cookie机制：**通过检查客户身上的“通行证”来确定客户身份，Cookie信息存储在客户端浏览器。  
**Session机制：**通过检查服务器上的“客户明细表”来确认客户身份，Session信息存储在服务器端。  

  
因为HTTP协议是无状态的，Session不能根据HTTP连接来判断是否为同一客户，因此服务器向客户端浏览器发送一个名为JESSIONID的Cookie，它的值为该Session的id（HttpSession.getId()的返回值），Session依据该Cookie来识别是否为同一用户。  
>该Cookie为服务器自动生成，它的maxAge属性一般为－1，表示仅当前浏览器内有效，并且浏览器窗口间不共享，关闭浏览器就会失效。因此同一电脑上的两个浏览器窗口访问服务器时，会生成两个不同的Session。但是由浏览器窗口内的连接、脚本等打开的新窗口除外，这些窗口会共享父窗口的Cookie，因此会共享一个Session。  

如果客户端浏览器将Cookie禁用，或者不支持Cookie，那么Session就不能再利用Cookie识别客户，这时可以采用**URL重写**，它将用户Session的id信息重写到URL地址中。服务器能够解析重写后的URL获取Session的id。


###参考资料
1. [Cookie/Session机制详解](http://www.360doc.com/content/11/1227/00/198_175229712.shtml)