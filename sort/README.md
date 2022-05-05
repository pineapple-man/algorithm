## Sort

排序是算法中很重要的一块，此模块将主要记录计算机领域中那些精彩绝伦的排序算法及其应用。

## merge sort

时间复杂度为O(N*logN),空间复杂度O(),具体的代码实现在[这里](src/main/java/com/pineapple/MergeSort.java)

1. 小和问题。对于每一个数组，计算出其左边比它小的元素和[solution-java]()

2. 给定一个数组arr,两个整数 lower 和 upper，返回arr 中又多少个子数组的累加和在`[lower,upper]`范围上

## quick sort

1. 荷兰国旗问题。在一个arr数组中，给定一个数 target,将`<= target`的数放在数组的左边，`>target`的数放在数组的最右边。（要求空间复杂度O(1),时间复杂度O(n),不要求放置的元素有序）。
   [solution-java](src/test/java/com/pineapple/DutchFlagSolutionTest.java)


2. 荷兰国旗进阶版。在一个arr数组中，给定一个数 target,将`< target`的数放在数组的左边，`>target`的数放在数组的最右边、`==target`的数放在最中间。（要求空间复杂度O(1),时间复杂度O(n)
   ，不要求放置的元素有序）[solution-java](src/test/java/com/pineapple/DutchFlagSolutionTest.java)


3. 荷兰国旗变种。（不再有人为定义的`target`，将数组的最后一个元素作为`target`）

4. 在无序数组中求第K小的数

> 改写快排的方法
> bfptr算法
>

## heap sort
