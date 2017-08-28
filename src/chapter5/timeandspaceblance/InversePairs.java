package chapter5.timeandspaceblance;

import java.util.Arrays;

/**
 * 题目：数组中的逆序对
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 * 要求：输入一个数组，求出这个数组中的逆序对的总数
 * Created by Administrator on 2017/8/28.
 */
public class InversePairs {

    public static int GetInversePairs(int[] data){
        if(data==null || data.length<=1)
            return 0;

        int[] copy=new int[data.length];
        for(int i=0;i<copy.length;i++)
            copy[i]=data[i];

        return InversePairsCore(data,copy,0,data.length-1);
    }

    //本质就是在归并排序中求逆序对
    private static int InversePairsCore(int[] data, int[] copy, int start, int end){
        if(start==end){
            copy[start]=data[start];
            return 0;
        }

        int len=(end-start)/2;

        int left=InversePairsCore(copy,data,start,start+len);
        int right=InversePairsCore(copy,data,start+len+1,end);

        int i=start+len;//i初始化为前半段最后一个数字的下标
        int j=end;//j初始化为后半段最后一个数字的下标
        int indexCopy=end;
        int count=0;

        while(i>=start && j>=start+len+1){
            if(data[i]>data[j]){
                copy[indexCopy--]=data[i--];
                count+=j-start-len;
            }else{
                copy[indexCopy--]=data[j--];
            }
        }

        for(;i>=start;i--)
            copy[indexCopy--]=data[i];
        for(;j>=start+len+1;j--)
            copy[indexCopy--]=data[j];

        return left+right+count;
    }

    public static void main(String[] args){
        int[] data={7,5,6,4,};
        System.out.println(GetInversePairs(data));
//        System.out.println(Arrays.toString(data)); //[5,7,4,6]
    }//out:5
}
