package chapter5.timeandspaceblance;

/**
 * 题目：两个链表的第一个公共结点
 * Created by Administrator on 2017/8/28.
 */
public class FirstCommonNodesInLists {

    private static class ListNode{
        int value;
        ListNode next;

        ListNode(int value,ListNode next){
            this.value=value;
            this.next=next;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode head1,ListNode head2){
        if(head1==null || head2==null)
            return null;

        int length1=GetListLength(head1);
        int length2=GetListLength(head2);

        int dif=length1-length2;
        ListNode listLong,listShort;//找出长链表和短链表

        if(dif>0){
            listLong=head1;
            listShort=head2;
        }else{
            listLong=head2;
            listShort=head1;
            dif=-1*dif;
        }

        //先在长链表上走几步，再同时在两个链表上遍历
        for(int i=0;i<dif;i++)
            listLong=listLong.next;

        while(listLong!=null && listShort!=null && listLong!=listShort){
            listLong=listLong.next;
            listShort=listShort.next;
        }

        return listLong;//要是没找到就返回尾节点的next，即null
    }

    private static int GetListLength(ListNode head){
        int length=0;
        ListNode pNode=head;

        while(pNode!=null){
            ++length;
            pNode=pNode.next;
        }

        return length;
    }

    public static void main(String[] args){
        ListNode seven=new ListNode(7,null);
        ListNode six=new ListNode(6,seven);
        ListNode five=new ListNode(5,six);
        ListNode four=new ListNode(4,five);
        ListNode third=new ListNode(3,six);
        ListNode second=new ListNode(2,third);
        ListNode first=new ListNode(1,second);

        ListNode result=FindFirstCommonNode(first,four);
        System.out.println(result.value);
    }//out:6
}
