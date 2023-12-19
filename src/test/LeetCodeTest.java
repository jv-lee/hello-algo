package test;

import java.util.HashSet;
import java.util.Set;

public class LeetCodeTest {

    /// 链表
    private class LinkedList {
        public class ListNode {
            int val;
            ListNode next;
        }

        // 206. 反转链表
        private class ReverseList {

            public class ListNode {
                int val;
                ListNode next;
            }

            /**
             * 迭代（双指针）
             * 
             * @param head
             * @return
             *         空间复杂度 因为只使用了两个已知空间变量 所以位 O(1)
             *         时间复杂度 因为进行了 n 次操作 所以为 O(n)
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
             * 
             * @param head
             * @return
             *         空间复杂度 因为递归使用了n 个 ListNode临时变量存储数据所以位 O(n)
             *         时间复杂度 因为递归了n次 所以时间复杂度位 O(n)
             */
            public ListNode reverseList2(ListNode head) {
                return recur(head, null);
            }

            public ListNode recur(ListNode cur, ListNode pre) {
                if (cur == null)
                    return pre;
                ListNode temp = recur(cur.next, cur);
                cur.next = pre;
                return temp;
            }

        }

        // 141. 环形链表
        private class CycleList {

            /// 哈希表
            /// 空间复杂度为 O(n) 因为HashSet可能会使用n个空间来保存链表数据
            /// 时间复杂度为 O(n) 因为循环可以会遍历每一个节点一次
            public boolean hasCycle(ListNode head) {
                ListNode cur = head;
                Set set = new HashSet<>();
                while (cur != null) {
                    if (!set.add(head)) {
                        return true;
                    }
                    cur = cur.next;
                }

                return false;
            }

            // 快慢指针（龟兔赛跑法（慢指针一次移动一位，快指针一次移动两位））
            // 空间复杂度为 O(1) 因为只使用了两个指针变量
            // 时间复杂度为 O(n) 因为循环可以会遍历每一个节点一次
            public boolean hasCycle2(ListNode head) {
                if (head == null || head.next == null) {
                    return false;
                }

                ListNode f = head;
                ListNode s = head.next;

                while(f != null || s != null) {
                    if (f == s) {
                        return true;
                    }
                    f = f.next;
                    s = s.next.next;
                }
                return true;
            }
        }

    }

}
