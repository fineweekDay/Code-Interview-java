package chapter4.simplify;

/**
 * 题目：二叉搜索树与双向链表
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 要求：不能创建任何新节点，只能调整树中节点指针的指向
 * Created by Administrator on 2017/8/13.
 */
public class ConvertBinarySearchTree {

    static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(){

        }

        BinaryTreeNode(int val,BinaryTreeNode left,BinaryTreeNode right){
            this.value=val;
            this.left=left;
            this.right=right;
        }
    }//考虑到双向链表，也可以把left当成pre，把right当成next

    //实现的基础是中序遍历，因为中序遍历的结果就是节点从小到大的排列
    public static BinaryTreeNode Convert(BinaryTreeNode root){
        BinaryTreeNode last=ConvertNode(root,null);//此时已经实现了双向排序，只不过指针指向尾节点

        while(last != null && last.left != null){
            last=last.left;
        }

        return last;
    }

    private static BinaryTreeNode ConvertNode(BinaryTreeNode root, BinaryTreeNode lastNode) {
        if(root == null)
            return null;

        BinaryTreeNode current = root;
        if(current.left != null)
            lastNode=ConvertNode(current.left,lastNode);

        current.left = lastNode;
        if(lastNode != null)
            lastNode.right = current;

        lastNode=current;

        if(current.right != null)
            lastNode=ConvertNode(current.right,lastNode);

        return lastNode;
    }


    public static void main(String[] args){
        BinaryTreeNode seven=new BinaryTreeNode(16,null,null);
        BinaryTreeNode six=new BinaryTreeNode(12,null,null);
        BinaryTreeNode five=new BinaryTreeNode(8,null,null);
        BinaryTreeNode four=new BinaryTreeNode(4,null,null);
        BinaryTreeNode three=new BinaryTreeNode(14,six,seven);
        BinaryTreeNode two=new BinaryTreeNode(6,four,five);
        BinaryTreeNode root=new BinaryTreeNode(10,two,three);

        BinaryTreeNode node=Convert(root);

        while(node!=null){
            System.out.println("node.value=" + node.value);
            node=node.right;
        }
    }
}
