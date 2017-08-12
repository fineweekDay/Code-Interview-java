package chapter4.visual;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 矩阵不一定是方阵
 * Created by Administrator on 2017/8/12.
 */
public class PrintMatrixClockwisely {

    public static void main(String[] args){
//        int[][] array={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] array={{1,2,},{5,6},{9,10}};
        print(array,2,3);
    }//out:1 2 6 10 9 5

    public static void print(int[][] array,int colums,int rows){
        if(array==null || colums<=0 || rows<=0)
            return;

        int start=0;
        
        while (colums>start*2 && rows>start*2){
            printMatrixInCircle(array,colums,rows,start);
            ++start;
        }

    }

    private static void printMatrixInCircle(int[][] array, int colums, int rows, int start) {
        int endX=colums-1-start;
        int endY=rows-1-start;

        //从左到右打印一行
        for(int i=start;i<=endX;i++)
            System.out.print(array[start][i]+" ");

        //从上到下打印一列
        if(start<endY)
            for (int i=start+1;i<=endY;i++)
                System.out.print(array[i][endX]+" ");

        //从右到左打印一行
        if(start<endX && start<endY)
            for (int i=endX-1;i>=start;i--)
                System.out.print(array[endY][i]+" ");

        //从下到上打印一行
        if(start<endX && start<endY-1)
        for(int i=endY-1;i>start;i--)
            System.out.print(array[i][start]+" ");
    }
}
