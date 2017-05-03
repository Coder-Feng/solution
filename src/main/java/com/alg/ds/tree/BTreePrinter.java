/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: BTreePrinter.java
 * Author:   coder_feng
 * Date:     2017年4月20日 下午5:27:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BTreePrinter {

    public static <T extends Comparable<?>> void printBNode(BNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printBNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printBNodeInternal(List<BNode> BNodes, int level, int maxLevel) {
        if (BNodes.isEmpty() || BTreePrinter.isAllElementsNull(BNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<BNode> newBNodes = new ArrayList<BNode>();
        for (BNode BNode : BNodes) {
            if (BNode != null) {
                System.out.print(BNode.getValue());
                newBNodes.add(BNode.getLeft());
                newBNodes.add(BNode.getRight());
            } else {
                newBNodes.add(null);
                newBNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < BNodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (BNodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (BNodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (BNodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printBNodeInternal(newBNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BNode BNode) {
        if (BNode == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(BNode.getLeft()), BTreePrinter.maxLevel(BNode.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
