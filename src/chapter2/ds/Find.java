package chapter2.ds;

/**
 * Created by Administrator on 2017/8/10.
 */
public class Find {

    public static void main(String[] args){
        int[][] nums={{1,2,8,9},{2,4,9,12},{4,7,10,13},
                {6,8,11,15}};
        int number=7;
        System.out.println(findNumber(nums,number));
    }

    public static boolean findNumber(int[][] numbers,int number){
        //numbers是一个二维矩阵，且数字大小横向增长，纵向增长

        if(numbers==null)
            return false;

        int rows=numbers.length;
        int columns=numbers[0].length;

        int ind1=0,ind2=columns-1;

        while(ind1>=0 && ind1<rows && ind2>=0 && ind2<columns){
            int tNumber=numbers[ind1][ind2];
            if(tNumber>number)
                ind2--;
            else if(tNumber<number)
                ind1++;
            else
                return true;
        }

        return false;
    }
}
