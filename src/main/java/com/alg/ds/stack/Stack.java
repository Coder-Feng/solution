/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: Stack.java
 * Author:   coder_feng
 * Date:     2017年4月10日 下午4:58:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.ds.stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈栈〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Stack {

    private int top = 0;

    private int size;
    private Object[] objs;

    public Stack(int size) {
        objs = new Object[size];
        this.size = size;
    }

    /**
     * 
     * 功能描述: <br>
     * 堆栈是否是空
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean isEmpty() {
        return top == 0;
    }

    /**
     * 
     * 功能描述: <br>
     * 入栈
     *
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void push(Object obj) {
        if (top < size - 1) {
            objs[top++] = obj;
        } else {
            throw new RuntimeException("underflow");
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 出栈
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Object pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            Object obj = objs[top];
            objs[top] = null;
            top--;
            return obj;
        }

    }
}
