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

    

}
