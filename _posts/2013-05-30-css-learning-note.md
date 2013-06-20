---
layout: post
title: CSS学习笔记
tags: css em
categories: Web
---
- [EM与弹性布局](http://www.w3cplus.com/css/px-to-em)  
em作为单位时，元素大小不是固定的。假设标签&lt;p>的父标签为&lt;div>，且定义了font-size为16px，若&lt;p>标签的font-size为2em，则&lt;p>标签内文字的实际大小为16\*2=32px  
- [CSS选择器](http://www.w3school.com.cn/cssref/css_selectors.asp)  
element,element	div,p	选择所有 <div> 元素和所有 <p> 元素。	1
element element	div p	选择 <div> 元素内部的所有 <p> 元素。	1
element>element	div>p	选择父元素为 <div> 元素的所有 <p> 元素。	2
element+element	div+p	选择紧接在 <div> 元素之后的所有 <p> 元素。	2