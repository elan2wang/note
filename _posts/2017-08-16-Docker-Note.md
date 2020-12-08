---
layout: post
title: Docker note
tags: docker
categories: Docker
---

1. Useful commands

<code>$ docker ps -a | grep "Exited" | awk '{print $1 }' | xargs docker rm</code>

<code>$ docker images | grep "none" | awk '{print $3 }' | xargs docker image rm</code>

