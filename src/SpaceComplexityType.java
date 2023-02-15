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

    /**
     * 常数阶 - O(1)
     * 常数阶常见于数量与输入数据大小n无关的常量、变量、对象。
     * 需要注意的是，在循环过程中初始化变量或调用函数而占用的内存，在进入下一循环后就会被释放，既不会累积占用空间，空间复杂度仍然为O(1)。
     * 
     * @param n
     */
    public void constant(int n) {
        // 常量、变量、对象占用空间O(1)空间
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

}
