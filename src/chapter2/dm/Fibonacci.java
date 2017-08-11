package chapter2.dm;

/**
 * 题目：求解斐波拉契数列第n项的值
 * 延伸：青蛙跳台阶/小矩形覆盖大矩形等，一模一样的思路和解法
 * Created by Administrator on 2017/8/11.
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n=100;
        try {
            System.out.println(getN(n));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //相比于递归运算，当n很大时，大幅度提升了运算时间和空间效率
    public static long getN(int n) throws Exception {
        if(n<0)
            throw new Exception();

        int result[]={0,1};//代表斐波拉契数列前两项

        if(n<2)
            return result[n];

        //代表当前运算的前两项和当前运算值
        long fibo1=0;
        long fibo2=1;
        long fiboN=0;

        for(int i=2;i<=n;i++){
            fiboN=fibo1+fibo2;

            fibo1=fibo2;
            fibo2=fiboN;
        }

        return fiboN;
    }
}
