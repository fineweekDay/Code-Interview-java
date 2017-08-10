package chapter2.ds;

import java.util.Stack;

/**
 * 题目：从尾到头打印链表
 * Created by Administrator on 2017/8/10.
 */
public class PrintListReverse {


    //基于栈的实现（推荐的实现）
    public static void PrintListReversinglyIteratively(ListNode head){
        if(head==null)
            return;
        Stack<Integer> stack=new Stack<>();
        while(head!=null){
            stack.add(head.value);
            head=head.next;
        }

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }


    //基于递归的实现，当链表非常长的时候，会导致栈溢出
    public static void PrintListReversinglyIteratively1(ListNode head){
        if(head !=null){
            if(head.next!=null){
                PrintListReversinglyIteratively1(head.next);
            }
            System.out.println(head.value);
        }
    }

}
