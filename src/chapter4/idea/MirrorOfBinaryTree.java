package chapter4.idea;

/**
 * 题目：输入一个二叉树，输出它的镜像
 * Created by Administrator on 2017/8/12.
 */
public class MirrorOfBinaryTree {

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

    //递归实现
    public static void Mirror(BinaryTreeNode root){
        if(root==null || (root.left==null && root.right==null))
            return;

        BinaryTreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        if(root.left!=null)
            Mirror(root.left);
        if(root.right!=null)
            Mirror(root.right);
    }

    //按前序遍历来实现直观上的输出
    public static void print(BinaryTreeNode root){
        if(root==null)
            return;
        else
            System.out.print(root.value+" ");

        if(root.left!=null)
            print(root.left);
        if(root.right!=null)
            print(root.right);
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
        System.out.println();//out:8 6 5 7 10 9 11

        System.out.println("*******************");

        Mirror(root);
        print(root);//out:8 10 11 9 6 7 5
        System.out.println();
    }
}
