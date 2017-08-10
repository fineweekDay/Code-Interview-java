package chapter2.ds;

/**
 * 题目：将字符串中的空格替换成%20
 * Created by Administrator on 2017/8/10.
 */
public class ReplaceBlank {

    public static void main(String[] args){
        String testString=" Hello my  world  ";
        System.out.println(replace(testString));
    }



    // 剑指OFFER上提供的解法
    public static String replace(String s){
        if(s==null)
            return null;
        else if(s.length()==0)
            return s;

        int length=s.length(); //字符数组初始长度
        int newLength=length+2*getBlankNum(s);//替换空格后长度
        char[] tempArray=new char[newLength];
        System.arraycopy(s.toCharArray(), 0, tempArray, 0, s.toCharArray().length);

        int indexodoriginal=length-1,indexofNew=newLength-1;
        while(indexodoriginal>=0 && indexodoriginal!=indexofNew){
            if(tempArray[indexodoriginal]==' '){
                tempArray[indexofNew--]='0';
                tempArray[indexofNew--]='2';
                tempArray[indexofNew--]='%';
            }else{
                tempArray[indexofNew--]=tempArray[indexodoriginal];
            }
            indexodoriginal--;
        }
        return new String(tempArray);
    }

    //计算下有多少个空格
    private static int getBlankNum(String s){
        int count=0;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                count++;
        }
        return count;
    }



//   遍历字符串的解法
//    public static String replace(String s){
//        if(s==null)
//            return null;
//        else if(s.length()==0)
//            return s;
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<s.length();i++){
//            char index=s.charAt(i);
//            if(index==' ')
//                sb.append("%20");
//            else
//                sb.append(index);
//        }
//        return sb.toString();
//    }

//    利用正则表达式进行替换的解法
//    public static String replace(String s){
//        if(s==null)
//            return null;
//        else if(s.length()==0)
//            return s;
//        return s.replaceAll("\\s","%20");
//    }

}
