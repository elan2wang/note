---
layout: post
title: Docker note
tags: docker
categories: docker
---

1. Useful commands
$ docker ps -a | grep "Exited" | awk '{print $1 }' | xargs docker rm
$ docker images | grep "none" | awk '{print $3 }' | xargs docker image rm

