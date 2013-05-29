---
layout: post
title: Shell编程笔记
tags: shell awk sed
categories: Linux
---
**Awk编程笔记**  
1. awk读取文件的指定行的指定字段
**awk 'NR==n {print $k}' path/filename** 
n,k正整数，分别表示行号和字段号。若要用变量表示行号，则需要用单引号将变量引起来

参考资料：
1. [awk学习笔记](http://man.lupaworld.com/content/manage/ringkee/awk.htm#id2861697) - Jims of 肥肥世家
2. [sed学习笔记](http://tsnc.zhongaokao.com/tsnc_wgrj/doc/sed.htm) - Jims of 肥肥世家
