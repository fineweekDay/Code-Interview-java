package chapter6.knowledgetransfer;

/**
 * 题目：字符串的左旋转
 * 描述：把字符串前面的若干个字符转移到字符串的尾部。
 * 例子："abcdefg"---> "cdefgab"
 * Created by Administrator on 2017/8/29.
 */
public class LeftRotateString {

    public static String GetLeftRotateString(String str,int n){
        if(str==null || str.length()<2 || str.length()<=n || n==0)
            return str;

        char[] arr=str.toCharArray();

        //以"abcdefg",3为例
        reverse(arr,0,n-1);//翻转前n位：cbadefg
        reverse(arr,n,arr.length-1);//翻转后面的位：cbagfed
        reverse(arr,0,arr.length-1);//整体翻转：defgabc

        return String.valueOf(arr);
    }

    private static void reverse(char[] arr, int start, int end) {
        char temp;
        while(start<end){
            temp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=temp;
        }
    }

    public static void main(String[] args){
        System.out.println(GetLeftRotateString("abcedfg",3));
    }//out:defgabc
}
