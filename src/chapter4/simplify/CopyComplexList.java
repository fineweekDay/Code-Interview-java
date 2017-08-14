package chapter4.simplify;

/**
 * 题目：复杂链表的复制
 * Created by Administrator on 2017/8/13.
 */
public class CopyComplexList {

    static class ComplexListNode{
        int value;
        ComplexListNode next;
        ComplexListNode Sibling;

        ComplexListNode(){

        }

        ComplexListNode(int value,ComplexListNode next,ComplexListNode Sibling){
            this.value=value;
            this.next=next;
            this.Sibling=Sibling;
        }
    }

    public static ComplexListNode Clone(ComplexListNode head){
        CloneNodes(head);
        ConnectSiblingNodes(head);
        return ReconnnectNodes(head);
    }

    private static void CloneNodes(ComplexListNode head){
        ComplexListNode pNode=head;

        while(pNode!=null){
            ComplexListNode pCloned=new ComplexListNode();
            pCloned.value=pNode.value;
            pCloned.next=pNode.next;
            pCloned.Sibling=null;

            pNode.next=pCloned;

            pNode=pCloned.next;//这里不能用pNode了，因为next已经改变
        }
    }

    private static void ConnectSiblingNodes(ComplexListNode head){
        ComplexListNode pNode=head;

        while(pNode!=null){
            ComplexListNode pCloned=pNode.next;
            if(pNode.Sibling!=null){
                pCloned.Sibling=pNode.Sibling.next;
            }
            pNode=pCloned.next;
        }
    }

    private static ComplexListNode ReconnnectNodes(ComplexListNode head) {
        ComplexListNode pNode=head;
        ComplexListNode pClonedHead=null;
        ComplexListNode pClonedNode=null;

        if(pNode!=null){
            pClonedNode=pNode.next;
            pClonedHead=pClonedNode;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }

        while(pNode!=null){
            pClonedNode.next=pNode.next;
            pClonedNode=pClonedNode.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }

        return pClonedHead;
    }

    public static void print(ComplexListNode head){
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ComplexListNode node1 = new ComplexListNode(1,null,null);
        ComplexListNode head = new ComplexListNode(0,node1,null);
        node1.Sibling=head;

        ComplexListNode Cloned=Clone(head);

        print(head);
        print(Cloned);

        System.out.println("********************");

        ComplexListNode Cloned1=Cloned,Cloned2=Cloned,head1=head,head2=head;

        while(Cloned1!=null && head1!=null){//比较内容是否来源于同一地址
            System.out.println(Cloned1 == head1);
            Cloned1=Cloned1.next;
            head1=head1.next;
        }

        System.out.println("********************");

        while(Cloned2!=null && head2!=null){//查看Sibling内容，并比较Sibling是否来源于同一地址
            System.out.print(Cloned2.Sibling + "-----VS-----" + head2.Sibling +"      ");
            System.out.println(Cloned2.Sibling == head2.Sibling);
            Cloned2=Cloned2.next;
            head2=head2.next;
        }
    }
}
