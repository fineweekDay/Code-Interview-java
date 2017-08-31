package chapter6.divergent;

/**
 * 题目：不用加减乘除做加法
 * 描述：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、×、÷四则运算
 * Created by Administrator on 2017/8/30.
 */
public class AddTwoNumbers {

    public static int Add(int num1,int num2){
        int sum,carry;
        do{
            sum=num1^num2;//不含进位的和
            carry=(num1&num2)<<1;//进位

            num1=sum;
            num2=carry;
        }while(num2!=0);
        return  num1;
    }

    public static void main(String[] args){
        System.out.println(Add(-5,-2));
    }//out:-7
}
