package myArray;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 *https://leetcode.cn/problems/closest-room/description/
 * 最近的房间
 */
public class ClosestRoom {

    public static void main(String[] args) {
//        String roomStr = "[[2,2],[1,2],[3,2]]";
//        String queryStr = "[[3,1],[3,3],[5,2]]";

//        String roomStr = "[[1,4],[2,3],[3,5],[4,1],[5,2]]";
//        String queryStr = "[[2,3],[2,4],[2,5]]";

        String roomStr = "[[173,397],[281,320],[415,181],[497,269],[77,285],[321,104],[385,43],[391,351],[371,287],[107,305],[247,187],[430,240],[465,321],[481,215],[1,423],[304,465],[411,176],[474,253],[219,225],[433,443],[106,365],[94,261],[135,187],[401,117],[181,276],[201,137],[461,312],[35,421],[13,307],[489,375],[69,253],[9,186],[89,164],[145,217],[331,183],[326,281],[271,429],[454,466],[153,297],[177,321],[49,381],[156,126],[117,321],[75,220],[493,71],[445,231],[263,425],[178,146],[4,131],[324,159],[5,491],[381,441],[183,73],[380,487],[192,322],[405,141],[150,301],[91,346],[100,287],[197,425],[292,391],[357,89],[486,281],[203,201],[484,429],[289,264],[17,486],[157,447],[134,67],[6,425],[237,47],[71,359],[196,467],[267,25],[265,493],[417,116],[368,191],[233,242],[207,359],[167,193],[386,306],[211,201],[22,1],[36,101],[152,171],[33,315],[351,429],[492,313],[397,267],[341,197],[161,221],[198,349],[470,405],[473,308],[301,129],[224,285],[307,137],[165,371],[337,201],[151,445]]";
        String queryStr = "[[73,1]]";
        int[][] rooms = ArrayUtils.stringTo2DArray(roomStr);
        int[][] query = ArrayUtils.stringTo2DArray(queryStr);

        System.out.println(Arrays.toString(closestRoom(rooms, query)));

        System.out.println(Arrays.toString(closestRoom1(rooms, query)));
    }

    public static int[] closestRoom1(int[][] rooms, int[][] queries) {

        // 按照 size 从大到小排序
        Arrays.sort(rooms, (a, b) -> (b[1] - a[1]));

        int q = queries.length;
        Integer[] queryIds = new Integer[q];
        Arrays.setAll(queryIds, i -> i);
        // 按照 minSize 从大到小排序
        Arrays.sort(queryIds, (i, j) -> queries[j][1] - queries[i][1]);

        int[] ans = new int[q];
        Arrays.fill(ans, -1);
        TreeSet<Integer> roomIds = new TreeSet<>();
        int j = 0;
        for (int i : queryIds) {
            int preferredId = queries[i][0];
            int minSize = queries[i][1];
            while (j < rooms.length && rooms[j][1] >= minSize) {
                roomIds.add(rooms[j][0]);
                j++;
            }

            int diff = Integer.MAX_VALUE;
            Integer floor = roomIds.floor(preferredId);
            if (floor != null) {
                diff = preferredId - floor; // 左边的差
                ans[i] = floor;
            }
            Integer ceiling = roomIds.ceiling(preferredId);
            if (ceiling != null && ceiling - preferredId < diff) { // 右边的差更小
                ans[i] = ceiling;
            }
        }
        return ans;
    }


    public static int[] closestRoom(int[][] rooms, int[][] queries) {

        int[] res = new int[queries.length];
        if (rooms == null || rooms.length == 0) return res;
        if (queries == null || queries.length == 0) return res;

        Arrays.sort(rooms, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int preferredj =  query[0];
            int minSize =  query[1];

            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < rooms.length; j++) {
                int[] room = rooms[j];
                int index = room[0];
                int roomSize = room[1];

                if (roomSize >= minSize){
                  int abs = Math.abs(index - preferredj);
                  if (abs < min){
                      min = abs;
                      minIndex = index;
                  }else if (abs == min){
                      min = abs;
                      minIndex = minIndex < index ? minIndex : index;
                  }
                }
            }
            res[i] = minIndex;
        }
        return  res;
    }
}
