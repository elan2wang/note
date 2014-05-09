---
layout: post
title: Linux参考手册
tags: shell awk sed
categories: Linux
---
###系统管理命令（CentOS）
- 防火墙管理  
<code>/etc/sysconfig/iptables</code> #配置文件目录  
<code>/etc/init.d/iptables status|start|stop|restart</code>  
<code>service iptables status|start|stop|restart</code>  
<code>iptables -L</code> ＃查看规则是否生效  
- 查看系统信息  
<code>cat /proc/version</code>  
<code>uname -a</code>  
<code>cat /etc/issue</code>  
<code>top</code>  #查看CPU和内存使用情况  
<code>free</code> #仅查看内存使用情况  
- 查看rpm包的安装路径  
<code>rpm -ql packagename</code>
- 查找文件  
<code>find [path] -name [name]</code>  
- 进程相关  
<code>ps -ef | grep java</code>  
<code>ps -aux | grep java</code> #显示所有java的进程  
<code>kill -9 pid</code> #－9表示强制退出  
- 创建ssh密钥  
<code>ssh-keygen -t rsa</code>  
- 修改系统启动方式  
<code>sudo vim /etc/default/grub</code>  
<code>GRUB_CMDLINE_LINUX_DEFAULT="quiet splash"</code> #图形界面  
<code>GRUB_CMDLINE_LINUX_DEFAULT="text"</code> #文本界面  
<code>sudo update-grub</code> #修改后执行更新, 否则重启仍是原模式  


###系统服务管理
<code>chkconfig --list</code> ＃查看服务在每个级别上的运行状态  
<code>chkconfig --level 345 vsftpd off</code> ＃将vsftpd服务在345这个级别关闭  

<code>/etc/init.d</code> 这个目录存放着系统中各种服务(sshd, samba, ftpd, mysql, apache2, networking...)的脚本文件。这些脚本至少提供了<code>start/stop</code>命令, 通过<code>/etc/init.d/sshd start|stop|restart</code>可以对这些服务进行相应的操作。  
<http://www.ghacks.net/2009/04/04/get-to-know-linux-the-etcinitd-directory/>  

<code>service sshd start</code>与<code>/etc/init.d/sshd start</code>具有完全相同的效果, <code>service SCRIPT</code>会调用<code>/etc/init.d/SCRIPT</code>的脚本。  

<code>service -s|--status-all</code> runs all init scripts locateds in <code>/etc/init.d/</code>, in alphabetic order, with the **status** command.  

####ftp配置与管理  
<code>which vsftpd</code> #查看是否安装了vsftpd  
<code>/etc/vsftpd/vsftpd.conf</code>    #配置文件目录  
<code>local_enable=YES</code> #取消该行注解, 启用本地用户登录  
<code>write_enable=YES</code> #取消该行注解, 允许用户上传文件; 若未启用, 在上传文件时会出现: ERROR 550: permission denied  
<code>/etc/init.d/vsftpd status|start|stop|restart</code> #服务状态/开启/停止/重启  
<code>service vsftpd status|start|stop|restart</code> #服务状态/开启/停止/重启  

####VNC配置与管理  
- VNC基本命令  
<code>vncserver :1</code> #启动端口为1的vnc服务  
<code>vncserver -kill :1</code> #关闭端口1的vnc服务(kill后面有空格)  
<code>vncpasswd</code> #修改当前用户的vnc登录密码
- 修改VNC默认设置  
<code>sudo chmod 755 /etc/X11/xinit/xinitrc</code> #使文件/etc/X11/xinit/xinitrc成为可执行文件
<code>vim ~.vnc/xstartup</code> #修改vnc的配置文件, 修改后如下  
>\#!/bin/sh  
>\# Uncomment the following two lines for normal desktop:  
>unset SESSION_MANAGER  
>exec /etc/X11/xinit/xinitrc  
>  
>[ -x /etc/vnc/xstartup ] && exec /etc/vnc/xstartup  
>[ -r $HOME/.Xresources ] && xrdb $HOME/.Xresources  
>\#xsetroot -solid grey  
>\#vncconfig -iconic &  
>\#x-terminal-emulator -geometry 80x24+10+10 -ls -title "$VNCDESKTOP Desktop" &  
>\#x-window-manager &  

####MySQL配置与管理
<code>mysql> CREATE USER user_name IDENTIFIED BY "your_password";</code> #创建用户
<code>mysql> GRANT ALL PRIVILEGES ON *.* TO root@'%' IDENTIFIED BY 'your paaaword';</code> #用户授权  
<code>mysql> GRANT SELECT,INSERT,UPDATE,DELETE ON *.* TO test1@"%" IDENTIFIED BY "your_password";</code> #用户授权  
<code>mysqladmin -u root password 'new-password'</code> #修改用户密码  
<code>mysql> SET PASSWORD FOR username@"%" = PASSWORD('password');</code> #修改用户密码  
<code>mysql> GRANT USAGE ON *.* TO username@"%" IDENTIFIED BY 'password';</code> #修改用户密码  

###JDK和tomcat安装配置
1. 下载jdk和tomcat  
2. 安装jdk<code>rpm -ivh jdk-[version].rpm</code>  
3. 配置环境变量  
<code>vim /etc/profile</code>  
>\#set java environment  
>JAVA_HOME=/usr/java/jdk1.7.0_25  
>CLASSPATH=.:\$JAVA_HOME/lib  
>PATH=.:\$PATH:\$JAVA_HOME/bin  
>CATALINA_HOME=/usr/local/tomcat  
>export JAVA_HOME CATALINA_HOME  
<code>source /etc/profile</code>  

###常用命令
1. source  
source命令也称为“点命令”，也就是一个点符号（.）。source命令通常用于重新执行刚修改的初始化文件，使之立即生效，而不必注销并重新登录。用法如下：  
`source filename [arguments]`
2. which  
which指令会在环境变量$PATH设置的目录里查找符合条件的文件。用法如下：  
`which [-as] program ...`
3. wget  
获取ftp站点的文件夹:  
`wget ftp://host/src/ [--user username] [--password yourpassword]`

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
