## Specific Data structure

数据结构只是一种基础设计，现实生活中往往存在许多业务相关的数据结构。因此，此模块将主要集中在如何根据已有的数据结构，设计出满足特定要求的数据结构

## problem

1. [最近的请求次数](https://leetcode.cn/problems/number-of-recent-calls/)
   [solution-go](golang/recent_counter_test.go)

> 有如下结构:
> ```java
> class TopRecord{
> public TopRecord(int k); //构造事先制定好 K 个大小，构造后就固定不变
> public void add(String str);//向该结构中加入一个字符串，可以重复加入
> public List<String> top();//返回之前加入堆所有的字符串中，词频最大的 K 个
> }
> ```
> 要求: add() 时间复杂度为 O(log k)，top 方法的复杂度 O(k).
> [solution-java]()

