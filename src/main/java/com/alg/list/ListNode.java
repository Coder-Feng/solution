package com.alg.list;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 〈链表节点〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
