/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: BTree.java
 * Author:   coder_feng
 * Date:     2017年4月18日 下午5:30:37
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.ds.tree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二叉树〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BTree<T extends Comparable<T>> {
    private BNode<T> root;

    public BTree(List<T> values) {
        root = buildBTreeRoot(values);
    }

    /**
     * 
     * 功能描述: <br>
     * 控制台打印树
     * @throws IOException 
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void printGraphicTree() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos, "utf-8");
        root.printTree(osw);
        osw.flush();
        System.out.println(new String(bos.toByteArray()));
    }

    /**
     * 
     * 功能描述: <br>
     * 值是否存在
     *
     * @param value
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean exists(T value) {
        return null != search(root, value);
    }

    /**
     * 
     * 功能描述: <br>
     * 新增数据
     *
     * @param value
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void insert(T value) {
        this.attachToDownestNode(root, this.buildBTNode(value));
    }

    public boolean delete(T value) {
        BNode<T> delNode = this.search(root, value);
        if (null != delNode) {
            if (null == delNode.getLeft() && null != delNode.getRight()) {
                this.transplant(delNode, delNode.getRight());
            } else if (null != delNode.getLeft() && null == delNode.getRight()) {
                this.transplant(delNode, delNode.getLeft());
            } else {
                // minNode是没有左子树的
                BNode<T> minNode = this.min(delNode.getRight());
                if (minNode.getParent() != delNode) {
                    transplant(minNode, minNode.getRight());
                    minNode.setRight(delNode.getRight());
                    minNode.getRight().setParent(minNode);
                }
                transplant(delNode, minNode);
                if (null != minNode) {
                    minNode.setLeft(delNode.getLeft());
                    minNode.getLeft().setParent(delNode);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 〈找出所有 大于 node的节点中值最小的那个节点〉
     *
     * @param node
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private BNode<T> successor(BNode<T> node) {
        BNode<T> pNode = node;
        if (null != pNode.getRight()) {
            return this.min(pNode.getRight());
        }
        BNode<T> parent = pNode.getParent();
        while (null != parent && pNode == parent.getRight()) {
            pNode = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    /**
     * 
     * 功能描述: <br>
     * 求最小值
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public T min() {
        BNode<T> minNode = this.min(root);
        return null != minNode ? minNode.getValue() : null;
    }

    /**
     * 
     * 功能描述: <br>
     * 最小值
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public BNode<T> min(BNode<T> node) {
        if (null != node) {
            BNode<T> min = node;
            while (null != min.getLeft()) {
                min = min.getLeft();
            }
            return min;
        }
        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 最大值
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public T max() {
        if (null != root) {
            BNode<T> max = root;
            while (null != max.getRight()) {
                max = max.getRight();
            }
            return max.getValue();
        }
        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 中序遍历
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<T> inorderTreeWalk() {
        List<T> result = new ArrayList<T>();
        inorderTreeWalk(root, result);
        return result;
    }

    /**
     * 
     * 功能描述: <br>
     * 深度
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int height() {
        return height(root);
    }

    public void transplant(BNode<T> oldNode, BNode<T> newNode) {
        if (oldNode.getParent() == null) {
            this.root = newNode;
        } else if (oldNode == oldNode.getParent().getLeft()) {
            oldNode.getParent().setLeft(newNode);
        } else {
            oldNode.getParent().setRight(newNode);
        }
        if (newNode != null) {
            newNode.setParent(oldNode.getParent());
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 根节点的深度，Max（左节点，右节点）+1
     *
     * @param root
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private int height(BNode<T> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    private void inorderTreeWalk(BNode<T> root, List<T> result) {
        if (null != root) {
            inorderTreeWalk(root.getLeft(), result);
            result.add(root.getValue());
            inorderTreeWalk(root.getRight(), result);
        }
    }

    private BNode<T> search(BNode<T> root, T value) {
        if (null != root) {
            if (root.getValue().compareTo(value) == 0) {
                return root;
            } else if (root.getValue().compareTo(value) > 0) {
                return search(root.getLeft(), value);
            } else {
                return search(root.getRight(), value);
            }
        } else {
            return root;
        }
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param values
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private BNode<T> buildBTreeRoot(List<T> values) {
        BNode<T> root = null;
        for (T value : values) {
            BNode<T> newNode = this.buildBTNode(value);
            if (root == null) {
                root = newNode;
            } else {
                attachToDownestNode(root, newNode);
            }
        }
        return root;
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param root2
     * @param newNode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void attachToDownestNode(BNode<T> root, BNode<T> newNode) {
        BNode<T> downestNode = root;
        while (true) {
            if (downestNode.compareTo(newNode) >= 0) {
                if (downestNode.getLeft() == null) {
                    downestNode.setLeft(newNode);
                    newNode.setParent(downestNode);
                    break;
                } else {
                    downestNode = downestNode.getLeft();
                }
            } else {
                if (downestNode.getRight() == null) {
                    downestNode.setRight(newNode);
                    newNode.setParent(downestNode);
                    break;
                } else {
                    downestNode = downestNode.getRight();
                }
            }
        }
    }

    private BNode<T> buildBTNode(T value) {
        return new BNode<T>(value);
    }

}
