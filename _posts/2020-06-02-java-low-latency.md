---
layout: post
title: Java Low Latency
tags: ZeroGC JIT Lock-free
categories: Java
---

# Zero GC
* Use primitive type whenever possible
* Use mutable object whenever possible (e.g. High frequency data like book and order acknowledgement read from shared memory)
* Use object pool when object creation is inevitable
* LSB+MSB <=> UUID
* Avoid for-each on object collection
* Avoid stream API
* Avoid autoboxing

# Concurrency
## Volatile
* [Basic - visibility/happen-before](https://www.baeldung.com/java-volatile)
* [Cache coherence](https://en.wikipedia.org/wiki/Cache_coherence)
* [Memory barrier](https://en.wikipedia.org/wiki/Memory_barrier)

## Non-Blocking
* Optimistic Locking (aka. Optimistic Concurrency Control)
* CAS
* A-B-A Problem

## CPU pinning

### How to check
* ps
* lscpu (e.g. lscpu --all --parse=CPU,Socket)
* cat /proc/cmdline
* cat /etc/redhat-release
* jps
* jstack

## Circular buffer

# JIT
* Warmup
* Simple code

# IPC
* Shared memory
* SBE (Binary)
* Protobuf (key-value)

# JVM Parameters
```java
-XX:MetaspaceSize=128m
-XX:MaxMetaspaceSize=256m
-XX:+UseNUMA (GC Heap Locality group)
-XX:-UseBiasdLocking
-XX:MaxGCPauseMillis=1
-XX:UnlockDiagnosticVMOptions
-XX:ComplieThreshold=1
-XX:+PrintCompilation
-XX:+PrintCodeCache
-XX:+PrintGCApplicationStoppedTime
-XX:+PrintGCApplicationConcurrentTime
-XX:+PrintSafepointStatistics
```

# Profiling
## JProfiler
