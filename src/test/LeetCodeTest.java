package test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LeetCodeTest {

    /// 链表
    private class LinkedList {
        public class ListNode {
            int val;
            ListNode next;
            public ListNode(int val) {
                this.val = val;
            }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

                ListNode s = head;
                ListNode f = head.next;
                while (s != f) {
                    if (f == null || f.next == null) {
                        return false;
                    }
                    s = s.next;
                    f = f.next.next;
                }
                return true;
            }
        }

        // 21. 合并两个有序链表
        private class MergeTwoList {

            public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
                if (l1 == null) {
                    return l2;
                } else if (l2 == null) {
                    return l1;
                } else if (l1.val < l2.val) {
                    l1.next = mergeTwoList2(l1.next, l2);
                    return l1;
                } else {
                    l2.next = mergeTwoList2(l1, l2.next);
                    return l2;
                }
            }

            /// 迭代法
            /// 时间复杂度 遍历次数为列表1n 列表2m O(n + m)
            /// 空间复杂度 使用了两个变量作为容器 所以为 O(1)
            public ListNode mergeTwoList(ListNode l1, ListNode l2) {
                ListNode prehead = new ListNode(-1); // 作为头节点
                ListNode prev = prehead; // 操作头节点的next ， 最后返回prehead.next就为第一个节点的元素

                // L1 [1,4,5]
                // L2 [1,2,3,6]

                // 解题思路1
                // 1. prev.next = 1(4) l1 = 4(5) prev = 1(4)
                // 2. prev.next = 1(2) l2 = 2(3) prev = 1(2)
                // 3. prev.next = 2(3) l2 = 3(6) prev = 2(3)
                // 4. prev.next = 3(6) l2 = 6(null) prev = 3(6)
                // 5. prev.next = 4(5) l1 = 5(null) prev = 4(5)
                // 6. prev.next = 5(null) l1 = null prev = 5(null)
                // 1 1 2 3 4 5 (null)

                // 解题思路2
                // [1,4,5] [1,2,3,6]
                // -1,1 [4,5] [1,2,3,6]
                // -1,1,1 [4,5] [2,3,6]
                // -1,1,1,2 [4,5] [3,6]
                // -1,1,1,2,3 [4,5] [6]
                // -1,1,1,2,3,4 [5] [6]
                // -1,1,1,2,3,4,5 [null] [6]

                // -1,1,1,2,3,4,5 -> 6

                // 链表1 和 链表2 任意为null则停止
                while (l1 != null && l2 != null) {
                    if (l1.val <= l2.val) {
                        prev.next = l1;
                        l1 = l1.next;
                    } else {
                        prev.next = l2;
                        l2 = l2.next;
                    }
                    // 将next设置自己，下次处理就是自身的next， 再下次就是next.next
                    prev = prev.next;
                }

                // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
                prev.next = l1 == null ? l2 : l1;

                // 返回-1的next，即为后续合并的链表
                return prehead.next;
            }
        }

        /// 876. 链表的中间结点 返回中间节点，如果中间节点为两位返回后一位 
        private class MiddleNode {
            /// 使用快慢指针法
            /// 时间复杂度 因为遍历所有的链表所以为 O(n)
            /// 空间复杂度 因为只使用了两个指针变量为 O(1)
            public ListNode middleNode(ListNode head) {
                // 慢指针移动一位，快指针移动两位， 当快指针指向null时代表慢指针处于中间节点
                // 边界条件 快指针为空或者快指针下一位为空则 停止循环返回慢指针 存在奇树偶数的差异
                // [1,2,3,4,5]
                // [1,2,3,4,5,6]
                ListNode slow = head;
                ListNode fast = head;

                while(fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                return slow;
            }
        }
    
        /// 计算链表长度 
        /// 时间复杂度为 链表的长度n O(n)
        /// 空间复杂度为 三个临时变量 O(1)
        private class RemoveNthFromEnd {

            public ListNode removeNthFromEnd(ListNode head, int n) {
                // 声明临时头节点 
                ListNode tempHead = new ListNode(-1, head);

                ListNode cur = head;
                Deque<ListNode> stack = new LinkedList<ListNode>();
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.next;
                }

                for (int i = 0;i<n;i++) {
                    stack.pop();
                }

                ListNode prev = stack.peek();
                prev.next = prev.next.next;
                return tempHead.next;
            }


            public ListNode removeNthFromEnd2(ListNode head, int n) {
                // 保存头部临时节点
                ListNode tempHead = new ListNode(-1, head);
                // 获取当前链表长度
                int length = getLength(head);

                ListNode cur = head;
                for (int i = 0; i < length - n;i++) {
                    cur = cur.next;
                }

                cur.next = cur.next.next;
                return tempHead.next;
            }

            public int getLength(ListNode head) {
                int length = 0;
                while (head != null) {
                    length++;
                    head = head.next;
                }
                return length;
            }
        }
    }

}
