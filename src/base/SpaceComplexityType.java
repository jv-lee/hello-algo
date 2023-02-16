package base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 空间复杂度类型
 * 统计 算法使用内存空间随着数据量变大时的增长趋势。这个概念与时间复杂度很类似。
 */
public class SpaceComplexityType {

    private class ListNode {
        public int size;

        ListNode(int size) {
            this.size = size;
        }
    }

    private class TreeNode {
        public int index;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int index) {
            this.index = index;
        }
    }

    /**
     * 常数阶 O(1)
     * 常数阶常见于数量与输入数据大小n无关的常量、变量、对象。
     * 需要注意的是，在循环过程中初始化变量或调用函数而占用的内存，在进入下一循环后就会被释放，既不会累积占用空间，空间复杂度仍然为O(1)。
     * 
     * @param n
     */
    public void constant(int n) {
        // 常量、变量、对象占用 O(1) 空间
        final int a = 0;
        int b = 0;
        int[] nums = new int[10000];
        ListNode node = new ListNode(0);

        // 循环中的变量占用O(1)空间
        for (int i = 0; i < n; i++) {
            int c = 0;
        }
        // 循环中的函数占用O(1)空间
        for (int i = 0; i < n; i++) {
            // function();
        }
    }

    /**
     * 线性阶 O(n)
     * 线性阶常见于元素数量与n成正比的数组、链表、栈、队列等。
     * 
     * @param n
     */
    public void linear(int n) {
        // 长度为 n 的数组占用 O(n) 空间
        int[] nums = new int[n];

        // 长度为 n 的列表占用 O(n) 空间
        List<ListNode> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ListNode(i));
        }

        // 长度为 n 的哈希表占用 O(n) 空间
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, String.valueOf(i));
        }
    }

    /**
     * 线性阶 O(n) - 循环实现
     * 
     * @param n
     */
    public void linearRecur(int n) {
        System.out.println("递归 n = " + n);
        if (n == 1)
            return;
        linearRecur(n - 1);
    }

    /**
     * 平方阶 O(n²)
     * 平方阶常见于元素数量与 n 成平方关系的矩阵、图。
     * 
     * @param n
     */
    public void quadratic(int n) {
        // 矩阵占用 O(n^2) 空间
        int[][] numMatrix = new int[n][n];
        // 二维列表占用 O(n^2) 空间
        List<List<Integer>> numList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(0);
            }
            numList.add(temp);
        }
    }

    /**
     * 平方阶 O(n²) - 递归实现
     * 
     * @param n
     */
    public int quadraticRecur(int n) {
        if (n < 0)
            return 0;
        // 数组 nums 长度为 n,n-1,...,2,1
        int[] nums = new int[n];
        System.out.println("递归 n = " + n + " 中的 nums 长度 = " + nums.length);
        return quadraticRecur(n - 1);
    }

    /**
     * 指数阶 O(2n)
     * 指数阶常见于二叉树。高度为 n 的「满二叉树」的结点数量为 2n - 1 ，使用 O(2n) 空间。
     * 
     * @param n
     * @return
     */
    public TreeNode buildTree(int n) {
        if (n == 0)
            return null;
        TreeNode root = new TreeNode(0);
        root.left = buildTree(n - 1);
        root.right = buildTree(n - 1);
        return root;
    }

    /**
     * 对数阶 O(log n)
     * 对数阶常见于分治算法、数据类型转换等。
     * 例如「归并排序」，长度为 n 的数组可以形成高度为 log n 的递归树，因此空间复杂度为 O(log n) 。
     */
    public void logarithmic() {
    }

}
