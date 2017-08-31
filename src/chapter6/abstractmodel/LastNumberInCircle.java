package chapter6.abstractmodel;

/**
 * 题目：圆圈中最后剩下的数字（约瑟夫环问题）
 * 描述：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字，求最后剩下的数字
 * Created by Administrator on 2017/8/29.
 */
public class LastNumberInCircle {

    public static int LastRemaining(int n,int m){
        if(n<1 || m<-1)
            return -1;

        int last=0;
        for(int i=2;i<=n;i++)
            last=(last+m)%i;

        return last;
    }
    public static void main(String[] args){
        System.out.println(LastRemaining(5,3));
    }//out:3
}
