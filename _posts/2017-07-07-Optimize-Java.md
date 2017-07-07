
---
layout: post
title: Optimize Java
tags: GC JIT Heap Memmory
categories: Java
---
# Intruction

## JVM subsystem

Class loader
Interpreter
JIT compiler
Garbage collector

# Memory Model

## Heap generation

# Garbage Collectors

## GC catalog

### Parallel GC

### Concurrent GC (CMS)

### Garbage first collector (G1)

## GC profiling and tuning 

# Just-In-Time (JIT) compilation

## JIT Optimization

### [Inline Caching](https://en.wikipedia.org/wiki/Inline_caching)

Eliminate the method lookup overhead by remembering the previous invocation

### [Loop Unrolling](https://en.wikipedia.org/wiki/Loop_unrolling)

Space-time trade off

### [Monomorphic Dispatch]

### [Dead Code Elimination]

### [Intrinsic]

### [Escape Analysis](https://en.wikipedia.org/wiki/Escape_analysis)

Lambda is passed as parameter, it will be allocated on the stack? 

