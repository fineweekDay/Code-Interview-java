package chapter2.ds;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/10.
 */
public class QueueOfTwoStacks<T> {

    private Stack<T> stack1,stack2;

    public  QueueOfTwoStacks(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(T item){
        stack1.push(item);
    }

    public T deleteHead(){
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        if(!stack2.empty())
            return stack2.pop();
        else
            return null;
    }

    public static void main(String[] args){
        QueueOfTwoStacks<String> qs=new QueueOfTwoStacks();
        qs.appendTail("1");
        qs.appendTail("111");
        System.out.println(qs.deleteHead());
    }//out:1

}
