---
layout: post
title: Lucene源码分析(1)—文本处理
tags: Lucene analysis
categories: Lucene
---
本文主要分析[Lucene](http://lucene.apache.org/)源码中关于文本处理的部分，该功能封装在[analysis](http://www.docjar.com/docs/api/org/apache/lucene/analysis/package-index.html)包中。本文并不涉及Lucene的使用方法介绍。
![lucene logo]({{ site.url }}/images/lucene_logo.png)
Lucene的文本处理包括：去除非字母字符、大写字母转换成小写、去除停用词、词形还原...等等，并且可以通过自定义扩展实现所需的处理。*Analyzer*抽象类是Lucene进行文本处理的重要类，所有继承*Analyzer*的子类都需要重写*tokenStream()*方法，该方法将文本信息转换成Token流并返回一个*TokenStream*对象，每一个Token除了包含文本单词以外，还包括一些重要的元数据，如：该单词的位置信息，偏移量等。*TokenStream*可以逐一枚举所有的Token并实现对Token的处理和转换。在Lucene中有两类重要的*TokenStream*，分别是*Tokenizer*和*TokenFilter*，下图描述了它们之间的类图关系：
![TokeStream Class Hierarchy]({{ site.url }}/images/tokenstream-class.png)
从上图中，可以看出*TokenFilter和TokenStream*之间有组合关系，也就是说，*TokenFilter*中可以再封装一个*TokenStream*对象(可以是*Tokenizer*也可以是*TokenFilter*)。*Tokenizer*从*java.io.Reader*读取字符并创建Token流，而*TokenFilter*读取Token流，并输出新的Token流（通过添加、删除Token，或者修改Token属性）。Lucene中文本分析链一般从一个*Tokenizer*开始，然后经过若干个不同*TokenFilter*，最后输出Token流：
![analyzer chain]({{ site.url }}/images/analyzer-chain.png)
Lucene中文本分析链的创建时同过*TokenStream*的嵌套形成的，例如：在创建第一个*TokenFilter*对象时，需要传递*Tokenizer*对象给它；在创建第二个*TokenFilter*对象时，需要传递第一个*TokenFilter*对象给它；依次类推，从而形成一个分析链。文本按照*TokenStream*的嵌套顺序，依次被处理。
<br>
下面我将通过一段具体的代码分析TokenFilter中，数据流是如何传递的：
{% highlight java %}
public TokenStream tokenStream(String fieldName, Reader reader) {
  return new StopFilter(enablePositionIncrements, new LowerCaseTokenizer(reader), stopWords);
}
{% endhighlight %}
以上代码中出现在*StopAnalyzer*类中，*StopAnalyzer*为*Analyzer*的子类，*StopFilter*为*TokenFilter*的子类，*LowerCaseTokenizer*为*Tokenizer*的子类。*tokenStream*方法从*Reader*读取文本，创建*LowerCaseTokenizer*对象，并将其作为参数传递给*StopFilter*对象。文本在*LowerCaseTokenizer*中被转换成Token流，然后经过*StopFilter*去除Token流中的停用词。下面的*increamentToken()*是*StopFilter*中逐一处理Token的方法：
{% highlight java %}
public final boolean incrementToken() throws IOException {
  // return the first non-stop word found
  int skippedPositions = 0;
  while (input.incrementToken()) {
    if (!stopWords.contains(termAtt.termBuffer(), 0, termAtt.termLength())) {
      if (enablePositionIncrements) {
        posIncrAtt.setPositionIncrement(posIncrAtt.getPositionIncrement() + skippedPositions);
      }
      return true;
    }
    skippedPositions += posIncrAtt.getPositionIncrement();
  }
  // reached EOS -- return false
  return false;
}
{% endhighlight %}
以上代码表明，*StopFilter*每次从*LowerCaseTokenizer*中取出一个Token，判断该Token是否在stopWords中，若存在则跳过该Token，若不存在则修改该Token的位置属性；处理完之后再取下一个Token。由此可知，Token流在经过多个*TokenFilter*时，是一个Token先经过所有的*TokenFilter*，然后再去下一个Token经过所有的*TokenFilter*；而并不是所有的Token先经过第一个*TokenFilter*，然后所有的Token再经过下一个*TokenFilter*。这样做的好处是，Token流在经过多个*TokenFilter*时，只遍历了一遍。