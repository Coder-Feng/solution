/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: BTreeTest.java
 * Author:   coder_feng
 * Date:     2017年4月19日 上午10:05:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.alg.ds.tree.BTree;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BTreeTest {

    @Test
    public void testBTree() throws IOException {
        List<Integer> values = Arrays.asList(100, 3, 1, 7, 2, 3, 5, 9, 22, 5, 652, 12, 5);
        BTree<Integer> tree = new BTree<Integer>(values);
        tree.printGraphicTree();
//        System.out.println("中序遍历:" + tree.inorderTreeWalk());
//        System.out.println("树的高度:" + tree.height());
//        System.out.println("652是否存在:" + tree.exists(652));
//        System.out.println("653是否存在:" + tree.exists(653));
//        System.out.println("最小值:" + tree.min());
//        System.out.println("最大值:" + tree.max());
//        System.out.println("删除数字7:" + tree.delete(7));
//        System.out.println("中序遍历:" + tree.inorderTreeWalk());
//        tree.insert(10);
//        System.out.println("中序遍历:" + tree.inorderTreeWalk());
    }
}
