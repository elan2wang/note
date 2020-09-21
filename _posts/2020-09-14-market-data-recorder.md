---
layout: post
title: Market data recorder
tags: market data
categories: python, analytic
---

Cryptocurrency's option market continue to grow in the past month. The open interest of the coming monthly expiry BTC option is again at $1 billion level.
![btc option open interest by expiry](/note/images/skew_btc_options_oi_by_expiry_k_prev_day.png  width="%80")

In the traditional financial system, it's very difficult (costy) for individual to acess the market data, nevertheless to say analyze and trade option in a way of institutional user. But the cryptocurreny option market is open for everyboday, we can easily subcribe to realtime market data and programatically trade option with open API provided by all crypto exchanges.

### Choose Database
As a first step, I'll try to use Python to subscribe realtime market data and persist into localdisk (to the cloud in the later post), so it can be used for analytic research. To store the data, we need to find out a proper database, which should have below characteristics:
* Efficiency - enpower fast query in large scale
* Scalbility - easy to scale up, efficient compression support to save disk usage
* Interoperability - support access by different language or different platform

By its nature time series data is columnar, [KDB+](https://kx.com/) is one of the best solution to work with. It is a fast database which also enables you to query and manipunate data in memory using its own language [Q](https://code.kx.com/q/). However KDB+ is not open source, it can only be used for non-comercial purpose for free. Thanks to Saeed who has compared several state of the art [time series database in his post](https://www.cuemacro.com/2019/02/02/storing-time-series-data/). Based on that, we decide to combine [Apache Parquet](https://parquet.apache.org/) as the storage format, [Apache Arrow](https://arrow.apache.org/) as the memory format and [PyArrow](https://arrow.apache.org/docs/python/) as the processing engine.

### Subscribe Market Data
From the [Skew](https://analytics.skew.com/dashboard/bitcoin-options width="%80") statistic, Deribit is the most active exchange for BTC option, so I'll start with Deribit API to subscribe the market data. 
![btc opion open interest by exchange](/note/images/skew_total_btc_options_open_interest.png)
As it is public data, we don't even need to create a account. In this post, we'll need three APIs which are:
```
public/get_instruments
public/set_heartbeat
public/test
public/subscribe
```
During my test, if we don't `set_heartbeat`, the server side will terminate the web socket connection after 10 minutes. To keep the connection alive, we need to `set_heartbeat` with an `interval`, and respond to the heartbeat request per interval.


### Persist Market Data
Since we are listening to the ticking data, we should incrementally write data into the Parquet file. The only way to do so is via the `ParquetWriter` class.
```python
import pyarrow.parquet as pq

# ... define the table schema and create an parquet file writer
self.ticker_schema = pa.schema([
    ('timestamp', pa.timestamp('ms')),
    ('symbol', pa.string()),
    ('index_price', t_float),
    ('mark_price', t_float),
    ('last_price', t_float),
    ('mark_iv', t_float),
    ('biv', t_float),
    ('aiv', t_float),
    ('bbp', t_float),
    ('bbs', t_float),
    ('bap', t_float),
    ('bas', t_float),
    ('delta', t_float),
    ('gamma', t_float),
    ('vega', t_float),
    ('theta', t_float),
    ('rho', t_float)
])
self.ticker_writer = pq.ParquetWriter("ticker.parquet",self.ticker_schema)

# ... build PyArrow table from a list of array, and write to the parquet file
tickers = pa.table(
    [
        self.ticker_ts,         # timestamp array
        self.ticker_sym,        # symbol array
        self.ticker_index_price,
        self.ticker_mark_price,
        self.ticker_last_price,
        self.ticker_mark_iv,
        self.ticker_biv,
        self.ticker_aiv,
        self.ticker_bbp,
        self.ticker_bbs,
        self.ticker_bap,
        self.ticker_bas,
        self.ticker_delta,
        self.ticker_gamma,
        self.ticker_vega,
        self.ticker_theta,
        self.ticker_rho
    ], self.ticker_schema)
self.ticker_writer.write_table(tickers)

# ... close the writer to ensure the metadata of footer are appended to the parquet file
self.ticker_writer.close()

```

### Play with Market Data


### Others
* [Reducing Python String Memory Use in Apache Arrow 0.12](https://arrow.apache.org/blog/2019/02/05/python-string-memory-0.12/)