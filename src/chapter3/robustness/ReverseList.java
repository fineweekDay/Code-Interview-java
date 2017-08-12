package chapter3.robustness;

/**
 * 题目：反转链表
 * 鲁棒性考察：反转链表出现断裂；null或单节点链表；头结点是不是之前的尾节点
 * Created by Administrator on 2017/8/12.
 */
public class ReverseList {

    static class ListNode{
        int value;
        ListNode next;

        ListNode(int val,ListNode next){
            this.value=val;
            this.next=next;
        }
    }

    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;

        ListNode pre=null;
        ListNode current=head;
        ListNode record;

        while(current!=null){
            record=current.next;
            current.next=pre;
            pre=current;
            current=record;
        }
        return pre;

    }

    public static void main(String[] args){
        ListNode six = new ListNode(6,null);
        ListNode five = new ListNode(5,six);
        ListNode forth = new ListNode(4,five);
        ListNode third = new ListNode(3,forth);
        ListNode second = new ListNode(2,third);
        ListNode head = new ListNode(1,second);

        ListNode nlist=reverse(head);

        while(nlist!=null){
            System.out.println(nlist.value);
            nlist=nlist.next;
        }
    }
}
