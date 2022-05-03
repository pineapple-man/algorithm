## preliminary

## Binary Tree

## Binary Search Tree

## Segment-Tree

> 左边能够得到一个信息，右边能够得到一个信息，父节点可以简单加工得到。这样的例子方便使用线段数。

线段树总共提供如下方法：

|       操作        |         含义         |   时间复杂度   |
|:---------------:|:------------------:|:---------:|
|  `add(l,r,v)`   | 区间`[l,r]`上统一增加`v`  | `O(logn)` |
| `update(l,r,v)` | 区间`[l,r]`上统一更新为`v` | `O(logn)` |
|  `query(l,r)`   |    区间`[l,r]`上求和    | `O(logn)` |

1. 落方块问题

> [力扣链接](https://leetcode.cn/problems/falling-squares/)

2. 1～N 有 N 个房子，56个颜色，可以任意的选择执行 update(L,R,color)操作，即在`[L,R]`上的房子都刷成`color`颜色，以及`query(L,R)`操作，查询`[L,R]`上的颜色种类 
