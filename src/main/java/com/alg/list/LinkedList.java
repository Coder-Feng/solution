package com.alg.list;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 链表
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LinkedList {
    /**
     * 
     * 功能描述: <br>
     * 链表反转
     *
     * @param head
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static ListNode reverse(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            ListNode next = head.getNext();
            head.setNext(reversed);
            reversed = head;
            head = next;
        }
        return reversed;
    }
}
