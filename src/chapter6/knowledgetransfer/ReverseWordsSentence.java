package chapter6.knowledgetransfer;

/**
 * 题目：翻转单词顺序
 * 描述：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * Created by Administrator on 2017/8/29.
 */
public class ReverseWordsSentence {

    private static String reverse(String str){//字符串的翻转
        if(str==null || str.length()<2)
            return str;

        char[] arr=str.toCharArray();
        char temp;

        for(int i=0;i<arr.length/2;i++){
            temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }

        return String.valueOf(arr);
    }

    public static void  reverseSentence(String sentence){//字符串内的单词进行翻转
        if(sentence==null)
            throw new IllegalArgumentException("arg should not be null");
        else if(sentence.length()<2){
            System.out.println(sentence);
            return;
        }

        String sentenceReverse=reverse(sentence);
        String[] splitStrings=sentenceReverse.split(" ");
        String result="";
        for(String s:splitStrings)
            result=result+reverse(s)+" ";

        System.out.println(result);
    }

    public static void main(String[] args){
        reverseSentence("i am a student. ");
    }//out:  student. a am i      ----注意前面有一个空格
}
