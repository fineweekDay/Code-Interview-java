package chapter6.abstractmodel;

/**
 * 题目：n个骰子的点数
 * 描述：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * Created by Administrator on 2017/8/29.
 */
public class DicesProbability {

    //基于循环求骰子点数，时间性能较好（是个很好的想法）
    public static void printProbability(int number){
        if(number<1)
            throw new IllegalArgumentException("The number of dices should be positive.");

        int g_maxValue=6;
        int[][] probabilities=new int[2][g_maxValue*number+1];
        int flag=0;

        for(int i=1;i<=g_maxValue;i++)
            probabilities[0][i]=1;

        for(int k=2;k<=number;k++){
            for(int i=0;i<k;i++)
                probabilities[1-flag][i]=0;//基础更新

            for(int i=k;i<=g_maxValue*k;i++){
                probabilities[1-flag][i]=0;//清除上次的记录
                for(int j=1;j<=i && j<=g_maxValue;j++)
                    probabilities[1-flag][i]+=probabilities[flag][i-j];
            }

            flag=1-flag;//两个数组交替使用
        }

        double total=Math.pow(g_maxValue,number);
        double ratio;
        for(int i=number;i<=g_maxValue*number;i++){
            ratio=(double) probabilities[flag][i]/total;
            System.out.println(i+"  "+probabilities[flag][i]+"  "+ratio);
        }
    }

    public static void main(String[] args){
        printProbability(6);
    }
}
