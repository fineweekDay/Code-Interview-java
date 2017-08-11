package chapter2.ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：用两个先进先出队列实现栈
 * Created by Administrator on 2017/8/11.
 */
public class StackOfTwoQueue<T> {
    //非线程安全
    private Queue<T> queue1,queue2;

    public StackOfTwoQueue(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    public T pop(){
        if(queue1.isEmpty())
            return pop(queue2,queue1);
        else
            return pop(queue1,queue2);
    }

    private T pop(Queue<T> q1,Queue<T> q2){
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        return q1.poll();//当两个都是空队列时，直接输出null
    }

    public void push(T item){
        //根据剑指OFFER分析，至少保持了一个队列为空
        if(queue1.isEmpty())
            queue2.add(item);
        else
            queue1.add(item);
    }

    public static void main(String[] args){
        StackOfTwoQueue<String> sq=new StackOfTwoQueue<>();
        sq.push("a");
        sq.push("b");
        sq.push("c");
        System.out.println(sq.pop());
        sq.push("d");
        System.out.println(sq.pop());
    }//out：c d
}
