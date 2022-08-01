package array;

/**
 * @author qijun
 * @date 2022/7/29 17:57
 */
public class Square {


    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {


        return 	   isRec(p1,p2,p3)
                && isRec(p1,p2,p4)
                && isRec(p1,p3,p4)
                && isRec(p2,p3,p4);







    }

    private boolean isRec(int[] p1, int[] p2, int[] p3){
        int value1 = (int)Math.pow((p2[0]-p1[0]),2) + (int)Math.pow((p2[1]-p1[1]),2);

        int value2 = (int)Math.pow((p2[0]-p3[0]),2) + (int)Math.pow((p2[1]-p3[1]),2);

        int value3 = (int)Math.pow((p1[0]-p3[0]),2) + (int)Math.pow((p1[1]-p3[1]),2);

        if(value1 == value2 && (value1 + value2) == value3){
            return true;

        }else if(value1 == value3 && (value1 + value3) == value2){
            return true;

        }else if(value2 == value3 && (value2 + value3) == value1){
            return true;

        }
        return false;



    }
}
