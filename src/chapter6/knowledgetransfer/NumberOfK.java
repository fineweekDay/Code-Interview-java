package chapter6.knowledgetransfer;

/**
 * 题目：数字在排序数组中出现的次数
 * Created by Administrator on 2017/8/28.
 */
public class NumberOfK {

    //时间复杂度为O(logN)
    public static int GetNumberOfK(int[] data,int k){
        int number=0;

        if(data!=null && data.length>0){
            int first=GetFirstK(data,k,0,data.length-1);
            int last;
            if(first>-1){
                last=GetLastK(data,k,first+1,data.length-1);
                if(last>-1)
                    number=last-first+1;
                else
                    number=1;
            }
        }

        return number;
    }

    private static int GetFirstK(int[] data, int k, int start, int end) {
        if(start>end || start<0 || end>data.length-1)
            return -1;

        int midIndex=(start+end)/2;
        int midData=data[midIndex];

        if(midData==k){
            if((midIndex>0 && data[midIndex-1]!=k) ||midIndex==0)
                return midIndex;
            else
                end=midIndex-1;
        }else if(midData<k)
            start=midIndex+1;
        else
            end=midIndex-1;

        return GetFirstK(data,k,start,end);
    }

    private static int GetLastK(int[] data, int k, int start, int end) {
        if(start>end || start<0 || end>data.length-1)
            return -1;

        int midIndex=(start+end)/2;
        int midData=data[midIndex];

        if(midData==k){
            if((midIndex<data.length-1 && data[midIndex+1]!=k) ||midIndex==data.length-1)
                return midIndex;
            else
                start=midIndex+1;
        }else if(midData<k)
            start=midIndex+1;
        else
            end=midIndex-1;

        return GetLastK(data,k,start,end);
    }

    public static void main(String[] args){
        int[] data={1,2,3,3,3,3,4,5,};
        System.out.println(GetNumberOfK(data,3));
    }//out:4
}
