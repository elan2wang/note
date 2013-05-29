---
layout: post
title: Shell编程笔记
tags: LDA Extend
categories: 机器学习 文本分析
---
**Awk编程笔记**  
1. awk读取文件的指定行的指定字段
{% highlight shell %}
awk 'NR==n {print $k}' path/filename
{% endhighlight %}
n,k正整数，分别表示行号和字段号。若要用变量表示行号，则需要用单引号将变量引起来
{% highlight shell %}
awk 'NR==n {print $k}' path/filename
{% endhighlight %}

参考资料：
1. [awk学习笔记](http://man.lupaworld.com/content/manage/ringkee/awk.htm#id2861697) - Jims of 肥肥世家
2. [sed学习笔记](http://tsnc.zhongaokao.com/tsnc_wgrj/doc/sed.htm) - Jims of 肥肥世家
