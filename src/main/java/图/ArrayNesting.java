package 图;

public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        int n = arrayNesting.arrayNesting(new int[]{5,2,3,4,1,0});
        System.out.println(n);
    }
}
