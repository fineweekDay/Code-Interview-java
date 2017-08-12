package chapter3.robustness;

/**
 * 题目：合并两个排序的链表
 * 输入：两个递增链表
 * Created by Administrator on 2017/8/12.
 */
public class MergeList {

    static class ListNode{
        int value;
        ListNode next;

        ListNode(int val,ListNode next){
            this.value=val;
            this.next=next;
        }
    }

    public static ListNode merge(ListNode head1,ListNode head2){
        if(head1==null)
            return head2;
        else if(head2==null)
            return head1;

        ListNode mergeList=null;

        if(head1.value < head2.value){
            mergeList=head1;
            mergeList.next=merge(head1.next,head2);
        }else{
            mergeList=head2;
            mergeList.next=merge(head1,head2.next);
        }

        return mergeList;
    }

    public static void main(String[] args){
        ListNode six = new ListNode(6,null);
        ListNode five = new ListNode(5,six);
        ListNode forth = new ListNode(2,five);

        ListNode third = new ListNode(4,null);
        ListNode second = new ListNode(3,third);
        ListNode head = new ListNode(1,second);

        ListNode result=merge(head,forth);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }//out:1,2,3,4,5,6
}
