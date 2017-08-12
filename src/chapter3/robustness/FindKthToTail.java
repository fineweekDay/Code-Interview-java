package chapter3.robustness;

/**
 * 题目：输入一个链表，输出该链表中倒数第k个节点
 * Created by Administrator on 2017/8/12.
 */
public class FindKthToTail {

    static class ListNode{
        int value;
        ListNode next;

        ListNode(int val,ListNode next){
            this.value=val;
            this.next=next;
        }
    }

    public static ListNode find(ListNode head,int k){
        if(k<=0 || head==null)
            return null;

        ListNode goHead=head;
        ListNode goBehind=null;

        //先让前面的指针走k步
        for(int i=0;i<k-1;i++){
            if(goHead.next!=null)
                goHead=goHead.next;
            else
                return null;//链表没达到k的长度
        }

        goBehind=head;

        while(goHead.next!=null){
            goHead=goHead.next;
            goBehind=goBehind.next;
        }
        return goBehind;
    }


    //鲁棒性考虑：k的大小是否超过链表长度，小于等于0；head是否是空指针
    public static void main(String[] args){
        ListNode forth = new ListNode(4,null);
        ListNode third = new ListNode(3,forth);
        ListNode second = new ListNode(2,third);
        ListNode head = new ListNode(1,second);

        ListNode result = find(head, 2);
        if(result==null)
            System.out.println("null");
        else
            System.out.println(result.value);
    }//out:3
}
