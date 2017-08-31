package chapter7;

/**
 * 题目：把字符串转换成整数
 * 自己对异常和溢出使用的不够熟练，以下代码来源于github,链接如下
 * <a href="https://github.com/Wang-Jun-Chao/coding-interviews/tree/master/src">代码来源</a>
 * Created by Administrator on 2017/8/30.
 */
public class StringToInt {

    public static int GetStringToInt(String num){
        if(num==null || num.length()<1)
            throw  new NumberFormatException(num);

        char first=num.charAt(0);

        if(first=='-')
            return parseString(num,1,false);
        else if(first=='+')
            return parseString(num,1,true);
        else if(first>='0' && first<='9')
            return parseString(num,0,true);
        else
            throw new NumberFormatException(num);
    }

    private static int parseString(String num, int idx, boolean positive){
        if(idx>=num.length())
            throw new NumberFormatException(num);
        
        int result;
        long temp=0L;//考虑到溢出
        while(idx<num.length() && isDigit(num.charAt(idx))){
            temp=temp*10+(num.charAt(idx)-'0');

            if(temp>0x8000_0000L)
                throw new NumberFormatException(num);

            idx++;
        }

        if(positive){
            if(temp>=0x8000_0000L)
                throw new NumberFormatException(num);
            else
                result=(int) temp;
        }else{
            if(temp==0x8000_0000L)
                result=0x8000_0000;
            else
                result=(int) -temp;
        }

        return result;
    }

    private static boolean isDigit(char c) {
        return  c>='0'&& c<='9';
    }

    public static void main(String[] args){
        String number="-5";
        System.out.println(GetStringToInt(number));
    }//out:5
}
