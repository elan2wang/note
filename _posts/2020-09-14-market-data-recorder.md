---
layout: post
title: Market data recorder
tags: market data
categories: python, analytic
---

In this post, we want to explore how to record crypto market data in realtime and persist into local disk (to cloud in the future), which can be used for analytic research. Some inituitive thoughts:
* the data volume would increase dramatically over time
* the raw data might be accessed by different language or different platform
* the data store should enpower fast query in large scale

By its nature time series data is columnar, [KDB+](https://kx.com/) is one of the best solution to work with. It is a fast database which also enables you to query and manipunate data in memory using its own language [Q](https://code.kx.com/q/). However KDB+ is not open source, it can only be used for non-comercial purpose for free. Thanks to Saeed who has compared several state of the art [time series database in his post](https://www.cuemacro.com/2019/02/02/storing-time-series-data/). Based on that, we decide to use [Parquet](https://parquet.apache.org/) as the storage format. 

What we want to explore from the market data includes but not limited to:
* Open interest distribution
* Implied volatility curves, spread, term structure
* Histotical volatility
* Portfolio greeks