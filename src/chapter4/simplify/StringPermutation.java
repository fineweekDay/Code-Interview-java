package chapter4.simplify;

/**
 * 题目：字符串的排序
 * 输入一个字符串，打印出该字符串中字符的所有排列
 * 思路：把字符串分为两部分，一部分是字符串第一个字符，另一部分是剩余。接下来求剩余的排列。
 * 拿第一个字符和后面的字符逐个交换
 * Created by Administrator on 2017/8/13.
 */
public class StringPermutation {

    public static void Permutation(String str){
        if(str==null || str.length()==0)
            return;

        char[] array=str.toCharArray();
        Permutation(array,0,array.length);
    }

    private static void Permutation(char[] arr,int begin,int size){
        if(begin==size){
            for(int i=0;i<arr.length;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        }else{
            for(int i=begin;i<size;i++){
                if(i!=begin && arr[i]==arr[begin])
                    continue;
                swap(arr,i,begin);
                Permutation(arr,begin+1,size);
                swap(arr,i,begin);
            }
        }
    }

    private static void swap(char[] arr,int idx1,int idx2){
        char temp=arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;
    }

    public static void main(String[] args){
        String s="abbc";
        Permutation(s);
    }
}
