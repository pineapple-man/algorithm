## Problem Set

[942. 增减字符串匹配](https://leetcode.cn/problems/di-string-match/)

[1217. 玩筹码](https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/)

> 有 n个机器人从左到右一字排开，上方有一个自动装置会抓取一批物品到每个打包机上，
> 放到每个机器上的这些物品数量有多有少，由于物品数量不相同，需要工人将每个机器上的物品进行移动从而
> 达到数量相等的才能打包。每个物品重量太大、每次只能搬一个物品进行移动，为了省力，
> 只在相邻的机器上移动。请计算在搬动最小轮数的前提下，使每个机器上的物品数量相等。
> 如果不能使每个机器上的物品相同，返回 -1。 例如 [1,0,5]表示有3个机器，每个机器上分别有1，0，5
> 个物品，经过这些轮后：
>
> 第一轮： 1 0 <- 5 >= 1 1 4
>
> 第二轮: 1 <= 1 <= 4 => 2 1 3
>
> 第三轮 2 1 <= 3 => 2 2 2
>
> 移动了3轮，每个机器上的物品相等，所以返回3，例如[2,2,3]表示3个机器，每个机器上分别有2、2、3个
> 物品，这些物品不管怎么移动，都不能使三个机器上物品数量相同，返回
> -1。
> [Solution-java]()

> 给定一个数组 arr 长度为 N，你可以把任意长度大于0且小于N的前缀作为左部分，剩下的作为右部分。
> 但是每种划分下都有左部分的最大值和右部分的最大值，请返回最大的，
> 左部分最大值减去右部分最大值的绝对值。
> [Solution-java](src/main/java/P2.java)

> 给定一个数组 arr,代表每个人的能力值。再给定一个非负数
> k。如果两个人能力差值正好为k，那么可以凑在一起比赛。一局比赛只有两个人，
> 请返回最多可以同时有多少场比赛。
> [solution-java](src/test/java/P3Test.java)