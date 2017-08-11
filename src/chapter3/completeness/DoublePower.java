package chapter3.completeness;

/**
 * 题目：实现数值的整数次方运算
 * Created by Administrator on 2017/8/11.
 */
public class DoublePower {

    public static void main(String[] args){
        try {
            System.out.println(power(5.0,-2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//out:0.04000000000000001

    public static double power(double base,int exponent) throws Exception {
        double result;

        if(equal(base,0.0) && exponent<0) {
            throw new Exception();//其实不抛出异常也可以，输出结果就是Infinity
        }

        if(exponent<0)
            result= powerWithExponent(1.0/base, -exponent);
        else if(exponent>0)
            result = powerWithExponent(base,exponent);
        else
            return 1.0;

        return result;
    }

    private static double powerWithExponent(double base, int exponent) {
        if(exponent==0)
            return 1.0;

        if(exponent == 1)
            return base;

        double result = powerWithExponent(base,exponent >>1);
        result *= result;
        if((exponent & 0x1) == 1) //主要作用是为奇数次方服务
            result *=base;

        return result;
    }

    private static boolean equal(double number1, double number2) {
        //误差在一定范围内则认为是相等的
        if((number1-number2)>-0.0000001 && (number1-number2)<0.0000001)
            return true;
        else
            return false;
    }
}
