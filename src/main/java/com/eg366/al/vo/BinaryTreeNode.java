package com.eg366.al.vo;

/**
 * @Author: zhangjunyu
 * @Date: 2020/4/3 14:58
 */
public class BinaryTreeNode {

    private String data;

    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
