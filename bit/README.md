## preliminary

位运算的题目需要非常多的经验，没有太多的套路而言，还是需要多见多练

## XOR(异或)

**异或运算就是无进位相加**,异或运算满足交换律，并且同样一批数不论以什么顺序进行异或，最终的结果一定都相同

> 0 ^ N = N
>
> N ^ N = 0
>
>  a ^ b = b ^ a
>
> a^(b^c) = (a^b)^c

## 题目

> 如何不使用任何一个额外的变量，交换两个数。
> [solution-java](../common/src/test/java/com/pineapple/util/UtilsTest.java)

> 怎么把一个 int 类型数的最右侧的 1 提取出来。[solution-java]()

> 一个数组中有一个数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数？

> 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数。

> 一个数组中有一种数出现了 K 次，其他数都出现了 m 次`(m>1,k<m)`,找到出现了 k 次的数，要求，额外空间复杂度为`O(1)`
> ，时间复杂度为`O(N)`。

> 给定一个非负整数 num,如果不用循环语句，返回`>=num`，并且离 num 最近的，2
> 的某次方。
> [solution-java](src/test/java/com/pineapple/NearestNumberPowerSolutionTest.java)


> 给定一个数 num 和一个数 target，找到 `num>=target` 且 num 是 target
> 倍数的最小数。[solution-java]()