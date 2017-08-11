package chapter2.ds;

import java.util.Stack;

/**
 * 题目：用两个栈实现先进先出的队列
 * Created by Administrator on 2017/8/10.
 */
public class QueueOfTwoStacks<T> {
    //非线程安全
    private Stack<T> stack1,stack2;

    public  QueueOfTwoStacks(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(T item){
        stack1.push(item);
    }

    public T deleteHead(){
        if(!stack2.empty()){
            return stack2.pop();
        }else if(!stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return null;
        }

    }

    public static void main(String[] args){
        QueueOfTwoStacks<String> qs=new QueueOfTwoStacks();
        qs.appendTail("1");
        qs.appendTail("11");
        System.out.println(qs.deleteHead());
        qs.appendTail("111");
        System.out.println(qs.deleteHead());
    }//out:1 11
}
