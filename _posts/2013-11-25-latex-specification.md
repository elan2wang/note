---
layout: post
title: Latex笔记
tags: latex
categories: Tex
---
#### Latex Wikis
1. 数学公式 [Mathematics](http://en.wikibooks.org/wiki/LaTeX/Mathematics)
2. 字体设置 [Fonts](http://en.wikibooks.org/wiki/LaTeX/Fonts)
3. 参考文献 [Reference](http://en.wikibooks.org/wiki/LaTeX/Bibliography_Management)
4. 图片设置 [Figure](http://en.wikibooks.org/wiki/LaTeX/Floats,_Figures_and_Captions)
5. 列表格式 [List_Structures](http://en.wikibooks.org/wiki/LaTeX/List_Structures)

#### Install new package manually
1. download source file from <http://www.ctan.org/>
2. create a folder for this package with its name under the folder  <code>/usr/local/texlive/2014/texmf-dist/tex/latex<code>  
3. move the sty file to this folder
3. update package info with command <code>sudo mktexlsr</code>
4. locate a package with command <code>kpsewhich [package-name]</code>

#### Tips
1. 参考文献排序  
\bibliographystyle{unsrt}：按照引用的先后排序  
\bibliographystyle{plain}：按字母的顺序排列，比较次序为作者、年度和标题，其中作者中姓氏字母优先