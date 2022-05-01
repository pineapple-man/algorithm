## 递归

学习递归的时候，培养一种黑盒思维，仅考虑一个函数的含义，接受什么输入，达到什么效果，最终输出什么，base case 规定好。最终问题就转变成如何使用这个黑盒的问题了。 常见的递归模型

先来几道简单的递归类型题目：

1. 打印 n 层汉诺塔从最左边移动到最右边的全部过程。

[solution-java](attempt-model/src/main/java/com/pineapple/Hanoi.java)、[solution-Golang]()、

2. 打印一个字符串的全部子序列

[solution-java](attempt-model/src/main/java/com/pineapple/SubsequencesSolution.java)、[solution-Golang]()、

3. 打印一个字符串的全部子序列，要求不要出现重复字面值的子序列

[solution-java](attempt-model/src/main/java/com/pineapple/SubsequencesSolution.java)、[solution-Golang]()、

4. 打印一个字符串的全部排列

[solution-java](attempt-model/src/main/java/com/pineapple/PermutationsSolutions.java)、[solution-Golang]()、

5. 打印一个字符串的全部排列，要求不要出现重复的排列

[solution-java](attempt-model/src/main/java/com/pineapple/PermutationsSolutions.java)、[solution-Golang]()、

6. 给你一个栈，请你逆序这个栈。要求：不能申请额外的数据结构，只能使用递归函数。

[solution-java](attempt-model/src/main/java/com/pineapple/ReverseStackSolution.java)、[solution-Golang]()、

## 动态规划

什么是动态规划？
> 动态规划就是一种空间换取时间的算法模式。例如，在求解某个问题时，总是存在当前问题依赖于一些重复计算的子问题，那么继续求解当前问题时，就可以直接使用已经解决了子问题的答案，进而解决当前问题。这样一种算法模式，就可以理解为动态规划。

## 从左向右尝试模型

1. 假设有排成一行的 N 个位置，记为 1～N，N 一定大于或等于2。 开始时机器人在其中的 M 位置上（M 一定是 1～N 中的一个）。如果机器人来到 1 位置，那么下一步只能往右来到 2 位置；如果机器人来到 N
   位置，那么下一步只能往左来到 N-1 位置；如果机器人来到中间位置，那么下一步可以往左或者往右走。规定机器人必须走 K 步，最终能来到 P 位置（ P 也是 1 ～ N 中的一个）的方法有多少中？

[solution-java](attempt-model/src/main/java/com/pineapple/RobotWalkSolution.java)、[solution-Golang]()、

3. 背包问题

[solution-java]()、[solution-Golang]()、

4. 有下面一张转换表(1->a,2->b,...,26->z),那么一个数字字符串，比如：111，就可以转化为AAA, KA 和 AK，给定一个只有数字字符组成的字符串 string,返回有多少种转化结果

[solution-java]()、[solution-Golang]()、

5. 给定一个字符串 str ,给定一个字符串类型的数组 arr,出现的字符都是小写英文。arr 每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出 str 来。返回需要至少多少张贴纸可以完成任务。 例如： str = "
   babac" arr = {"ba","c","abcd"}，至少需要两张贴纸"ba"和"abcd",因为使用这两张贴纸，把每一个字符单独剪开，含有2个a，2个b、1个c。是可以拼出str的。所以返回2。
   [力扣链接](https://leetcode.cn/problems/stickers-to-spell-word/)

[solution-java]()、[solution-Golang]()、

给定一个字符串 str ，返回这个字符串的最长回文子序列。比如：str="a12b3c43def2ghi1kpm"最长回文子序列是"1234321"或者"123c321"，返回长度7

## 范围尝试模型

1. 给定一个整型数组 arr, 代表数值不同的纸牌排成一条线。玩家 A 和玩家 B 依次拿走每张纸牌。规定玩家 A 先拿，玩家 B 后拿。但是每个玩家每次只能拿走最左或最右的纸牌。假设玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。

[solution-java](attempt-model/src/main/java/com/pineapple/PlayPoker.java)、[solution-Golang]()、

## 样本对应模型

以结尾位置来组织可能性

1. 最长公共子序列问题[力扣链接](https://leetcode.cn/problems/longest-common-subsequence/)

## 业务限制模型
