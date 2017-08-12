package chapter3.completeness;

/**
 * 题目：在o(1)时间删除链表节点
 * Created by Administrator on 2017/8/11.
 */
public class DeleteNode {

    static class ListNode{
        int value;
        ListNode next;

        ListNode(int val,ListNode listNode){
            this.value = val;
            next=listNode;
        }
    }

    //这种方法成立的基础是必须时被删除的节点在链表内
    public static ListNode delete(ListNode head,ListNode toBeDelete){
        if(head==null || toBeDelete==null)
            return null;

        if(toBeDelete.next != null){
            //删除的不是尾节点
            ListNode pNext=toBeDelete.next;
            toBeDelete.next=pNext.next;
            toBeDelete.value=pNext.value;

            pNext=null;
        }else if(head==toBeDelete){
            //仅有一个节点
            head=null;
            toBeDelete=null;
        }else{
            //链表中有多个节点，删除尾节点
            ListNode pNode=head;
            while(pNode.next!=toBeDelete){
                pNode=pNode.next;
            }
            pNode.next=null;
            toBeDelete=null;
        }

        return head;
    }

    public static void main(String[] args){
        ListNode tail=new ListNode(1,null);
        ListNode c=new ListNode(2,tail);
        ListNode b=new ListNode(3,c);
        ListNode head=new ListNode(4,b);
//        ListNode head=tail;
        head=delete(head,c);
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }

}
