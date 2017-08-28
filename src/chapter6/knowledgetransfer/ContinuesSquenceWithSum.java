package chapter6.knowledgetransfer;

/**
 * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含两个数）
 * Created by Administrator on 2017/8/28.
 */
public class ContinuesSquenceWithSum {

    public static void FindContinuousSequence(int sum){
        if(sum<3)
            return;

        int small=1,big=2;
        int border=(1+sum)/2;//以此为界，超过这里，序列和必定大于sum了；至于为什么要+1，可以参考15=7+8
        int curSum=small+big;

        while(small<border){
            if(curSum==sum)
                print(small,big);

            while(curSum>sum && small<border){
                curSum-=small;
                small++;

                if(curSum==sum)
                    print(small,big);
            }

            big++;
            curSum+=big;
        }
    }

    private static void print(int small, int big) {
        System.out.print("[");
        for(int i=small;i<big;i++)
            System.out.print(i+",");
        System.out.println(big+"]");
    }

    public static void main(String[] args){
        FindContinuousSequence(15);
    }//out:[1,2,3,4,5],[4,5,6],[7,8]
}
