import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @date 2022/7/13 18:44
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList();
        int count = 0;
        for(int i = 0; i < asteroids.length; i++){
            int a = asteroids[i];
            if(a < 0){
                boolean isPositive = false;
                while(!isPositive && deque.size() != 0){
                    int p = deque.pop();
                    if(Math.abs(asteroids[p]) > Math.abs(asteroids[i])){
                        deque.push(p);
                        asteroids[i] = 0;
                        count++;
                        isPositive = true;

                    }else if(Math.abs(asteroids[p]) == Math.abs(asteroids[i])){
                        asteroids[i] = 0;
                        asteroids[p] = 0;
                        count +=2;
                        isPositive = true;
                    }else{
                        asteroids[p] = 0;
                        count++;
                    }

                }

            }else {
                deque.push(i);


            }

        }
        int[] result = new int[asteroids.length - count];
        int i = 0;

        for(int a : asteroids){
            if(a != 0){
                result[i++] = a;

            }

        }
        return result;

    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        asteroidCollision.asteroidCollision(new int[]{5,10,-5});
    }





}
