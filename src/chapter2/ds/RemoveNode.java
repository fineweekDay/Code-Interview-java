package chapter2.ds;

/**
 * 题目：删除单链表中含有某个值的第一个节点
 * Created by Administrator on 2017/8/10.
 */
public class RemoveNode {

    private static ListNode deleteNode(ListNode head,int v){
        //考虑点：null，单节点链表
        if(head==null)
            return null;
        
        ListNode pre=head,current=head;
        
        if(current.value==v)
            return current.next;//是不是null都无所谓
        
        while(current.value!=v && current!=null){
            pre=current;
            current=current.next;
        }
        if(current!=null)
            pre.next=current.next;
        
        return head;
    }
}

class ListNode{
    int value;
    ListNode next;
}