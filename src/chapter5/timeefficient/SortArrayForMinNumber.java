package chapter5.timeefficient;

import java.util.Comparator;

/**
 * 题目：把数组排成最小的数【需要会证明】
 * 输入一个正整数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例子{3,32,321}----out：321323a
 * <a href="http://wiki.jikexueyuan.com/project/for-offer/question-thirty-three.html">代码借鉴地址</a>---顺便复习下Comparable VS Comparator
 * Created by Administrator on 2017/8/27.
 */
public class SortArrayForMinNumber {

    private static class MComparator implements Comparator<String>{
        @Override
        public int compare(String o1,String o2){
            if(o1==null || o2==null){
                throw new IllegalArgumentException("arg should not be null");
            }

            String s1=o1+o2;
            String s2=o2+o1;
            return s1.compareTo(s2);
        }
    }

    public static String printMinNumber(int[] array){
        if(array==null || array.length==0){
            throw new IllegalArgumentException("Array must contain value");
        }

        String[] str=new String[array.length];
        for(int i=0;i<array.length;i++)
            str[i]=Integer.toString(array[i]);
        return printMinNumber(str);
    }


    private static String printMinNumber(String[] array){
        MComparator comparator=new MComparator();
        quickSort(array,0,array.length-1,comparator);
        StringBuilder sb=new StringBuilder();
        for (String s:array){
            sb.append(s);
        }

        return sb.toString();
    }

    private static void quickSort(String[] array, int start, int end, MComparator comparator) {
        if(start<end){
            String pivot=array[start];
            int left=start;
            int right=end;

            while(start<end){
                while(start<end && comparator.compare(array[end],pivot)>=0) end--;
                array[start]=array[end];
                while(start<end && comparator.compare(array[start],pivot)<=0) start++;
                array[end]=array[start];
            }
            array[start]=pivot;
            quickSort(array,left,start-1,comparator);
            quickSort(array,start+1,end,comparator);
        }
    }

    public static void main(String[] args){
        int[] data={3,32,321};
        System.out.println(printMinNumber(data));
    }//out:321323
}
