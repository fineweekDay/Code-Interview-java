package chapter2.ds;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * Created by Administrator on 2017/8/10.
 */

public class ReconstructBinaryTree {

    public static void main(String[] args){

    }

    public static BinaryTreeNode Construct(int[] preOrder,int[] inOrder,int length){




        return null;
    }
}

class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    public BinaryTreeNode(){

    }
    public BinaryTreeNode(int value){
        this.value = value ;
        this.leftNode = null;
        this.rightNode = null;
    }

}