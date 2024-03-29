## 递归

学习递归的时候，就是培养一种黑盒思维，通过人为设计一个黑盒，考虑它的含义，接受什么输入，通过一些步骤最终能够达到什么效果，对外输出何种内容等等。
只要最终将
base case
规定好，一个递归程序就非常容易实现。先来几道简单的递归类型题目练练手：

|                  题目描述                   |                                            对应题解                                             |
|:---------------------------------------:|:-------------------------------------------------------------------------------------------:|
|        打印 n 层汉诺塔从最左边移动到最右边的全部过程         |          [solution-java](attempt-model/src/test/java/com/pineapple/HanoiTest.java)          |
|              打印一个字符串的全部子序列              |  [solution-java](attempt-model/src/test/java/com/pineapple/SubsequencesSolutionTest.java)   |
|      打印一个字符串的全部子序列，要求不要出现重复字面值的子序列      |  [solution-java](attempt-model/src/test/java/com/pineapple/SubsequencesSolutionTest.java)   |
|              打印一个字符串的全部排列               |  [solution-java](attempt-model/src/test/java/com/pineapple/PermutationsSolutionsTest.java)  |
|        打印一个字符串的全部排列，要求不要出现重复的排列         |  [solution-java](attempt-model/src/test/java/com/pineapple/PermutationsSolutionsTest.java)  |
|  给你一个栈，请你逆序这个栈。要求：不能申请额外的数据结构，只能使用递归函数  |  [solution-java](attempt-model/src/test/java/com/pineapple/ReverseStackSolutionTest.java)   |

## 动态规划

什么是动态规划？
> 动态规划就是一种空间换取时间的算法模式。
> 例如，在求解某个问题时，总是存在当前问题依赖于一些重复计算的子问题，那么继续求解当前问题时，
> 就可以直接使用已经解决了子问题的答案，进而解决当前问题。
> 这样一种算法模式，就可以理解为动态规划。

动态规划类问题，在面试过程中可以具体到四种模型进行求解，这四种模型分别是：**
从左向右的尝试模型**、**范围尝试模型**、**样本对应模型**和**
业务限制模型**，接下来将对介绍各种模型常见的题目。

### 从左向右尝试模型

1. 机器人行走问题

> 假设有排成一行的 N 个位置，记为 1～N，N 一定大于或等于2。 开始时机器人在其中的 M
> 位置上
> （M 一定是 1～N 中的一个）。如果机器人来到 1 位置，那么下一步只能往右来到 2 位置；
> 如果机器人来到 N 位置，那么下一步只能往左来到 N-1 位置；如果机器人来到中间位置，
> 那么下一步可以往左或者往右走。规定机器人必须走 K 步，最终能来到 P 位置
> （ P也是 1 ～ N 中的一个）的方法有多少中？
> [solution-java](attempt-model/src/test/java/com/pineapple/RobotWalkSolutionTest.java)

2. 背包问题。

> 背包容量为W，一共有n袋零食，第i袋零食提体积为v[i],总体积不超过背包容量袋情况下一共有多少种
> 零食的方法（体积为0也是一种）
> [solution-java](attempt-model/src/test/java/com/pineapple/KnapsackSolutionTest.java)

3. 字符串转化

> 有下面一张转换表(1->a,2->b,...,26->z),那么一个数字字符串，
> 比如：111，就可以转化为AAA, KA 和 AK，给定一个只有数字字符组成的字符串
> string,返回有多少种转化结果。
> [solution-java](attempt-model/src/test/java/com/pineapple/ConvertSolutionTest.java)

4.[剪纸问题](https://leetcode.cn/problems/stickers-to-spell-word/)

> 给定一个字符串 str ,给定一个字符串类型的数组 arr,出现的字符都是小写英文。arr
> 每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出 str 来。
> 返回需要至少多少张贴纸可以完成任务。 例如： str = "babac" arr = {"ba","c","abcd"
> }，
> 至少需要两张贴纸"ba"和"abcd",因为使用这两张贴纸，
> 把每一个字符单独剪开，含有2个a，2个b、1个c。是可以拼出str的。所以返回2。
> [solution-java](attempt-model/src/test/java/com/pineapple/MinStickersSolutionTest.java)

5.

> arr 是货币数组，其中的值都是正数。再给定一个正数 aim。
> 每个值都认为是一张货币，即便是值相同的货币也认为每一张都是不同的。返回组成 aim
> 的方法数。
> 例如：arr = {1,1,1},aim = 2，第0个和第1个能组成2，
> 第1个和第2个能组成2，第0个和第2个能组成2，一共就有三种方法，所以返回3
> [solution-java]()、

6.

> arr 是面值数组，其中的值都是正数且没有重复。再给定一个正数 aim，每个值都认为是一种面值，
> 且认为张数是无限的。返回组成 aim 的方法数。例如：arr = {1,2},aim = 4,
> 方法如下:1+1+1+1,1+1+2, 2+2,一共就三种方法，所以返回3。
> [solution-java]()、

7.

> arr 是货币数组，其中的值都是正数。
> 再给定一个正数 aim。每个值都认为是一张货币，认为值相同的货币没有任何不同，返回组成
> aim
> 的方法数。例如：arr={1,2,1,1,2,1,2},aim=4,方法：1+1+1+1,1+1+2,2+2,一共就三种方法，
> 所以返回3。
> [solution-java]()、

8.

> arr 是面值数组，其中的值都是正数且没有重复。
> 再给定一个正数 aim。每个值都认为是一种面值，且认为张数是无限的，返回组成
> aim的最少货币数。
> [solution-java]()、

### 范围尝试模型

> 范围尝试模型，特别需要考虑开始如何，结尾如何两种情况

1. 给定一个整型数组 arr, 代表数值不同的纸牌排成一条线。玩家 A 和玩家 B
   依次拿走每张纸牌。规定玩家 A 先拿，玩家 B
   后拿。但是每个玩家每次只能拿走最左或最右的纸牌。假设玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。[solution-java](attempt-model/src/test/java/com/pineapple/PlayPokerSolutionTest.java)

2. 给定一个字符串 str ，返回这个字符串的最长回文子序列。比如：str="
   a12b3c43def2ghi1kpm"最长回文子序列是"1234321"或者"
   123c321"
   ，返回长度7。[solution-java](sample-corresponding/src/test/java/com/pineapple/SubsequencesSolutionTest.java)

### 样本对应模型

> 以结尾位置来组织可能性

1.[最长公共子序列问题](https://leetcode.cn/problems/longest-common-subsequence/)

> [solution-java](sample-corresponding/src/test/java/com/pineapple/SubsequencesSolutionTest.java)


2.马踏棋盘问题
> [solution-java](sample-corresponding/src/test/java/com/pineapple/KnightsTourTest.java)

3. 给定 5 个参数，N、W、

4. 最长公共子串

> 子串是连续的，而子序列并不要连续。
> [solution-java]()

6.

> 给定三个参数，N、M、K，怪兽有 N 滴血，等着英雄来砍自己。
> 英雄每一次打击，都会让怪兽流失`[0~M]`的血量，到底流失多少？
> 每一次在`[0~M]`上等概率的获取一个值。求K次打击之后，英雄把怪兽砍死的概率
> [solution-java]()

### 业务限制模型

使用业务估计动态规划表的范围

1. 给定一个数组 arr ，arr[i] 代表第 i 号咖啡机泡一杯咖啡的时间。给定一个正数 N，表示
   N
   个人等着咖啡机泡咖啡，每台咖啡机只能轮流泡咖啡。只有一台咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯。每个咖啡杯也可以自己挥发干净，时间耗费
   b，咖啡机可以并行挥发。假设所有人拿到咖啡之后立刻喝干净，返回从开始等到所有咖啡机变干净的最短时间。三个参数(
   int[] arr,int N,int
   a,int b)

[solution-java]()、

给定一个正数数组arr,请把 arr 中所有的数分成两个集合，尽量让两个集合的累加和接近。返回：最接近的情况下，较小集合的累加和。

给定一个正数数组 arr,请把 arr 中所有的数分成两个集合。如果 arr
长度为偶数，两个集合包含数的个数要一样多；如果 arr
长度为奇数，两个集合包含数的个数必须只差一个。请尽量让两个集合的累加和接近。返回最接近的情况下，较小集合的累加和。

## 优化技巧

### 动态规划的路径压缩技巧

空间压缩技巧是一个小技巧，有兴趣就用，没有兴趣就不用。对于整个算法时间复杂度的优化并没有非常多的优化。

1. 最小路径和

> 给定一个二维数组 matrix，一个人必须从左上角出发，最后到达右下角。
> 沿途只可以向下或者向右走，沿途的数字都累加就是距离累加和，请返回最小距离累加和
> [solution-java]()

### 斜率优化

可以通过之前的优化来简化当前枚举过程

给定一个正数，求它的裂开方法数，要求后面裂开的数字必须大于等于前面裂开的数字。例如：
3 = 1+1+1 = 1+2 ; 5 = 1+1+1+1+1 =
1+1+1+2 = 1+2+2 = 1+1+3（整数拆分问题）

[solution-java]()

### 四边形不等式优化

给定一个数组 arr，你可以在每个数字之前决定`+`或者`-`但是必须所有数字都参与，再给定一个数
target，请问最后算出 target 的方法数是多少？
[solution-java]()

给定一个二维数组 matrix，你可以从任何位置出发，走出上下左右四个方向，返回能走出来的最长的递增链长度。

给定一个非负数组arr，长度为 N，那么有 N-1 种方案，可以把 arr
切分成左右两部分。每一种方案都有，min{左部分累加和,右部分累加和}。求这么多方案种，min{做部分累加和，有部分累加和}
的最大值是多少？（整个过程要求时间复杂度为 O(N))[solution-java]()

[730. 统计不同回文子序列](https://leetcode.cn/problems/count-different-palindromic-subsequences/)

[873. 最长的斐波那契子序列的长度](https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/)

开头的情况下怎么样，结尾的情况下怎么样

括号有效配对是指：

- 任何一个左括号都能找到和其正确配对的右括号
- 任何一个右括号都能找到和其正确配对的左括号

返回一个括号字符串中，最长的括号有效子串的长度，返回这个字符串最大能够嵌套几层？
[solution](sample-corresponding/src/test/java/com/pineapple/BracketEffectiveMatchingTest.java)

> 最长递增子序列问题的O(N*logN)的解法,最长递增子序列是指子序列中的严格递增

# LeetCode

|                             题目                              |                                       题解                                        |
|:-----------------------------------------------------------:|:-------------------------------------------------------------------------------:|
|    [46. 全排列](https://leetcode.cn/problems/permutations/)    |    [solution-java](attempt-model/src/main/java/com/pineapple/Permute46.java)    |
| [47. 全排列 II](https://leetcode.cn/problems/permutations-ii/) | [solution-java](attempt-model/src/main/java/com/pineapple/PermuteUnique47.java) |