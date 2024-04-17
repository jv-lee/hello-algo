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
    

}