---
layout: post
title: Java Low Latency
tags: ZeroGC, JIT, Lock-free
categories: Java
---

# Zero GC
* Use primitive type whenever possible
* Use mutable object whenever possible
* Use object pool when object creation is inevitable
* LSB+MSB <=> UUID
* Avoid for-each on object collection
* Avoid stream API
* Avoid autoboxing
* Avoid 

# Threading & Lock-free
* CPU pinning
* Optimistic concurrency control
* CAS (Atomic, ConcurrentHashMap#)
* Volatile
* Circular buffer

# JIT
* Warmup
* Simple code
* 

# IPC
* shared memory
* SBE (Binary)
* Protobuf (key-value)

# JVM Parameters
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

# Profiling
