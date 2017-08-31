package chapter7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：树中两个结点的最低公共祖先
 * Created by Administrator on 2017/8/30.
 */
public class CommonFNodeInTree {

    static class TreeNode{//题目中未指明树是二叉树
        int value;
        List<TreeNode> children=new LinkedList<>();

        TreeNode(int value){
            this.value=value;
        }

        public String toString(){
            return value+"";
        }
    }

    //找出两个结点的最低公共祖先
    public static TreeNode GetLastCommonParent(TreeNode root,TreeNode p1,TreeNode p2){
        if(root==null || p1==null || p2==null)
            return null;

        List<TreeNode> path1=new LinkedList<>();
        List<TreeNode> path2=new LinkedList<>();

        GetNodePath(root,p1,path1);
        GetNodePath(root,p2,path2);

//        System.out.println("path1: "+ path1);
//        System.out.println("path2: "+ path2);

        return GetLastCommonNode(path1,path2);
    }



    //找出两个路径中的最后一个公共结点
    private static TreeNode GetLastCommonNode(List<TreeNode> path1,List<TreeNode> path2){
        Iterator<TreeNode> it1=path1.iterator();
        Iterator<TreeNode> it2=path2.iterator();

        TreeNode last=null,temp;

        while(it1.hasNext() && it2.hasNext()){
            temp=it1.next();
            if(temp==it2.next()){
                last=temp;
            }
        }

        return last;
    }


    private static boolean GetNodePath(TreeNode root,TreeNode target,List<TreeNode> path){
        if(root==null)
            return false;

        path.add(root);
        boolean found=false;

        if(root==target){
            found=true;
            return found;
        }

        List<TreeNode> children=root.children;

        for(TreeNode node:children){
            found=found || GetNodePath(node,target,path);
        }

        if(!found)
            path.remove(path.size()-1);

        return found;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);
        n2.children.add(n5);

        n4.children.add(n6);
        n4.children.add(n7);

        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(GetLastCommonParent(n1, n6, n8));
    }//out:2
}
