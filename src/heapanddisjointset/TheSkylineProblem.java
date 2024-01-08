package heapanddisjointset;

import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        // transforming buildings
        for (int[] building : buildings) {          // O(n)
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }

        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);    // O(nlogn)

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);

        int prevMax = 0;

        for (int[] height : heights) {  // O(n)

            if (height[1] < 0) pq.offer(-height[1]);    // takes O(logn)
            else pq.remove(height[1]);                  // takes O(n)

            int currMax = pq.peek();

            if (currMax != prevMax) {
                res.add(Arrays.asList(height[0], currMax));
                prevMax = currMax;
            }
        }

        return res;
        /*BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for(int[] building: buildings) {
          buildingPoints[index] = new BuildingPoint();
          buildingPoints[index].x = building[0];
          buildingPoints[index].isStart = true;
          buildingPoints[index].height = building[2];

          buildingPoints[index+1] = new BuildingPoint();
          buildingPoints[index+1].x = building[1];
          buildingPoints[index+1].isStart = false;
          buildingPoints[index+1].height = building[2];
          index +=2;
        }

        Arrays.sort(buildingPoints);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(0);
        int prevMaxHeight = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for(BuildingPoint buildingPoint : buildingPoints) {
          if(buildingPoint.isStart) {
            queue.add(buildingPoint.height);
          }else {
            queue.remove(buildingPoint.height);
          }
          int currentMaxHeight = queue.peek();
          if(prevMaxHeight != currentMaxHeight) {
            List<Integer> temp = new ArrayList<>();
            temp.add(buildingPoint.x);
            temp.add(currentMaxHeight);
            ans.add(temp);
            prevMaxHeight = currentMaxHeight;
          }
        }
        return ans;*/
    }
}
