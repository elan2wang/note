---
layout: post
title: Objective-C数据类型
tags: Object-C 数据类型
categories: IOS开发
---
Objective-C的数据类型可以分为：基本数据类型，对象类型和id类型。  

字符串创建方式：
{% highlight objective-c linenos %}
NSString *firstString = [[NSString alloc] initWithCString:"Hello World!" encoding:NSUTF8StringEncoding];
NSString *secondString = [NSString stringWithCString:"Hello World!" encoding:NSUTF8StringEncoding];
NSString *thirdString = @"Hello World!";
{% endhighlight %}
**NSString**是不可变的，也就是说她的字符串的内容在创建时就设定好了，之后无法改变。如果要表示另一个字符串，必须按如下方式创建一个新的字符串变量：
{% highlight objective-c linenos %}
NSString *name = @"John";
name = [name stringByAppendingString:@"ny"];
{% endhighlight %}