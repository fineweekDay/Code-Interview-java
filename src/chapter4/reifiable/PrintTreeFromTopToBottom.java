package chapter4.reifiable;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：从上往下打印二叉树
 * 同一层按照从左到右打印
 * Created by Administrator on 2017/8/13.
 */
public class PrintTreeFromTopToBottom {

    static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val,BinaryTreeNode left,BinaryTreeNode right){
            this.value=val;
            this.left=left;
            this.right=right;
        }
    }

    public static void print(BinaryTreeNode root){
        if(root==null)
            return;
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        print(queue);
    }

    private static void print(Queue<BinaryTreeNode> queue){
        if(queue.isEmpty())
            return;

        BinaryTreeNode root=queue.poll();
        System.out.print(root.value+" ");

        if(root.left!=null)
            queue.add(root.left);
        if(root.right!=null)
            queue.add(root.right);

        print(queue);
    }

    public static void main(String[] args){
        BinaryTreeNode seven=new BinaryTreeNode(11,null,null);
        BinaryTreeNode six=new BinaryTreeNode(9,null,null);
        BinaryTreeNode five=new BinaryTreeNode(7,null,null);
        BinaryTreeNode four=new BinaryTreeNode(5,null,null);
        BinaryTreeNode three=new BinaryTreeNode(10,six,seven);
        BinaryTreeNode two=new BinaryTreeNode(6,four,five);
        BinaryTreeNode root=new BinaryTreeNode(8,two,three);

        print(root);
    }//out:8 6 10 5 7 9 11
}
