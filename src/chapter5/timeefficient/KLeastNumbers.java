package chapter5.timeefficient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 题目：最小的K个数
 * 输入n个整数，找出其中最小的K个数
 * Created by Administrator on 2017/8/27.
 */
public class KLeastNumbers {

    //O(n)的算法，仅当可以修改输入的数组时可用
    public static List<Integer>  getLeastNumbers1(int[] input,int k){
        if(input == null || k<=0)
            return null;

        List<Integer> list = new ArrayList<>();
        if(k > input.length)
            return list;//当k的大小大于当前数组时，直接返回空list

        int low = 0;
        int high = input.length - 1;
        int index = partition(input,low,high);

        while(index != k-1){
            if(index > k-1)
                high = index - 1;
            else
                low = index + 1;

            index = partition(input,low,high);
        }
        for(int i = 0; i < k; i++)
            list.add(input[i]);

        return list;
    }

    private static int partition(int[] array,int start,int end){
        int pivot = array[start];

        while(start < end){
            while(start < end && array[end] >= pivot) end--;
            array[start] = array[end];
            while(start < end && array[start] <= pivot) start++;
            array[end] = array[start];
        }
        array[start] = pivot;

        return start;
    }


    //O(nlogk)的算法，创建大小为k的容器来存储最小的k个数字，
    public static List<Integer> getLeastNumbers2(int[] input,int k){
        if(input == null || k<=0)
            return null;
        List<Integer> list = new ArrayList<>();
        if(k > input.length)
            return list;//当k的大小大于当前数组时，直接返回空list

        Set<Integer> tree = new TreeSet<>();
        for(int i = 0 ; i < input.length; i++){
            tree.add(input[i]);
        }
        int i = 0;
        for(Integer elem : tree){
            if(i >= k)
                break;
            list.add(elem);
            i++;
        }
        return list;
    }

    public static void main(String[] args){
        int[] arr={4,5,1,1,6,2,7,3,8};
//        arr=null;
        List<Integer> list=getLeastNumbers1(arr,4);
//        List<Integer> list=getLeastNumbers2(arr,4);

//        for(int i:arr)
//            System.out.print(i+" ");
//        System.out.println();

        if(list!=null && list.size()>=1){
            for(int i:list)
                System.out.print(i+" ");
            System.out.println();
        }else{
            System.out.println(list);//list.size()=0或list=null;
        }
    }
}
