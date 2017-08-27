package chapter5.timeefficient;

/**
 * 题目：数组中出现次数超过一半的数字
 * 此处不考虑用Map实现
 * 思路：由于要找的数字出现次数比其他所有数字出现的次数之和还要多，
 * 那么要找的数字肯定是最后一次把次数设为1时对应的次数
 * Created by Administrator on 2017/8/14.
 */
public class MoreThanHalfNumber {

    public static int MoreThanHalf(int[] array){ //当输入非法，或者没有满足条件的数时，默认输出0
        if(array==null || array.length==0)
            return 0;

        int number=array[0],time=1;

        for(int i=1;i<array.length;i++){
            if(time==0){
                number=array[i];
                time=1;
            }else{
                if(number==array[i])
                    time++;
                else
                    time--;
            }
        }

        if(!CheckMoreThanHalf(array,number))
            number=0;
        return number;
    }

    private static boolean CheckMoreThanHalf(int[] array, int number){
        //由于这是私有方法，供MoreThanHalf方法专用，因此不再提供数组检验
        int time=0;

        for(int i=0;i<array.length;i++)
            if(number==array[i])
                time++;

        boolean isMoreThanHalf=true;

        if(time*2 <= array.length){
            isMoreThanHalf=false;
        }

        return isMoreThanHalf;
    }

    public static void main(String[] args){
        int[] arr= {1,2,3,2,2,2,5,4,2,};
        System.out.println(MoreThanHalf(arr));
    }
}
