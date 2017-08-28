package chapter6.knowledgetransfer;

/**
 * 题目：数组中只出现一次的数字
 * 描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 要求时间复杂度O(n)，空间复杂度O(1)
 * 注：异或运算满足交换律
 * Created by Administrator on 2017/8/28.
 */
public class NumbersAppearOnce {

    //核心思想：1、任何一个数字异或它自己都等于0  2、把数组分为两组（两个数字不同异或总会出现1，按此分组），组内异或分别得出只出现一次的数字
    public void findNumsAppearOnce(int[] arr){
        if(arr==null || arr.length<2)
            return;

        int number=0;
        for(int item:arr)
            number^=item; //number的最终结果为两个只出现一次数字的异或

        int index=findFirstBit1(number);

        int number1=0,number2=0;
        for(int item:arr){
            if(isBit1(item,index))
                number1^=item;
            else
                number2^=item;
        }

        System.out.println(number1);
        System.out.println(number2);
    }

    private boolean isBit1(int number, int index){
        number>>=index;
        return (number&1)!=0;
    }

    private int findFirstBit1(int number){
        int indexBit=0;
        while((number&1)==0){
            number>>=1;
            ++indexBit;
        }

        return indexBit;
    }

    public static void main(String[] args){
        int[] array={6,2,4,3,3,2,5,5,};
        new NumbersAppearOnce().findNumsAppearOnce(array);
    }//out:6 4
}
