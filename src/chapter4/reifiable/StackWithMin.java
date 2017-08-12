package chapter4.reifiable;

import java.util.Stack;

/**
 * 题目：包含min函数的栈
 * 实现一个能得到栈最小元素的min函数，调用min,push,pop的时间复杂度都是o(1)
 * Created by Administrator on 2017/8/12.
 */
public class StackWithMin<T extends Comparable<T>> {

    Stack<T> stack1,stack2;//一个是操作栈，一个是辅助栈

    public StackWithMin(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(T item){
        stack1.push(item);
        if(stack2.empty())
            stack2.push(item);
        else{
            T tem=stack2.peek();
            if(item.compareTo(tem)<0)
                stack2.push(item);
            else
                stack2.push(tem);
        }
    }

    public T pop(){
        if(stack1.empty())
            return null;

        //stack1不为空，则stack2一定不为空
        T object=stack1.pop();
        stack2.pop();

        return object;
    }

    public T min(){
        if(stack2.empty())
            return null;
        else
            return stack2.peek();
    }

    public static void main(String[] args){
        StackWithMin<Integer> stk=new StackWithMin<>();

        stk.push(3);
        System.out.println(stk.min());

        stk.push(4);
        System.out.println(stk.min());

        stk.push(2);
        System.out.println(stk.min());

        stk.push(1);
        System.out.println(stk.min());

        stk.pop();
        System.out.println(stk.min());

        stk.pop();
        System.out.println(stk.min());

        stk.push(0);
        System.out.println(stk.min());
    }//out:3 3 2 1 2 3 0
}
