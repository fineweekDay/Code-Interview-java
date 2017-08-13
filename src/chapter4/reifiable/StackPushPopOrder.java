package chapter4.reifiable;

import java.util.Stack;

/**
 * 题目：栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否是该栈的弹出顺序。
 * 假设压入栈内的数字均不相等
 *
 * 思路：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，
 * 我们把压栈序列中还没有入栈的数字压入栈，直到把下一个需要弹出的数字压入栈顶为止。
 * 如果所有的数字都压入了栈仍然没找到下一个弹出的数字，那么该序列不可能是一个弹出序列.
 * Created by Administrator on 2017/8/12.
 */
public class StackPushPopOrder {

    /**剑指OFFER答案：
     * @param pPush 压入栈序列
     * @param pPop 弹出栈序列
     * @param length 序列长度，需保证两个序列等长
     * @return possible
     * */
    public static boolean isPopOrder(int[] pPush,int[] pPop,int length){
        boolean possible=false;

        if(pPush!=null && pPop!=null){
            Stack<Integer> stk=new Stack<>();//辅助栈

            int pushId=0,popId=0;

            while (popId<length){
                while (stk.empty() || stk.peek() !=pPop[popId]){
                    if(pushId==length)
                        break;
                    stk.push(pPush[pushId++]);
                }

                if (stk.peek()!=pPop[popId])
                    break;

                stk.pop();
                popId++;

                if(popId==length)//书上要进行判断辅助栈为空，但是我觉得既然两个序列长度相等，走到这一步时栈就必然为空了，没必要判断
                    possible=true;
            }

        }

        return possible;
    }


    //更具一般性的，两个序列长度不相等，进行判断（思路其实是一模一样的，只是更改了循环的条件）
    public static boolean isPopOrder(int [] pPush,int [] pPop) {
        if(pPush == null || pPop == null){
            return false;
        }

        int pushLength = pPush.length;
        int popLength = pPop.length;
        if(pushLength == 0 || popLength == 0 || popLength > pushLength){
            return false;
        }

        Stack<Integer> stk = new Stack<>();

        int start = 0;
        for(int i = 0; i < popLength; i++){
            while(stk.empty() || stk.peek() != pPop[i]){
                if(start >= pushLength)
                    return false;
                stk.push(pPush[start++]);
            }

            if(stk.peek() != pPop[i])
                return false;

            stk.pop();
        }

        return true;
    }

    public static void main(String[] args){
        int[] push={1,2,3,4,5,};
        int[] pop={4,3,5,1,2};

        System.out.println(isPopOrder(push,pop,5));
    }//out:true
}
