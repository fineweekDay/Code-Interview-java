package chapter3.completeness;

import java.util.Arrays;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 * 注意：isEven()方法是一个交换标准，该类型题目替换标准，替换isEven()即可
 * Created by Administrator on 2017/8/12.
 */
public class ReorderArray {

    public static void main(String[] args){
        int[] array={1,2,3,4,5,6,11,12,9,10,8,7,};
        System.out.println(Arrays.toString(order(array)));
    }//out:[1, 7, 3, 9, 5, 11, 6, 12, 4, 10, 8, 2]

    public static int[] order(int[] array){
        if(array.length==0 || array==null)
            return null;

        int ind1=0,ind2=array.length-1;

        while(ind1<ind2){
            //这里有些类似于快速排序的思想
            while(ind1<ind2 && (!isEven(array[ind1])))
                ind1++;
            while(ind1<ind2 && isEven(array[ind2]))
                ind2--;

            if(ind1<ind2)
                swap(array,ind1,ind2);
        }
        return array;
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tdata=array[ind2];
        array[ind2]=array[ind1];
        array[ind1]=tdata;
    }

    private static boolean isEven(int number){
        return (number & 1)==0;//是偶数则返回true
    }
}
