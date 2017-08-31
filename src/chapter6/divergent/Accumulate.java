package chapter6.divergent;

/**
 * 题目：求1+2+...+n
 * 描述：不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * Created by Administrator on 2017/8/30.
 */
public class Accumulate {

    //利用递归+短路特性
    public static int GetSum(int n){
        int res=n;
        boolean flag=(n>0) &&((res+=GetSum(n-1))>0);
        return res;
    }

    public static void main(String[] args){
        //题目限制了n要为正整数，当然输入0也可以得到正确结果
        System.out.println(GetSum(100));
    }
}
