package chapter3.robustness;

/**
 * 题目：判断一个单链表是否形成了环形结构
 * 思路：定义两个指针,同时从链表头部出发,一个指针一次走一步,另一个指针一次走两步。
 * 1. 如果走的快的指针追上了走的慢的指针,那么链表就是环形链表。
 * 2. 如果走的快的的走到了链表尾部都没追上第一个指针,那么链表就不是环形链表。
 * Created by Administrator on 2017/8/12.
 */
public class HasCycle {

    static class ListNode{
        int value;
        ListNode next;

        ListNode(int val,ListNode next){
            this.value=val;
            this.next=next;
        }
    }

    //测试给定单链表是否有环
    public static boolean hasRing(ListNode head) throws Exception {
        if(head==null)
            throw new Exception("给定链表为空链表");

        ListNode goFast=head;//一次遍历两个节点
        ListNode goSlow=head;//一次遍历一个节点

        while(goFast.next!=null && goFast.next.next!=null){
            goFast=goFast.next.next;
            goSlow=goSlow.next;

            if(goFast==goSlow)
                return true;
        }

        return false;
    }

    public static void main(String[] args){
        ListNode six = new ListNode(6,null);
        ListNode five = new ListNode(5,six);
        ListNode forth = new ListNode(4,five);
        ListNode third = new ListNode(3,forth);
        ListNode second = new ListNode(2,third);
        ListNode head = new ListNode(1,second);

        six.next=third;

        try {
            System.out.println(hasRing(head));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//out:true
}
