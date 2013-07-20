---
layout: post
titile: jersey错误分析
tags: java rest jersey
categories: java
---
####problem  
<code>
The ResourceConfig instance does not contain any root resource classes.
</code>  
here is the web.xml  
<code>
<servlet>
    <servlet-name>Jersey REST Service</servlet-name>
    <servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>
    <init-param>
      <param-name>com.sun.jersey.config.property.packages</param-name>
      <!-- my package which contain resource -->
      <param-value>com.bmp.resource</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>Jersey REST Service</servlet-name>
    <url-pattern>/*</url-pattern>
  </servlet-mapping>
</code>
####solution
一般情况是com.bmp.resource包下缺少resource类  
  
####problem

####solution