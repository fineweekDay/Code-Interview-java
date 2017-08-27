package chapter5.timeefficient;

/**
 * 题目：连续子数组的最大和
 * 描述：输入一个整型数组，数组里有正数和负数；数组中一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值，要求时间复杂度为O(n)。
 * Created by Administrator on 2017/8/27.
 */
public class GreatestSumOfSubarrays {

    //解法：举例分析数组的规律
    public static Integer findGreatestSum1(int[] arr){
        if(arr.length==0 || arr==null)
            return null;

        int greatest=0x80000000;
        int curSum=0;

        for(int i=0;i<arr.length;i++){
            if(curSum<=0)
                curSum=arr[i];
            else
                curSum+=arr[i];

            if(curSum>greatest)
                greatest=curSum;
        }
        return greatest;
    }

//    public static Integer findGreatestSum2(int[] arr){
//        if(arr.length==0 || arr==null)
//            return null;
//
//        int greatest=arr[0],temp=arr[0];
//
//        for(int i=1;i<arr.length;i++){
//            temp=(temp>=0) ? temp+arr[i]:arr[i];
//            greatest=(greatest<temp) ? temp:greatest;
//        }
//
//        return greatest;
//    }

    public static void main(String[] args){
        int[] arr={-1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSum1(arr));
    }
}
