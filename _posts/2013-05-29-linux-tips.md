---
layout: post
title: Linux参考手册
tags: shell awk sed
categories: Linux
---
###系统管理命令（CentOS）
1. 防火墙管理  
配置文件目录: /etc/sysconfig/iptables  
<code>/etc/init.d/iptables status|start|stop|restart</code>  
<code>service iptables status|start|stop|restart</code>  
<code>iptables -L</code> ＃查看规则是否生效  
2. ftp管理  
配置文件目录: /etc/vsftpd/vsftpd.conf  
<code>/etc/init.d/vsftpd status|start|stop|restart</code>  
<code>service vsftpd status|start|stop|restart</code>
3. 系统服务管理  
<code>chkconfig --list</code> ＃查看服务在每个级别上的运行状态  
<code>chkconfig --level 345 vsftpd off</code> ＃将vsftpd服务在345这个级别关闭
4. 查看系统信息  
<code>cat /proc/version</code>  
<code>uname -a</code>  
<code>cat /etc/issue</code>  
5. 查看运行文件的地址  
<code>which jdk</code>  
6. 查看rpm包的安装路径  
<code>rpm -ql packagename</code>
7. 查找文件  
<code>find [path] -name [name]</code>  
8. 进程相关  
<code>ps -ef | grep java</code>  
<code>ps -aux | grep java</code> #显示所有java的进程  
<code>kill -9 pid</code> #－9表示强制退出  
9. 创建ssh密钥  
<code>ssh-keygen -t rsa</code>  

###JDK和tomcat安装配置
1. 下载jdk和tomcat  
2. 安装jdk<code>rpm -ivh jdk-[version].rpm</code>  
3. 配置环境变量  
<code>vim /etc/profile</code>  
>\#set java environment  
>JAVA_HOME=/usr/java/jdk1.7.0_25  
>CLASSPATH=.:$JAVA_HOME/lib  
>PATH=.:$PATH:$JAVA_HOME/bin  
>CATALINA_HOME=/usr/local/tomcat  
>export JAVA_HOME CATALINA_HOME  
<code>source /etc/profile</code>  

###MySQL配置管理
1. 创建用户    
<code>mysql> CREATE USER user_name IDENTIFIED BY "your_password";</code>
2. 用户授权  
<code>mysql> GRANT ALL PRIVILEGES ON *.* TO root@'%' IDENTIFIED BY 'your paaaword';</code>  
<code>mysql> GRANT SELECT,INSERT,UPDATE,DELETE ON *.* TO test1@"%" IDENTIFIED BY "your_password";</code>  
3. 修改用户密码  
<code>mysqladmin -u root password 'new-password'</code>  
<code>mysql> SET PASSWORD FOR username@"%" = PASSWORD('password');</code>  
<code>mysql> GRANT USAGE ON *.* TO username@"%" IDENTIFIED BY 'password';</code>  

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
3. [MySQL 远程连接配置的正确实现](http://database.51cto.com/art/201006/204537.htm)
