/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: BNode.java
 * Author:   coder_feng
 * Date:     2017年4月19日 上午9:46:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.ds.tree;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BNode<T extends Comparable<T>> implements Comparable<BNode<T>> {
    private BNode<T> left;
    private BNode<T> right;
    private BNode<T> parent;
    private T value;

    public BNode(T value) {
        this.value = value;
    }

    public BNode<T> getLeft() {
        return left;
    }

    public void setLeft(BNode<T> left) {
        this.left = left;
    }

    public BNode<T> getRight() {
        return right;
    }

    public void setRight(BNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(BNode<T> o) {
        return this.value.compareTo(o.getValue());
    }

    public BNode<T> getParent() {
        return parent;
    }

    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BNode [left=");
        builder.append(left);
        builder.append("], value=");
        builder.append(value);
        builder.append(", right=[");
        builder.append(right);
        builder.append("]");
        return builder.toString();
    }

    public void printTree(OutputStreamWriter out) throws IOException {
        if (right != null) {
            right.printTree(out, true, "");
        }
        printNodeValue(out);
        if (left != null) {
            left.printTree(out, false, "");
        }
    }

    private void printNodeValue(OutputStreamWriter out) throws IOException {
        if (value == null) {
            out.write("<null>");
        } else {
            out.write(value.toString());
        }
        out.write('\n');
    }

    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(OutputStreamWriter out, boolean isRight, String indent) throws IOException {
        if (right != null) {
            right.printTree(out, true, indent + (isRight ? "        " : " |      "));
        }
        out.write(indent);
        if (isRight) {
            out.write(" /");
        } else {
            out.write(" \\");
        }
        out.write("----- ");
        printNodeValue(out);
        if (left != null) {
            left.printTree(out, false, indent + (isRight ? " |      " : "        "));
        }
    }
}
