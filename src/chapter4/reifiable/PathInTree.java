package chapter4.reifiable;

import java.util.Arrays;
import java.util.Stack;

/**
 * 题目：二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * Created by Administrator on 2017/8/13.
 */
public class PathInTree {

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

    public static void findPath(BinaryTreeNode root,int expect){
        if(root==null)
            return;

        Stack<Integer> path=new Stack<>();
        int currentSum=0;
        findPath(root,expect,path,currentSum);
    }

    private static void findPath(BinaryTreeNode root,int expect,Stack<Integer> path,int currentSum){
        currentSum+=root.value;
        path.push(root.value);

//        if(currentSum>expect)
//            return;//当所有节点值都是正整数时可以进行小优化
//        else
//            path.push(root.value);

        if(isLeaf(root) && currentSum==expect)
            System.out.println(Arrays.toString(path.toArray()));
        else{
            if(root.left!=null)
                findPath(root.left,expect,path,currentSum);
            if(root.right!=null)
                findPath(root.right,expect,path,currentSum);
        }

        path.pop();
    }

    private static boolean isLeaf(BinaryTreeNode treeNode){
        if(treeNode==null)
            throw new RuntimeException();

        if(treeNode.left!=null || treeNode.right!=null)
            return false;

        return true;
    }

    public static void main(String[] args){
        BinaryTreeNode five=new BinaryTreeNode(7,null,null);
        BinaryTreeNode four=new BinaryTreeNode(4,null,null);
        BinaryTreeNode three=new BinaryTreeNode(12,null,null);
        BinaryTreeNode two=new BinaryTreeNode(5,four,five);
        BinaryTreeNode root=new BinaryTreeNode(10,two,three);

        findPath(root,22);
    }//out:[10,5,7]  [10,12]
}
