package chapter2.dm;

/**
 * 题目：二进制中1的个数
 * 知识点：除法的运算要比移位运算低很多（面试时不要被带沟里了）。
 *
 * Created by Administrator on 2017/8/11.
 */
public class NumberOf1 {

    public static void main(String[] args){
        int n=0x80000000;
        System.out.println(getOne(n));
    }

    public static int getOne(int n){
        int count=0;

        while(n!=0){
            ++count;
            n=(n-1)&n;
        }

        return count;
    }
}
