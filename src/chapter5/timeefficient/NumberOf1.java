package chapter5.timeefficient;

/**
 * 题目：从1到n整数中1出现的次数
 * 思路值得好好看看
 * Created by Administrator on 2017/8/27.
 */
public class NumberOf1 {

    //算法的时间复杂度为O(logN),相比于暴力算法的O(N*logN)的时间复杂度好些
    public static int numberOf1BetweenAndN(int n){
        if(n<=0)
            return 0;
        String str=n+"";
        return numberOfOne(str);
    }

    private static int numberOfOne(String str){
        char[] strN=str.toCharArray();
        int length=strN.length;
        if(length==1 && strN[0]=='0'){
            return 0;
        }
        if(length==1 && strN[0]>='1'){
            return 1;
        }

        //假设n = 21345

        //numFirstDigit是数字10000 - 19999 的第一个位中的数目:10000
        int numFirstDigit=0;
        if(strN[0]>'1'){
            numFirstDigit=(int) Math.pow(10,length-1);
        }else if(strN[0]=='1'){
            numFirstDigit=Integer.parseInt(str.substring(1))+1;
        }

        //numOtherDigits是1346 - 21345除了第一位之外的数位中的数目:2000*4=8000
        int numOtherDigits=(int) ((strN[0]-'0')*(length-1)*Math.pow(10,length-2));
        //numRecursive是1 - 1345中的数目：821
        int numRecursive=numberOfOne(str.substring(1));

        return numFirstDigit+numOtherDigits+numRecursive;
    }


    public static void main(String[] args){
        System.out.println(numberOf1BetweenAndN(21345));
    }//out:18821
}
