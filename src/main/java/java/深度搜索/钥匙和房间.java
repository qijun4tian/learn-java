package java.深度搜索;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:qijun
 * @Description https://leetcode-cn.com/leetbook/read/queue-stack/gle1r/
 * @Date 12:27 2022/1/23
 */
public class 钥匙和房间 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(rooms, rooms.get(0), visited);

        return visited.size() == rooms.size();
    }

    public void dfs(List<List<Integer>> rooms, List<Integer> roomIds, Set<Integer> visited) {
        if (roomIds == null || roomIds.size() == 0) {
            return;
        }
        for (Integer roomId : roomIds) {

            if (!visited.contains(roomId)) {
                visited.add(roomId);
                dfs(rooms, rooms.get(roomId), visited);
            }
        }

    }

}
