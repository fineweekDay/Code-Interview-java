package chapter2.ds;

/**
 * 延伸题目：合并两个有序（假设升序）数组（A1，A2,且A1有足够空间容纳A2）
 * PS：这道题和原地归并原理相似
 * Created by Administrator on 2017/8/10.
 */
public class MergeOrderList {

    public static void main(String[] args){
        //a1有足够的容量容纳a2,现在用0代表未利用的空间
        int[] a1={1,2,5,6,10,11,15,0,0,0,0,0,0,0,0,0,0,0};
        int[] a2={2,3,6,8,9};
        int countA=7,countB=5;
        merge(a1,a2,countA,countB);//进行合并

        for(int i=0;i<countA+countB;i++)
            System.out.print(a1[i]+" ");
        System.out.println();
    }

    private static void merge(int[] a1, int[] a2, int countA,int countB) {
        //这里单纯进行分析，暂且排除null,0长度等情况
        int index1=countA-1,index2=countB-1;
        for(int i=countA+countB-1;i>=0;i--){
            if(index1<0){
                a1[i]=a2[index2--];
            } else if(index2<0){
                a1[i]=a1[index1--];
            } else if(a1[index1]>a2[index2]){
                a1[i]=a1[index1--];
            }else{
                a1[i]=a2[index2--];
            }
        }
    }
}
