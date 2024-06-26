package practise;

import data.ListNode;

public class LinkedList {

    /**
     * 206. 反转链表
     * 使用交换法
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 141. 环形链表
     * 使用快慢指针法
     * 时间复杂度O(n) 链表的长度
     * 空间复杂度O(1) 使用两个指针变量
     */
    public boolean hasCycle(ListNode head) {
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

    /**
     * 21. 合并两个有序链表
     * 使用链表大小比较法
     * 时间复杂度O(n + m) 两个链表的长度
     * 空间复杂度O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temphead = new ListNode(-1);
        ListNode cur = temphead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return temphead.next;
    }

    /**
     * 876. 链表的中间结点
     * 使用双指针法
     * 时间复杂度O(n) 链表的长度
     * 空间复杂度O(1) 两个指针变量
     */
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 使用长度比较法
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        ListNode temphead = new ListNode(-1, head);
        ListNode cur = temphead;
        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return temphead.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 61. 旋转链表
     * 使用合并成环打断法
     * 时间复杂度O(n) 最坏情况下需要遍历链表2次
     * 空间复杂度O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        cur.next = head;

        int move = n - k % n;
        while (move-- > 0) {
            cur = cur.next;
        }
        ListNode result = cur.next;
        cur.next = null;
        return result;
    }

}