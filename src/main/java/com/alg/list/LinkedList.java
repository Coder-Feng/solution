/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: LinkedList.java
 * Author:   15041206
 * Date:     2017年3月9日 下午5:18:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.list;

/**
 * 〈一句话功能简述〉<br>
 * 〈链表〉
 *
 * @author 15041206
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
