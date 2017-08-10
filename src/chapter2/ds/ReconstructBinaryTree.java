package chapter2.ds;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 对二叉树不够熟悉，借此机会学习，代码来源如下
 * @see <a href="http://blog.csdn.net/jsqfengbao/article/details/47088947>重建二叉树</a>
 * Created by Administrator on 2017/8/10.
 * 这里的代码过于冗长，更简洁的如下：
 * @see <a href="http://blog.csdn.net/qq_15062527/article/details/48846457">重建二叉树</a>
 */

public class ReconstructBinaryTree {

    public static void main(String[] args){
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        try {
            printPreOrder(Construct(preOrder,inOrder,preOrder.length));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param preOrder 前序遍历结果
     * @param inOrder 中序遍历结果
     * @param length 数组长度
     *
    */
    public static BinaryTreeNode Construct(int[] preOrder,int[] inOrder,int length) throws Exception {
        if(preOrder==null || inOrder==null || length<=0)
            return null;
        return ConstructCore(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

    private static BinaryTreeNode ConstructCore(int[] preOrder, int startPre, int endPre,
                                                int[] inOrder, int startIn, int endIn) throws Exception {
        int rootValue=preOrder[startPre];
        BinaryTreeNode root=new BinaryTreeNode(rootValue);

        //二叉树只有一个节点
        if(startPre==endPre){
            if(startIn==endIn && preOrder[startPre]==inOrder[startIn]){
                return root;
            }else{
                throw new Exception();//说明两个数组不合理
            }
        }

        //在中序遍历种找到根节点的索引
        int rootInIndex=startIn;

        while(rootInIndex<=endIn && inOrder[rootInIndex]!=rootValue){
            ++rootInIndex;
        }

        if(rootInIndex==endIn && inOrder[rootInIndex]!=rootValue){
            throw new Exception();//说明给的数组有错
        }

        int leftLength=rootInIndex-startIn;
        int leftPreOrderEndIndex=startPre+leftLength;

        if(leftLength>0){
            //构建左子树
            root.leftNode=ConstructCore(preOrder,startPre+1,
                    leftPreOrderEndIndex,inOrder,startIn,rootInIndex-1);
        }

        if(leftLength<endPre-startPre){
            //构建右子树
            root.rightNode=ConstructCore(preOrder,leftPreOrderEndIndex+1,
                    endPre,inOrder,rootInIndex+1,endIn);
        }

        return root;
    }


    //以前序遍历的方式输出显示二叉树
    public static void printPreOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + " ");
        }

        if (root.leftNode != null) {
            printPreOrder(root.leftNode);
        }

        if (root.rightNode != null) {
            printPreOrder(root.rightNode);
        }
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
//out:1 2 4 7 3 5 6 8