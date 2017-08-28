package chapter6.knowledgetransfer;

/**
 * 题目：输入一颗二叉树的根结点，判断该树是不是平衡二叉树
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树
 * Created by Administrator on 2017/8/28.
 */
public class BalancedBinaryTree {

    private boolean isBalanced=true;

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


    //主要思路在于后序遍历
    public boolean isBalanced(BinaryTreeNode root){
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(BinaryTreeNode root){
        if(root==null)
            return 0;

        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1)
            isBalanced=false;

        return right>left ? right+1:left+1;
    }

    public static void main(String[] args){
        BinaryTreeNode seven=new BinaryTreeNode(7,null,null);
        BinaryTreeNode six=new BinaryTreeNode(6,null,null);
        BinaryTreeNode five=new BinaryTreeNode(5,seven,null);
        BinaryTreeNode four=new BinaryTreeNode(4,null,null);
        BinaryTreeNode third=new BinaryTreeNode(3,null,six);
        BinaryTreeNode second=new BinaryTreeNode(2,four,five);
        BinaryTreeNode first=new BinaryTreeNode(1,second,third);

        System.out.println(new BalancedBinaryTree().isBalanced(first));
    }//out:true
}
