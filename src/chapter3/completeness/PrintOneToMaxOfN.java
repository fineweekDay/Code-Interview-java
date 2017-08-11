package chapter3.completeness;

/**
 * 题目：打印1到最大的n位数
 * Created by Administrator on 2017/8/11.
 */
public class PrintOneToMaxOfN {

    public static void main(String[] args) {
        int[] number=new int[3];
        try {
            while(!increment(number)){
                printNumber(number);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //剑指OFFER解法
    public static boolean increment(int[] number) throws Exception {
        if(number.length==0 ||number==null)
            throw new Exception();

        boolean isOverFlow=false;
        int carry=0;

        for(int i=number.length-1;i>=0;i--){
            int nSum=number[i]+carry;
            if(i==number.length-1)
                nSum++;

            if(nSum>=10){
                if(i==0)
                    isOverFlow=true;
                else{
                    nSum-=10;
                    carry=1;
                    number[i]=nSum;
                }
            }else{
                number[i]=nSum;
                break;
            }
        }

        return isOverFlow;
    }

    public static void printNumber(int[] number){
        boolean isBeginning=true;

//        System.out.println(Arrays.toString(number));

        for(int i=0;i<number.length;i++){
            if(isBeginning && number[i]!=0)
                isBeginning=false;
            if(!isBeginning)
                System.out.print(number[i]);
        }
    }
}
