---
layout: post
title: Shell编程笔记
tags: shell awk sed
categories: Linux
---
###常用命令
1. source  
source命令也称为“点命令”，也就是一个点符号（.）。source命令通常用于重新执行刚修改的初始化文件，使之立即生效，而不必注销并重新登录。用法如下：  
<code>source filename [arguments]</code>
2. which  
which指令会在环境变量$PATH设置的目录里查找符合条件的文件。用法如下：  
<code>which [-as] program ...</code>

##Awk编程笔记
1. 读取文件的指定行的指定字段  
<code>awk 'NR==n {print $k}' path/filename</code>  
n,k正整数，分别表示记录的行号和字段号。若要用变量表示行号，则需要用单引号将变量引起来  
<code>awk 'NR==5,NR=8 {print $0}' path/filename</code>  
打印第5行和第8行的记录  
<code>awk 'NR%10==5 {print $0}' path/filename</code>  
打印行号除以10后余数为5的行的记录  
2. 将awk命令的输出传递给其它变量  
<code>text=${awk '{print $0}' path/filename}</code>  
  
###Sed编程笔记
###参考资料  
1. [awk学习笔记](http://man.lupaworld.com/content/manage/ringkee/awk.htm#id2861697) - Jims of 肥肥世家
2. [sed学习笔记](http://tsnc.zhongaokao.com/tsnc_wgrj/doc/sed.htm) - Jims of 肥肥世家
