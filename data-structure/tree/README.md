## preliminary

## Binary Tree

- [863. 二叉树中所有距离为 K 的结点](https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/)
  [solution-java]()

- [1022. 从根到叶的二进制数之和](https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/)
- [513. 找树左下角的值](https://leetcode.cn/problems/find-bottom-left-tree-value/)
  ——[solution-go](binary-tree/src/main/findBottomLeftValue.go)

## Trie(prefix tree)

前缀树相关的算法在[这里](trie/src/test/java/com/pineapple/TrieTest.java)

## Binary Search Tree

[449. 序列化和反序列化二叉搜索树](https://leetcode.cn/problems/serialize-and-deserialize-bst/)

## Dictionary Tree

## Segment-Tree

> 左边孩子能够得到一个信息，右边孩子能够得到一个信息，父节点可以简单加工得到。这样的例子方便使用线段数。

线段树总共提供如下方法：

|       操作        |         含义         |   时间复杂度   |
|:---------------:|:------------------:|:---------:|
|  `add(l,r,v)`   | 区间`[l,r]`上统一增加`v`  | `O(logn)` |
| `update(l,r,v)` | 区间`[l,r]`上统一更新为`v` | `O(logn)` |
|  `query(l,r)`   |    区间`[l,r]`上求和    | `O(logn)` |

1. 落方块问题

> [力扣链接](https://leetcode.cn/problems/falling-squares/)

2. 1～N 有 N 个房子，56个颜色，可以任意的选择执行 update(L,R,color)操作，即在`[L,R]`上的房子都刷成`color`颜色，以及`query(L,R)`操作，查询`[L,R]`上的颜色种类

> > 假设我们有一个数组：
>
> 数组不变，求区间和：「前缀和」、「树状数组」、「线段树」
> 多次修改某个数（单点），求区间和：「树状数组」、「线段树」
> 多次修改某个区间，输出最终结果：「差分」
> 多次修改某个区间，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
> 多次将某个区间变成同一个数，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
> 这样看来，「线段树」能解决的问题是最多的，那我们是不是无论什么情况都写「线段树」呢？
>
>答案并不是，而且恰好相反，只有在我们遇到第 4 类问题，不得不写「线段树」的时候，我们才考虑线段树。
>
>因为「线段树」代码很长，而且常数很大，实际表现不算很好。我们只有在不得不用的时候才考虑「线段树」。
>
>总结一下，我们应该按这样的优先级进行考虑：
>
>简单求区间和，用「前缀和」
> 多次将某个区间变成同一个数，用「线段树」
> 其他情况，用「树状数组」
>
>
> 作者：AC_OIer
> 链接：https://leetcode-cn.com/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/
> 来源：力扣（LeetCode）
> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## Index Tree

## B Tree

## B plus Tree
