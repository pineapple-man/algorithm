## preliminary

滑动窗口是一种双指针算法的一种具像化结构。

滑动窗口就只有一个原则：不要让左边指针`L`超过`R`

## overlapping model

## min-max update model

设计一个能够以`O(1)`复杂度获取窗口内最大值的更新结构

1. 假设一个固定大小为 W 的窗口，依次划过 arr，返回每一次滑出状况的最大值。例如：arr = {4,3,5,4,3,3,6,7},W =
   3;返回`{5,5,5,4,6,7}`[solution-java](src/test/java/com/pineapple/WindowMaxSolutionTest.java)


2. 给定一个整数数组 arr，和一个整数 num。某个 arr 中的子数组 sub，如果想达标，必须满足：sub 中最大值 - sub 中最小值 <= num,返回 arr 中达标子数组的数量

3. 加油站的良好出发点问题。有两个数组，分别为 gas,cost，分别表示对应加油站内存储的油量。cost为从i->i+1
   的耗费。多个加油站之间构成环状结构，返回从每一个加油站作为起点，是否可以重新回到起点的数组。

4. 给定一个有序数组 arr , 从左到右依次表示 X 轴上从左到右点到位置，给定一个正整数 K，返回如果有一根长度为 K
   的绳子，最多能盖住几个点。（绳子的边缘点碰到 X
   轴上的点，也算盖住)[solution-java](src/test/java/com/pineapple/P4Test.java)

5

6. 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k
   的连续子数组的数目。[solution-java](src/test/java/com/pineapple/SubArraySolutionTest.java)

> [力扣链接](https://leetcode.cn/problems/subarray-product-less-than-k/)