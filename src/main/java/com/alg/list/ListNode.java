/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: ListNode.java
 * Author:   15041206
 * Date:     2017年3月9日 下午5:18:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.list;

/**
 * 〈一句话功能简述〉<br>
 * 〈链表节点〉
 *
 * @author 15041206
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
