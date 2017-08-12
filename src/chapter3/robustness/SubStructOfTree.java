package chapter3.robustness;

/**
 * 题目：树的子结构
 * 输入两颗二叉树A,B，判断B是不是A的子结构
 * Created by Administrator on 2017/8/12.
 */
public class SubStructOfTree {

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

    public static boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;

        boolean result=false;

        if(root1!=null && root2!=null) {
            if(root1.value==root2.value)
                result = DoesTree1HasTree2(root1, root2);
            if (!result)
                result = hasSubTree(root1.left, root2);
            if (!result)
                result = hasSubTree(root1.right, root2);
        }

        return result;
    }

    private static boolean DoesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root2==null)
            return true;
        if(root1==null)
            return true;
        if(root1.value!=root2.value)
            return false;

        return DoesTree1HasTree2(root1.left,root2.left) && DoesTree1HasTree2(root1.right,root2.right);
    }

    public static void main(String[] args){
        BinaryTreeNode seven=new BinaryTreeNode(7,null,null);
        BinaryTreeNode six=new BinaryTreeNode(4,null,null);
        BinaryTreeNode five=new BinaryTreeNode(2,six,seven);
        BinaryTreeNode four=new BinaryTreeNode(9,null,null);
        BinaryTreeNode three=new BinaryTreeNode(7,null,five);
        BinaryTreeNode two=new BinaryTreeNode(8,four,null);
        BinaryTreeNode root1=new BinaryTreeNode(8,two,three);

        BinaryTreeNode root2=new BinaryTreeNode(8,new BinaryTreeNode(9,null,null),
                new BinaryTreeNode(2,null,null));

        System.out.println(hasSubTree(root1,root2));
    }//out:true
}
