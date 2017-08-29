package chapter6.abstractmodel;

import java.util.Arrays;

/**
 * 题目：扑克牌的顺子
 * 描述：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的
 * 提醒：2-10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字
 * Created by Administrator on 2017/8/29.
 */
public class ContinousCards {

    //以下计算的基本假设：一副牌
    public static boolean isContinuous(String[] arr){
        if(arr==null || arr.length!=5)
            return false;

        int[] num=new int[5];
        for(int i=0;i<5;i++){
            switch (arr[i]){
                case "A":
                    num[i]=1;
                    break;
                case "J":
                    num[i]=11;
                    break;
                case "Q":
                    num[i]=12;
                    break;
                case "K":
                    num[i]=13;
                    break;
                case "joker":
                    num[i]=0;
                    break;
                case "JOKER":
                    num[i]=0;
                    break;
                default:
                    num[i]=Integer.valueOf(arr[i]);
                    break;
            }

        }

        return isContinuous(num);
    }


    private static boolean isContinuous(int[] numbers){
        Arrays.sort(numbers);

        int numberOfZero=0;//大小王（零）的个数
        for(int i:numbers)
            if(i==0)
                numberOfZero++;

        int small=numberOfZero;//第一个非零元素位置
        int big=small+1;
        int gap=0;

        while(big<numbers.length){
            if(numbers[small]==numbers[big])
                return false;//顺子不含有两个相同的非零数

            gap+=(numbers[big]-numbers[small]-1);
            small=big++;
        }

        return gap<=numberOfZero;//如果大小王能补救就说明是顺子
    }

    public static void main(String[] args){
        String[] str={"A","2","3","joker","5"};
        System.out.println(isContinuous(str));
    }//out:true
}
