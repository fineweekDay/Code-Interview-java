package chapter4.reifiable;

/**
 * 题目：二叉搜索树的后序遍历
 * 输入一个整数数组，判断该数组是不是某二叉树后序遍历的结果
 * 假设输入的数组的任意两个数字都互不相同
 * Created by Administrator on 2017/8/13.
 */
public class SquenceOfBST {

    public static boolean verifySquenceOfBST(int[] squence){
        if(squence==null || squence.length==0)
            return false;
        else
            return verifySquenceOfBST(squence,0,squence.length-1);
    }

    private static boolean verifySquenceOfBST(int[] squence,int begin,int last){
      if(begin==last)
            return true; //begin>last的情况不会出现，因此不予考虑

        int root=squence[last];

        //在二叉搜索树左子树的节点小于根节点
        int i=begin;
        for(;i<last;i++){
            if(squence[i]>root)
                break;
        }

        //在二叉搜索树中右子树的节点大于根节点
        int j=i;
        for (;j<last;j++){
            if(squence[j]<root)
                return false;
        }

        //判断左子树是不是二叉搜索树
        boolean left=true;
        if(i>0)
            left=verifySquenceOfBST(squence,begin,i-1);

        //判断右子树是不是二叉搜索树
        boolean right=true;
        if(j<last)
            right=verifySquenceOfBST(squence,i,last-1);

        return left && right;
    }

    public static void main(String[] args){
        int[] squence1={5,7,6,9,11,10,8,};
        System.out.println(verifySquenceOfBST(squence1));

        int[] squence2={7,4,6,5,};
        System.out.println(verifySquenceOfBST(squence2));

        int[] squence3={11,10,9,8,};
        System.out.println(verifySquenceOfBST(squence3));
    }//out:true false true
}
