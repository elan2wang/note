---
layout: post
title: File Encoding Convert
tags: Encoding
categories: unix
---

Mac OS X comes with iconv utility that can convert text between encodings. 
Run the following command in Terminal to convert a gb2312 chinese text file to utf-8:

><code>iconv -f GB2312 -t UTF-8 chinese-gb2312.txt > chinese-utf8.txt</code>

To list the encodings that iconv supports:

><code>iconv -l</code>

