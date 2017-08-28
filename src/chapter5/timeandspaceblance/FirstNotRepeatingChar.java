package chapter5.timeandspaceblance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目：第一个只出现一次的字符
 * 在字符串中找出第一个只出现一次的字符。
 * 输入"abaccdeff"--out:'b'
 * Created by Administrator on 2017/8/28.
 */
public class FirstNotRepeatingChar {

    public static Character GetFirstNotRepeatingChar(String s){
        if(s.length()==0 || s==null)
            return null;

        char[] strChar=s.toCharArray();
        Map<Character,Integer> map=new LinkedHashMap<>();//这里不能用HashMap，用LinkedHashMap才能保证顺序

        for(char item:strChar){
            if(map.containsKey(item))
                map.put(item,map.get(item)+1);
            else
                map.put(item,1);
        }

        for(char key:map.keySet()){
            if(map.get(key)==1)
                return key;
        }

        return null;
    }

    public static void main(String[] args){
        System.out.println(GetFirstNotRepeatingChar("abaccdeff"));
    }//out:b
}
