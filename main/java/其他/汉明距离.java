package 其他;

/**
 * @Author:qijun
 * @Description
 * @Date 9:56 2021/12/12
 */
public class 汉明距离 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
