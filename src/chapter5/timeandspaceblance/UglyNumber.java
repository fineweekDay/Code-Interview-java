package chapter5.timeandspaceblance;

/**
 * 题目：丑数（只包含因子2,3,5的数，习惯上把1当做第一个丑数）
 * 求从小到大的顺序的第1500个丑数
 * Created by Administrator on 2017/8/28.
 */
public class UglyNumber {

    public static int GetUglyNumber(int index){
        if(index<=0){
            throw new IllegalArgumentException("index should be positive");
        }

        int uglyNumbers[]=new int[index];
        uglyNumbers[0]=1;//1是第一个丑数
        int nextUglyIndex=1;

        //维护临近值对应的数组的下标
        int multiply2=0;
        int multiply3=0;
        int multiply5=0;

        while(nextUglyIndex<index){
            int min=Math.min(Math.min(2*uglyNumbers[multiply2],
                    3*uglyNumbers[multiply3]),5*uglyNumbers[multiply5]);

            uglyNumbers[nextUglyIndex]=min;

            while(2*uglyNumbers[multiply2]<=uglyNumbers[nextUglyIndex])
                multiply2++;
            while(3*uglyNumbers[multiply3]<=uglyNumbers[nextUglyIndex])
                multiply3++;
            while(5*uglyNumbers[multiply5]<=uglyNumbers[nextUglyIndex])
                multiply5++;

            nextUglyIndex++;
        }

        return uglyNumbers[index-1];
    }

    public static void main(String[] args){
        System.out.println(GetUglyNumber(1500));
    }//out:859963392
}
