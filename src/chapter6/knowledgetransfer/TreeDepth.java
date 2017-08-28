package chapter6.knowledgetransfer;

/**
 * 题目：二叉树的深度
 * 输入一颗二叉树的根结点，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 * Created by Administrator on 2017/8/28.
 */
public class TreeDepth {

    private static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static int GetTreeDepth(BinaryTreeNode root){
        if(root==null)
            return 0;

        int left=GetTreeDepth(root.left);
        int right=GetTreeDepth(root.right);

        return (left>right) ? left+1 : right+1;
    }

    public static void main(String[] args){
        BinaryTreeNode seven=new BinaryTreeNode(7,null,null);
        BinaryTreeNode six=new BinaryTreeNode(6,null,null);
        BinaryTreeNode five=new BinaryTreeNode(5,seven,null);
        BinaryTreeNode four=new BinaryTreeNode(4,null,null);
        BinaryTreeNode third=new BinaryTreeNode(3,null,six);
        BinaryTreeNode second=new BinaryTreeNode(2,four,five);
        BinaryTreeNode first=new BinaryTreeNode(1,second,third);

        System.out.println(GetTreeDepth(first));
    }//out:4
}
