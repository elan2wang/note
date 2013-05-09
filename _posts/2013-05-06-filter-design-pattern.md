---
layout: post
title: Thinkings about filter design
tags: Lucene
---

Lucene的TokenFilter设计中，数据流经过多个Filter时，只需要遍历一遍数据流，和Java API中的字符串过滤器原理相似。特点是，所有的Filter都以word为基本单位进行处理。

Servlet的Filter设计中，数据流每经过一个Filter，都会被遍历一遍。特点是，不同过滤器对数据流的处理方式都不尽相同。

{% highlight java %}
public class TestUtil {
	public static void debug(Reader reader, String comment) {
		Reader input = reader;
		final char[] buffer = new char[112];
		int datalen = 0;
		try {
			System.out.print("[" + comment + "]\n");
			while ((datalen = input.read(buffer)) != -1) {
				ArrayUtil.print(buffer, 0, datalen);
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
{% endhighlight %}