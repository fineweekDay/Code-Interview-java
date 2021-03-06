package chapter2.dm;

/**
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * Created by Administrator on 2017/8/11.
 */
public class MinNumberInRotatedArray {

    public static void main(String[] args){
        int[] numbers={3,4,5,6,1,2,};
        try {
            System.out.println(Min1(numbers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //剑指OFFER上提供的思路（最终版）:二分法
    public static int Min1(int[] numbers) throws Exception {
        if(numbers==null || numbers.length==0)
            throw new Exception();

        int index1=0;
        int index2=numbers.length-1;
        int indexMid=index1;

        while(numbers[index1]>=numbers[index2]){
            if(index2-index1==1){
                indexMid=index2;
                break;
            }

            indexMid=(index1+index2)/2;

            if(numbers[index1]==numbers[index2] && numbers[index1]==numbers[indexMid]){
                return MinInOrder(numbers,index1,index2);
            }
            if (numbers[indexMid]<=numbers[index2])
                index2=indexMid;
            else if(numbers[indexMid]>=numbers[index1])
                index1=indexMid;
        }

        return numbers[indexMid];
    }

    private static int MinInOrder(int[] numbers, int index1, int index2){
        int result=numbers[index1];

        for(int i=index1+1;i<=index2;i++)
            if(result>numbers[i])
                result=numbers[i];
        return result;
    }


    //剑指OFFER上提供的思路:二分法
    //缺陷：当两个指针指向的数字以及他们中间的数字三者都相同时，
    // 我们无法按照此法缩小范围，此时，不得不采用顺序查找。
    //所以最终版本是Min1方法
//    public static int Min(int[] numbers) throws Exception {
//        该方法只能得到部分数组的最小值
//        if(numbers==null || numbers.length==0)
//            throw new Exception();
//
//        int index1=0;
//        int index2=numbers.length-1;
//        int indexMid=index1;
//
//        while(numbers[index1]>=numbers[index2]){
//            if(index2-index1==1){
//                indexMid=index2;
//                break;
//            }
//            indexMid=(index1+index2)/2;
//            if(numbers[indexMid]>=numbers[index1]){
//                index1=indexMid;
//            }else if (numbers[indexMid]<=numbers[index2]){
//                index2=indexMid;
//            }
//        }
//        return numbers[indexMid];
//    }

//    /**
//     * 一个常规的套路如下（完全顺序查找）,但是效果不如二分法
//     * @param numbers 一个递增排序数组的一个旋转
//     * @return 最小数
//     */
//    public int Min(int[] numbers) throws Exception {
//        if(numbers==null || numbers.length==0)
//            throw new Exception();
//        else if(numbers.length==1)
//            return numbers[0];
//        else{
//            for(int i=1;i<numbers.length;i++){
//                if(numbers[i]<numbers[i-1])
//                    return numbers[i];
//            }
//            return numbers[0];
//        }
//    }
}
