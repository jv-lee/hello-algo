package test;

public class LeetCodeTest {

    // 206. 反转链表
    private class ReverseList {
        public class ListNode {
            int val;
            ListNode next;
        }

        /**
         * 迭代（双指针）
         * @param head
         * @return
         * 空间复杂度 因为只使用了两个已知空间变量 所以位 O(1)
         * 时间复杂度 因为进行了 n 次操作 所以为 O(n)
         */
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }

        /**
         * 递归
         * @param head
         * @return
         * 空间复杂度 因为递归使用了n 个 ListNode临时变量存储数据所以位 O(n)
         * 时间复杂度 因为递归了n次 所以时间复杂度位 O(n)
         */
        public ListNode reverseList2(ListNode head) {
            return recur(head, null);
        }

        public ListNode recur(ListNode cur, ListNode pre) {
            if (cur == null) return pre;
            ListNode temp = recur(cur.next, cur);
            cur.next = pre;
            return temp;
        }
        
    }
}
