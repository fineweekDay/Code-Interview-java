package chapter6.knowledgetransfer;

/**
 * 题目：和为s的两个数字VS和为s的连续正数序列
 * 描述：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
 * 如果有多对数字的和等于s，输出任意一对即可
 * Created by Administrator on 2017/8/28.
 */
public class TwoNumbersWithSum {

    public static boolean FindNumbersWithSum(int[] data,int sum){
        if(data==null || data.length==0)
            return false;

        int ind1=0,ind2=data.length-1;
        int number1,number2;
        long curSum;//这里要考虑到整型溢出，所以用long

        while(ind2>ind1){
            curSum=data[ind1]+data[ind2];
            if(curSum==sum){
                number1=data[ind1];
                number2=data[ind2];
                System.out.println("Pair has been found : "+number1+" and "+number2);
                return true;
            }else if(curSum > sum)
                ind2--;
            else
                ind1++;
        }

        return false;
    }

    public static void main(String[] args){
        int[] array={1,2,4,7,11,15,};
        System.out.println(FindNumbersWithSum(array,15));
    }//out:true
}
