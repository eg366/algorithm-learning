package com.eg366.al.datastructure.tree;

import com.eg366.al.vo.BinaryTreeNode;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历
 *
 * @Author: zhangjunyu
 * @Date: 2020/4/3 14:57
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        BinaryTreeNode rootNode = buildTree();

        preOrder(rootNode);
        System.out.println();
        inOrder(rootNode);
        System.out.println();
        postOrder(rootNode);
        System.out.println();

        print(rootNode);
        levelOrder(rootNode);

        System.out.println();
        levelOrder2(rootNode);

        int height = getTreeHeight(rootNode);
        System.out.println("\r\nheight: " + height);

        int height2 = getTreeHeight2(rootNode);
        System.out.println("\r\nheight2: " + height2);
    }

    /**
     * 非递归方式计算二叉树的高度
     */
    private static int getTreeHeight2(BinaryTreeNode node) {

    }

    /**
     * 递归计算二叉树的高度
     * 递推公式：f(n) = max(f(n.left), f(n.right)) + 1;
     * 终止条件：节点为空
     */
    private static int getTreeHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getTreeHeight(node.getLeft());
        int rightHeight = getTreeHeight(node.getRight());

        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }

    /**
     * 按层遍历，非递归方式
     */
    private static void levelOrder2(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode n = queue.poll();
            print(n);

            if (n.getLeft() != null) {
                queue.offer(n.getLeft());
            }
            if (n.getRight() != null) {
                queue.offer(n.getRight());
            }
        }
    }

    /**
     * 按层遍历
     */
    private static void levelOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

//        print(node);
        print(node.getLeft());
        print(node.getRight());

        levelOrder(node.getLeft());
        levelOrder(node.getRight());
    }

    /**
     * 后续遍历
     */
    private static void postOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        print(node);
    }

    /**
     * 中序遍历
     */
    private static void inOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        print(node);
        inOrder(node.getRight());
    }

    /**
     * 前序遍历
     */
    private static void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        print(node);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    private static void print(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " -> ");
        }
    }

    private static BinaryTreeNode buildTree() {
        BinaryTreeNode nodeA = new BinaryTreeNode("A");
        BinaryTreeNode nodeB = new BinaryTreeNode("B");
        BinaryTreeNode nodeC = new BinaryTreeNode("C");
        BinaryTreeNode nodeD = new BinaryTreeNode("D");
        BinaryTreeNode nodeE = new BinaryTreeNode("E");
        BinaryTreeNode nodeF = new BinaryTreeNode("F");
        BinaryTreeNode nodeG = new BinaryTreeNode("G");

        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);
        nodeC.setLeft(nodeF);
        nodeC.setRight(nodeG);

        return nodeA;
    }
}
