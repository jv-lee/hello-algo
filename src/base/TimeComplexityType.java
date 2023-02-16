package base;
/**
 * 时间复杂度类型
 */
public class TimeComplexityType {
    /**
     * 常数阶 O(1)
     * 常数阶的操作数量与输入数据大小n无关，即不随着n的变化而变化。
     * 对于以下算法，无论操作数量size有多大，只要与数据大小n无关，时间复杂度就仍为O(1)
     * @param n
     * @return
     */
    public int constant(int n) {
        int count = 0;
        int size = 1000;
        for(int i = 0; i < size; i++) {
            count++;
        }
        return count;
    }

    /**
     * 线性阶 O(n)
     * 线性阶的操作数量相对输入数据大小成线性级别增长。线性阶常出现于单层循环
     * @param n
     * @return
     */
    public int linear(int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            count++;
        }
        return count;
    }

    /**
     * 线性阶-遍历数组 O(n)
     * 「遍历数组」和「遍历链表」等操作，时间复杂度都为  ，其中为数组或链表的长度。
     * @param nums
     * @return
     */
    public int linearArrayTraversal(int[] nums) {
        int count = 0;
        // 循环次数与数组长度成正比
        for(int i = 0; i < nums.length; i++) {
            count++;
        }
        return count;
    }

    /**
     * 平方阶 O(n²)
     * 平方阶的操作数量相对输入数据大小成平方级别增长。平方阶常出现于嵌套循环，外层循环和内层循环都为O(n)，总体为O(n²)。
     * @param n
     * @return
     */
    public int quadratic(int n) {
        int count = 0;
        // 循环次数与数组长度成平方关系
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                count++;
            }
        }
        return count;
    }

    /**
     * 平方阶-冒泡排序 O(n²)
     * 以冒泡排序为例，外层循环n-1次，内层循环n-1，n-2，n-3，...，2，1次，平均为n/2次，因此时间复杂度为O(n²)
     * @param nums
     * @return
     */
    public int quadraticBubbleSort(int[] nums) {
        int count = 0; // 计数器
        // 外循环：待排序元素数量为 n-1，n-2，..，1
        for(int i = nums.length - 1 ;i > 0; i--) {
            // 内循环：冒泡操作
            for(int j = 0; j < i; j++) {
                if(nums[j] > nums[j + 1]) {
                    // 交换nums[j] 与 nums[j + 1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    count += 3; // 元素交换包含 3 个单元操作
                }
            }
        }
        return count;
    }

    /**
     * 指数阶-循环实现 O(2ⁿ)
     * note1: 生物学科中的“细胞分裂”既是指数阶增长：初始状态为1个细胞，分裂一轮后为2个细胞，分裂两轮后为4个，...，分裂n轮后有2ⁿ
     * note2: 指数阶增长得非常快，在实际应用中一般是不能被接受的。若一个问题使用「暴力枚举」求解的时间复杂度是O(2ⁿ)，那么一般都需要使用「动态规划」或「贪心算法」等算法来求解。
     * @param n
     * @return
     */
    public int exponential(int n) {
        int count = 0, base = 1;
        // cell 每轮一分为二，形成数列 1，2，4，8，...，2^(n-1)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < base; j++) {
                count++;
            }
            base *= 2;
        }
        // count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
        return count;
    }

    /**
     * 指数阶-递归实现 O(2ⁿ)
     * 在实际算法中，指数阶常出现于递归函数。例如以下代码，不断地一分为二，分裂n次后停止。
     * @param n
     * @return
     */
    public int expRecur(int n) {
        if (n == 1) return 1;
        return expRecur(n - 1) + expRecur(n - 1) + 1;
    }

    /**
     * 对数阶-循环实现 O(logn)
     * 对数阶与指数阶正好相反，后者反映“每轮增加到两倍的情况”，而前者反映“每轮缩减到一半的情况”。对数阶仅次于常数阶，时间增长得很慢，是理想的时间复杂度。
     * 对数阶常出现于「二分查找」和「分治算法」中，体现“一分为多”、“化繁为简”的算法思想。
     * 设输入数据大小为n，由于每轮缩减到一半，因此循环次数是log2n，即2ⁿ的反函数。
     * @param n
     * @return
     */
    public int logarithmic(float n) {
        int count = 0;
        while(n > 1) {
            n = n / 2;
            count++;
        }
        return count;
    }

    /**
     * 对数阶-递归实现 O(logn)
     * 与指数阶类似，对数阶也常出现于递归函数。以下代码形成了一个高度为log2n的递归树。
     * @param n
     * @return
     */
    public int logRecur(float n) {
        if (n <= 1) return 0;
        return logRecur(n / 2) + 1;
    }

    /**
     * 线性对数阶 O(nlogn)
     * 线性对数阶常出现于嵌套循环中，两层循环的时间复杂度分别为O(logn)和O(n)。
     * 主流排序算法的时间复杂度都是O(nlogn)，例如快速排序、归并排序、堆排序等。
     * @param n
     * @return
     */
    public int linearLogRecur(float n) {
        if(n <= 1) return 1;
        int count = linearLogRecur(n / 2) + linearLogRecur(n / 2);
        for(int i = 0; i < n; i++) {
            count ++;
        }
        return count;
    }

    /**
     * 阶乘阶-递归实现 O(n!)
     * 阶乘阶对应数学上的「全排列」。即给定n个互不重复的元素，求其所有可能的排列方案，则方案数量为 n! = n x (n - 1) x (n - 2) x ... x 2 x 1
     * 阶乘常使用递归实现。例如以下代码，第一层分裂出n个，第二层分裂出n-1个，…… ，直至到第n层时终止分裂。
     * @param n
     * @return
     */
    public int factorialRecur(int n) {
        if (n == 0) return 1;
        int count = 0;
        // 从1个分裂出n个
        for(int i = 0; i < n; i++) {
            count += factorialRecur(n - 1);
        }
        return count;
    }

}
